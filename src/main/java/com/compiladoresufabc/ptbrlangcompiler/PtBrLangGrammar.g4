grammar PtBrLangGrammar;

@header {
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;
import com.compiladoresufabc.ptbrlangcompiler.domains.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.errors.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.generator.*;
}

@members {
    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
    private ArrayList<Var> currentDecl = new ArrayList<Var>();
    private Types currentType;
    private Types leftType=null, rightType=null;
    private Program program = new Program();
    private String strExpr = "";
    private IfCommand currentIfCommand;
    
    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
    
    
    public void updateType(){
    	for(Var v: currentDecl){
    	   v.setType(currentType);
    	   symbolTable.put(v.getId(), v);
    	}
    }
    public void exibirVar(){
        for (String id: symbolTable.keySet()){
        	System.out.println(symbolTable.get(id));
        }
    }
    
    public Program getProgram(){
    	return this.program;
    	}
    
    public boolean isDeclared(String id){
    	return symbolTable.get(id) != null;
    }
}
 
programa	: 'programa' ID  { program.setName(_input.LT(-1).getText());
                               stack.push(new ArrayList<Command>()); 
                             }
               declaravar+
               'inicio'
               comando+
               'fim'
               'fimprograma'
               
               {
                  program.setSymbolTable(symbolTable);
                  program.setCommandList(stack.pop());
               }
			;
						
declaravar	: 'declare' { currentDecl.clear(); } 
               ID  { currentDecl.add(new Var(_input.LT(-1).getText()));}
               ( VIRG ID                
              		 { currentDecl.add(new Var(_input.LT(-1).getText()));}
               )*	 
               DP 
               (
               'number' {currentType = Types.NUMBER;}
               |
               'text' {currentType = Types.TEXT;}
               ) 
               
               { updateType(); } 
               PV
			;
			
comando     :  cmdAttrib
			|  cmdLeitura
			|  cmdEscrita
			|  cmdIF
			;
			
cmdIF		: 'se'  { stack.push(new ArrayList<Command>());
                      strExpr = "";
                      currentIfCommand = new IfCommand();
                    } 
               AP 
               expr
               OPREL  { strExpr += _input.LT(-1).getText(); }
               expr
               FP  { currentIfCommand.setExpression(strExpr); }
               'entao'  
               comando+                
               { 
                  currentIfCommand.setTrueList(stack.pop());                            
               }  
               ( 'senao'  
                  { stack.push(new ArrayList<Command>()); }
                 comando+
                 {
                   currentIfCommand.setFalseList(stack.pop());
                 }  
               )? 
               'fimse' 
               {
               	   stack.peek().add(currentIfCommand);
               }  			   
			;
			
cmdAttrib   : ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                   }
                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
                 }
              OP_AT 
              expr 
              PV
              
              {
                 System.out.println("Left  Side Expression Type = "+leftType);
                 System.out.println("Right Side Expression Type = "+rightType);
                 if (leftType.getValue() < rightType.getValue()){
                    throw new SemanticException("Type Mismatchig on Assignment");
                 }
              }
			;			
			
cmdLeitura  : 'leia' AP 
               ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                    }
                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
                    stack.peek().add(cmdRead);
                  } 
               FP 
               PV 
			;
			
cmdEscrita  : 'escreva' AP 
              ( termo  { Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
                         stack.peek().add(cmdWrite);
                       } 
              ) 
              FP PV { rightType = null;}
			;			

			
expr		:  termo  { strExpr += _input.LT(-1).getText(); } exprl 			
			;
			
termo		: ID  { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                    }
                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
                       throw new SemanticException("Variable "+_input.LT(-1).getText()+" has no value assigned");
                    }
                    if (rightType == null){
                       rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                    }   
                    else{
                       if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
                          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                          
                       }
                    }
                  }   
			| NUM    {  if (rightType == null) {
			 				rightType = Types.NUMBER;
			            }
			            else{
			                if (rightType.getValue() < Types.NUMBER.getValue()){			                    			                   
			                	rightType = Types.NUMBER;
			                }
			            }
			         }
			| TEXTO  {  if (rightType == null) {
			 				rightType = Types.TEXT;
			            }
			            else{
			                if (rightType.getValue() < Types.TEXT.getValue()){			                    
			                	rightType = Types.TEXT;
			                	
			                }
			            }
			         }
			;
			
exprl		: ( OP { strExpr += _input.LT(-1).getText(); } 
                termo { strExpr += _input.LT(-1).getText(); } 
              ) *
			;	
			
OP			: '+' | '-' | '*' | '/' 
			;	
			
OP_AT	    : ':='
		    ;
		    
OPREL       : '>' | '<' | '>=' | '<= ' | '<>' | '=='
			;		    			
			
ID			: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;
			
NUM			: [0-9]+ ('.' [0-9]+ )?
			;			
			
VIRG		: ','
			;
						
PV			: ';'
            ;			
            
AP			: '('
			;            
						
FP			: ')'
			;
									
DP			: ':'
		    ;

AND			: '&&'
			;

OR			: '||'
			;
		    
TEXTO       : '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-' )* '"'
			;		    
		    			
WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
			;