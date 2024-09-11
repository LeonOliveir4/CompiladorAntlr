grammar PtBrLangGrammar;

@header {
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;
import com.compiladoresufabc.ptbrlangcompiler.domains.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.errors.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.generator.*;
import com.compiladoresufabc.ptbrlangcompiler.runtime.*;
}

@members {
    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
    private ArrayList<Var> currentDecl = new ArrayList<Var>();
    private Types currentType;
    private Types leftType=null, rightType=null;
    private Program program = new Program();
    private String strExpr = "";
    private ArrayList<String> exprList;
    private String strOp = "";
    private IfCommand currentIfCommand;
    private WhileCommand whileCommand;
    private AtribCommand atribCommand;
    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
    private Stack<AbstractExpression> exprStack = new Stack<AbstractExpression>();
    private AbstractExpression top = null;

    public double generateValue(){
        if (top == null){
            top = exprStack.pop();
        }
        return top.evaluate();
    }

    public String generateJSON(){
        if (top == null){
            top = exprStack.pop();
        }
        return top.toJSON();
    }

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
    
    public void checkUnusedVariables() {
		String yellowColor = "\u001B[33m";
    	String resetColor = "\u001B[0m";
        for (Var var : symbolTable.values()) {
            if ((var.isInitialized() && !var.isUsed()) || !(var.isInitialized() && var.isUsed())) {
                System.out.println(yellowColor + "Warning: Variable '" + var.getId() + "' initialized/declared but never used." + resetColor);
            }
        }
    }
}

programa	: 'programa' CLASS  { program.setName(_input.LT(-1).getText());
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
                  checkUnusedVariables();
               }
            ;

declaravar
    : 'declare' { currentDecl.clear(); }
      ID  {
          if (isDeclared(_input.LT(-1).getText())) {
              throw new SemanticException("Variable '" + _input.LT(-1).getText() + "' already declared at line " 
              + _input.LT(-1).getLine() + ", column " + _input.LT(-1).getCharPositionInLine() + ".");
          }
          currentDecl.add(new Var(_input.LT(-1).getText()));
      }
      ( VIRG ID
        {
          if (isDeclared(_input.LT(-1).getText())) {
              throw new SemanticException("Variable '" + _input.LT(-1).getText() + "' already declared at line " 
              + _input.LT(-1).getLine() + ", column " + _input.LT(-1).getCharPositionInLine() + ".");
          }
          currentDecl.add(new Var(_input.LT(-1).getText()));
        }
      )*
      DP
      (
        'number' {currentType = Types.NUMBER;}
        |
        'text' {currentType = Types.TEXT;}
        |
        'bool' {currentType = Types.BOOL;}
      )
      { updateType(); }
      PV
    ;

comando     :  cmdAttrib
            |  cmdLeitura
            |  cmdEscrita
            |  cmdIF
            |  cmdWhile
            |  cmdWhileReverse
            ;

cmdIF		: 'se'  { stack.push(new ArrayList<Command>());
                      exprList = new ArrayList<>();
                      currentIfCommand = new IfCommand();
                    }
               AP
               exprList {
				          for (String var : exprList) {
				              if (symbolTable.containsKey(var)) {
				                  symbolTable.get(var).setUsed(true);
				              }
				          }
				          
				        if (exprList.isEmpty() || exprList.get(0).trim().isEmpty()) {
							throw new SemanticException("Missing or invalid condition in 'if' statement at line " + _input.LT(1).getLine() + ".");
						}
				      }
               FP  {
                     if (exprList.size() == 1 && leftType != Types.BOOL) {
                        throw new SemanticException("Single expression '" + exprList.get(0) + "' in condition must be boolean at line "
                        + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
                     }
                     currentIfCommand.setExpressions(exprList);
                   }
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

cmdWhile	: 'enquanto' { stack.push(new ArrayList<Command>());
                      exprList = new ArrayList<>();
                      whileCommand = new WhileCommand(false);
                    }
                   AP
                   exprList {
				          for (String var : exprList) {
				              if (symbolTable.containsKey(var)) {
				                  symbolTable.get(var).setUsed(true);
				              }
				          }
				          
				        if (exprList.isEmpty() || exprList.get(0).trim().isEmpty()) {
				          throw new SemanticException("Missing or invalid condition in 'while' statement at line " + _input.LT(1).getLine() + ".");
				        }
				      }
                   FP	{
                                    if (exprList.size() == 1 && leftType != Types.BOOL) {
                                       throw new SemanticException("Single expression '" + exprList.get(0) + "' in condition must be boolean at line " + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
                                    }
                                    whileCommand.setExpressions(exprList);
                                }
                   'faca'
                   comando+ {whileCommand.setTrueList(stack.pop());}
                   'fimenquanto'
                   {
                               stack.peek().add(whileCommand);
                               }
              ;

cmdWhileReverse	: 'faca' { stack.push(new ArrayList<Command>());
          exprList = new ArrayList<>();
          whileCommand = new WhileCommand(true);
      }
     comando+ {whileCommand.setTrueList(stack.pop());}
     'enquanto' { strExpr = "";}
     AP
     exprList {
	          for (String var : exprList) {
	              if (symbolTable.containsKey(var)) {
	                  symbolTable.get(var).setUsed(true);
	              }
	          }
	          
	        if (exprList.isEmpty() || exprList.get(0).trim().isEmpty()) {
				throw new SemanticException("Missing or invalid condition in 'do-while' statement at line " + _input.LT(1).getLine() + ".");
			}
	      }
     FP  {
                        if (exprList.size() == 1 && leftType != Types.BOOL) {
                           throw new SemanticException("Single expression '" + exprList.get(0) + "' in condition must be boolean at line " + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
                        }
                        whileCommand.setExpressions(exprList);
                    }
     'fimenquanto'
     {
                   stack.peek().add(whileCommand);
                 }
   ;

cmdAttrib
    : ID {
          strExpr = "";
          if (!isDeclared(_input.LT(-1).getText())) {
              throw new SemanticException("Undeclared Variable During assignment: " + _input.LT(-1).getText());
          }
          symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
          symbolTable.get(_input.LT(-1).getText()).setUsed(true);
          leftType = symbolTable.get(_input.LT(-1).getText()).getType();
          atribCommand = new AtribCommand(symbolTable.get(_input.LT(-1).getText()));
      }
      OP_AT {
          strOp = _input.LT(-1).getText();
          atribCommand.setStrOp(strOp);
      }
      expr {
          atribCommand.setExprString(strExpr);

          if (strOp.equalsIgnoreCase("++") || strOp.equalsIgnoreCase("--")) {
              System.out.println("Left  Side Expression Type = " + leftType);
              if (leftType != Types.NUMBER) {
                  throw new SemanticException("Operator " + strOp + " is only allowed for numeric variables at line "
                      + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
              }
              atribCommand.setExprString(null);
          }

          else if (strOp.equalsIgnoreCase("+=") || strOp.equalsIgnoreCase("-=")) {
              System.out.println("Left Side Expression Type = " + leftType);
              System.out.println("Right Side Expression Type = " + rightType);
              if (leftType != Types.NUMBER || rightType != Types.NUMBER) {
                  throw new SemanticException("Operator " + strOp + " requires both sides to be numeric at line "
                      + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
              }
              stack.peek().add(atribCommand);
          }

          else {
              System.out.println("Left Side Expression Type = " + leftType);
              System.out.println("Right Side Expression Type = " + rightType);

              if (!((leftType == Types.NUMBER && rightType == Types.NUMBER) ||
                    (leftType == Types.TEXT && rightType == Types.TEXT) ||
                    (leftType == Types.BOOL && rightType == Types.BOOL))) {
                  throw new SemanticException("Type mismatch: cannot assign '" + rightType + "' to variable of type '" + leftType + "' at line "
                      + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
              }
              stack.peek().add(atribCommand);
          }
      }
      PV;


cmdLeitura
    : 'leia' AP
        ID {
            if (!isDeclared(_input.LT(-1).getText())) {
                throw new SemanticException("Undeclared Variable During reading: " + _input.LT(-1).getText());
            }
            symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
            symbolTable.get(_input.LT(-1).getText()).setUsed(true);
            Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
            stack.peek().add(cmdRead);
        }
    FP PV;

cmdEscrita  : 'escreva' AP
              ( termo  { 
					        String content = _input.LT(-1).getText();
					            
					        if (!content.startsWith("\"")) {
					            Types varType = symbolTable.get(content).getType();
					            Command cmdWrite = new WriteCommand(content, varType);
					            stack.peek().add(cmdWrite);
					        } else {
					            Command cmdWrite = new WriteCommand(content, Types.TEXT);
					            stack.peek().add(cmdWrite);
					        }
					    }
				    )
              FP PV { rightType = null;}
   ;


expr returns [Types type]
    : termo {
        $type = rightType;
      }
      (exprl)*
    ;

exprl returns [Types type]
    : (OP_SUM | OP_SUB) {
          strExpr += _input.LT(-1).getText();
          BinaryExpression bin = new BinaryExpression(_input.LT(-1).getText().charAt(0));
          bin.setLeft(exprStack.pop());
          exprStack.push(bin);
      }
      termo {
          AbstractExpression top = exprStack.pop();
          BinaryExpression root = (BinaryExpression)exprStack.pop();
          root.setRight(top);
          exprStack.push(root);

          if (leftType != rightType) {
            if (!(leftType == Types.BOOL && rightType == null))
              throw new SemanticException("Type mismatch: incompatible types '" + leftType + "' and '" + rightType + "' in operation at line "
              + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ". Expression: " + _input.LT(1).getText());
          }
          leftType = rightType;
          System.out.println("Expression value " + root.evaluate());
          System.out.println(root.toJSON());
      }
    ;

termo returns [Types type]
    : fator {
		strExpr += _input.LT(-1).getText();
        $type = rightType;
      }
      (termol[$type])*
    ;

termol[Types inheritedType] returns [Types type]
    : (OP_MUL | OP_DIV) {
          strExpr += _input.LT(-1).getText();
          BinaryExpression bin = new BinaryExpression(_input.LT(-1).getText().charAt(0));
          bin.setLeft(exprStack.pop());
          exprStack.push(bin);
      }
      termo {
          AbstractExpression rightExpr = exprStack.pop();
          BinaryExpression root = (BinaryExpression) exprStack.pop();
          root.setRight(rightExpr);
          exprStack.push(root);

          if (leftType != rightType) {
            if (!(leftType == Types.BOOL && rightType == null))
             throw new SemanticException("Type mismatch: incompatible types '" + leftType + "' and '" + rightType + "' in operation at line "
             + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ". Expression: " + _input.LT(1).getText());
          }
          $type = rightType;
          System.out.println("Expression value " + root.evaluate());
          System.out.println(root.toJSON());
      }
    ;

fator returns [Types type]
    : ID {
          if (!isDeclared(_input.LT(-1).getText())) {
              throw new SemanticException("Undeclared Variable During term: " + _input.LT(-1).getText());
          }
          if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
              throw new SemanticException("Variable " + _input.LT(-1).getText() + " has no value assigned");
          }
          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
      }
    | NUM {
          exprStack.push(new UnaryExpression(Double.parseDouble($NUM.text)));
          rightType = Types.NUMBER;
      }
    | TEXTO {
          exprStack.push(new UnaryExpression($TEXTO.text));  // Texto como string literal
          rightType = Types.TEXT;
      }
    | BOOL {
          exprStack.push(new UnaryExpression(Boolean.parseBoolean($BOOL.text)));
          rightType = Types.BOOL;
      }
    ;


exprList
    : {
        leftType = null;
        rightType = null;
        ArrayList<String> auxList = new ArrayList<>();
      }
      e=expr {
        exprList.add($e.text);
        auxList.add($e.text);
        leftType = $e.type;
      }
      (
        (OPREL {
            exprList.add(_input.LT(-1).getText());
            
            if (_input.LT(-1).getText().matches("[<>]=?") && leftType != Types.NUMBER) {
                throw new SemanticException("Operator '" + _input.LT(-1).getText() + "' can only be applied to numeric types at line " + _input.LT(1).getLine());
            }
          }
          e2=expr {
            exprList.add($e2.text);
            auxList.add($e2.text);
            rightType = $e2.type;

            if (leftType != rightType) {
                if (!(leftType == Types.BOOL && rightType == null))
                    throw new SemanticException("Type mismatch: cannot compare '" + leftType + "' with '" + rightType + "' in expression '" +  $e.text + "' and '" +  $e2.text + "' at line "
                    + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
            }

          }
        ) {
        if (auxList.size() == 1 && leftType != Types.BOOL) {
            throw new SemanticException("Single expression '" + auxList.get(0) + "' in condition must be boolean at line " + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
        }
      }
      | (op=AND | op=OR) {
            exprList.add($op.text);
            auxList.clear();
        }
        e3=expr {
            exprList.add($e3.text);
            auxList.add($e3.text);
            leftType = $e3.type;
        }

        (OPREL {
            exprList.add(_input.LT(-1).getText());
            
            if (_input.LT(-1).getText().matches("[<>]=?") && leftType != Types.NUMBER) {
                throw new SemanticException("Operator '" + _input.LT(-1).getText() + "' can only be applied to numeric types at line " + _input.LT(1).getLine());
            }
          }
          e4=expr {
            exprList.add($e4.text);
            auxList.add($e4.text);
            rightType = $e4.type;

            if (leftType != rightType) {
                if (!(leftType == Types.BOOL && rightType == null))
                    throw new SemanticException("Type mismatch: cannot compare '" + leftType + "' with '" + rightType + "' in expression '" +  $e3.text + "' and '" +  $e4.text + "' at line "
                    + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
            }

          }
        )? {
        if (auxList.size() == 1 && leftType != Types.BOOL) {
            throw new SemanticException("Single expression '" + auxList.get(0) + "' in condition must be boolean at line " + _input.LT(1).getLine() + ", column " + _input.LT(1).getCharPositionInLine() + ".");
        }
      })*
    ;


OP_SUM	    : '+'
      ;

OP_SUB	    : '-'
      ;

OP_MUL	    : '*'
      ;

OP_DIV	    : '/'
            ;

OP_AT	    : ':=' | '+=' | '++' | '--' | '-='
      ;

OPREL       : '>' | '<' | '>=' | '<= ' | '<>' | '=='
   ;

ID			: [a-z] ( [a-z] | [A-Z] | [0-9] )*
   ;

NUM			: ('-')?[0-9]+('.'[0-9]+)?
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

AND			: 'AND'
   ;

OR			: 'OR'
   ;
   
NOT			: 'NOT'
   ;

TEXTO       : '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-' )* '"'
   ;

WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
   ;

BOOL		: 'Verdadeiro' | 'Falso'
         ;

CLASS		: [A-Z] ( [A-Z] | [a-z] | [0-9] )*
   ;