# PtBrLang - Linguagem de Programação em Português

- Comando mvn para atualizar o core de arquivos do compilador `mvn generate-sources`

- Para iniciar o projeto basta startar o spring boot com o comando `mvn exec:java -Dexec.mainClass="com.compiladoresufabc.ptbrlangcompiler.PtBrLangCompilerApplication"` (java 21, maven superior a 3.6)

- uri da chamada: POST http://localhost:8080/api/compiler/upload

## PRIMEIRO PASSO: Definir a Linguagem de Saída
- [x] **Definição da Linguagem Principal**: Definidas Java, C e Python.

## SEGUNDO PASSO: Definir a Gramática
A gramática deve seguir as seguintes regras:
- [x] Possuir 2 tipos de variáveis (números e texto).
- [x] Possuir estrutura If..else.
- [x] Possuir estrutura de controle while/do while.
- [x] Executar operações aritméticas corretamente.
- [x] Realizar atribuições corretamente.
- [x] Possuir operações de entrada e saída.
- [x] Aceitar números decimais.
- [x] Verificar se a variável já foi previamente declarada.
- [x] Verificar se a variável foi declarada e não foi usada.
- [x] Verificar se uma variável está sendo usada sem valor inicial.

### Documentação da Gramática
- [x] Especificar a gramática da linguagem.
- [x] Documentar a gramática.

## TERCEIRO PASSO: Implementação do Projeto Spring Boot

### Configuração e Estruturação do Projeto
- [x] **Criação do Projeto**: Iniciar um projeto Spring Boot, usando uma ferramenta como Spring Initializr.
- [x] **Configuração de Dependências**: Adicionar dependências como web, devtools, etc.
- [x] **Estruturação**: Organizar o projeto em pacotes lógicos (controller, service, model).

### Rota de Teste
- [x] **Implementar o Endpoint Hello World**: Criação de um endpoint REST para garantir o funcionamento do servidor.
- [x] **Testar a Rota**: Verificação do funcionamento via Postman ou navegador.

### Leitura e Processamento de Arquivos
- [x] **Implementar Endpoint para Leitura de Arquivo**: Criação de uma rota que aceite upload de arquivos .ptbrlang.
- [x] **Processar e Retornar Arquivo**: Configuração da rota para renomear o arquivo para .java e retorná-lo ao cliente.

## QUARTO PASSO: Criar o Sistema de Compilação

### Analisador Léxico
- [x] **Definir os Tokens**: Utilizar ANTLR para definir os tokens da linguagem.
- [x] **Gerar o Lexer**: Usar o ANTLR para gerar o lexer e integrá-lo no projeto.

### Analisador Sintático
- [x] **Definir Regras Sintáticas**: Definir as regras de parsing na gramática ANTLR.
- [x] **Gerar o Parser**: Usar o ANTLR para gerar o parser.

### Analisador Semântico
- [x] **Verificar Tipos e Escopos**: Implementar verificações de tipos e escopos baseadas na AST gerada pelo parser.

### Gerador de Código
- [x] **Gerar Código Java**: Implementar a lógica para transformar a AST em código Java.
- [x] **Validar Arquivos Gerados**: Os arquivos gerados devem ser compiláveis com sucesso.

## QUINTO PASSO: Suporte a Expressões e Operadores
- [x] **Implementar Avaliador de Expressões Aritméticas**: Desenvolver a lógica para avaliar expressões aritméticas com respeito à precedência.
- [x] **Implementar Operadores Lógicos**: Adicionar suporte a operadores lógicos (AND, OR) na linguagem e no compilador.

## OPCIONAIS: Considerando o Prazo Final
- [x] **API Rest para o Compilador**: Implementação da API REST para o compilador.
- [x] **Suporte a múltiplas linguagens-alvo (C e Python)**.
- [x] **Avaliador de Expressões aritméticas e lógicas**. 
- [x] **Implementar Operadores Lógicos**: Adicionar suporte a operadores lógicos (AND, OR) na linguagem e no compilador.
- [ ] **Editor Highlight (simulando uma pequena IDE)** - Pendência para futuros desenvolvimentos.

---
## Descrição da Linguagem

A PtBrLang é uma linguagem de programação que suporta variáveis de tipos básicos (number, text, bool), 
operações aritméticas e lógicas, controle de fluxo com condicionais (se, senao), loops (enquanto, faca...enquanto), 
além de comandos de entrada e saída como leia e escreva.

### Estrutura Geral de um Programa
```
programa NomeDoPrograma
declare variaveis
inicio
    comandos
fim
fimprograma
```

### Declaração de Variáveis
#### Sintaxe
```
declare id1, id2 : tipo;
```
#### Exemplo
```
declare x, y : number;
declare nome : text;
declare ativo : bool;
```

### Comandos
#### Leitura
```
leia (id);
```
#### Escrita
```
escreva ("texto");
escreva (id);
```
#### Condição
```
se (listExpr) entao
    comandos
senao
    comandos
fimse
```
#### Laços de Repetição (enquanto / faca...enquanto)
```
enquanto (listExpr) faca
    comandos
fimenquanto
```
```
faca
    comandos
enquanto (listExpr)
fimenquanto
```

### Expressões e Operadores
#### Aritméticos
```
+ (adição)
- (subtração)
* (multiplicação)
/ (divisão)
```
#### Lógicos
```
< (menor que)
> (maior que)
<= (menor ou igual)
>= (maior ou igual)
<> (diferente)
== (igual)
AND (e)
OR (ou)
```

### Exemplo de Programa
```
programa MeuPrograma
declare x, y : number;
declare texto : text;
inicio
    x := 5 + 2;
    se (x > 0) entao
        escreva("Valor positivo");
    senao
        escreva("Valor negativo");
    fimse
fim
fimprograma
```

```
	programa MeuPrograma
		declare a,b,z: number;
		declare c,d: bool;
		declare x,y: text;
		declare xbacon: number;
		inicio
			escreva("Hello World");
			escreva("Fim do programa");
			leia(a);
			leia(b);
			leia(x);
			c := Verdadeiro;
			d := Falso;
			b := 2 / 2 + 3 * 2 * 2.5;
			escreva(a);
			escreva(b);
			se (c AND a == b OR x == "value" OR d OR a == b) entao
				escreva("maior que 5");
			senao
				escreva("menor que 5");
			fimse
			
			enquanto (c AND a == b AND x == "value" OR d) faca
				escreva("maior q leo");
				escreva("maior q leo");
				leia(c);
			fimenquanto
			
			faca
				escreva("maior q leo");
				a +=1;
			enquanto (Falso AND Verdadeiro)
			fimenquanto
			
			escreva("oi agora vamos testar outro");
			se (b >= 0) entao
			   escreva("b positivo");
			senao
			   escreva("b negativo");
			fimse
			
			
		fim
	fimprograma
```
---
## Gramática ANTLR da PtBrLang
```
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
    private HashMap<String,Var> symbolTable = new HashMap<>();
    private ArrayList<Var> currentDecl = new ArrayList<>();
    private Types currentType;
    private Types leftType = null, rightType = null;
    private Program program = new Program();
    private String strExpr = "";
    private ArrayList<String> exprList;
    private String strOp = "";
    private IfCommand currentIfCommand;
    private WhileCommand whileCommand;
    private AtribCommand atribCommand;
    private Stack<ArrayList<Command>> stack = new Stack<>();
    private Stack<AbstractExpression> exprStack = new Stack<>();
    private AbstractExpression top = null;

    public double generateValue() {
        if (top == null) {
            top = exprStack.pop();
        }
        return top.evaluate();
    }

    public String generateJSON() {
        if (top == null) {
            top = exprStack.pop();
        }
        return top.toJSON();
    }

    public void updateType() {
        for (Var v : currentDecl) {
            v.setType(currentType);
            symbolTable.put(v.getId(), v);
        }
    }

    public void exibirVar() {
        for (String id : symbolTable.keySet()) {
            System.out.println(symbolTable.get(id));
        }
    }

    public Program getProgram() {
        return this.program;
    }

    public boolean isDeclared(String id) {
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

programa	: 'programa' CLASS  
              { program.setName(_input.LT(-1).getText());
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
              throw new SemanticException("Variable '" + _input.LT(-1).getText() + "' already declared.");
          }
          currentDecl.add(new Var(_input.LT(-1).getText()));
      }
      ( VIRG ID { currentDecl.add(new Var(_input.LT(-1).getText())); } )*
      DP
      (
        'number' { currentType = Types.NUMBER; }
        |
        'text' { currentType = Types.TEXT; }
        |
        'bool' { currentType = Types.BOOL; }
      )
      { updateType(); }
      PV
    ;

comando     : cmdAttrib
            | cmdLeitura
            | cmdEscrita
            | cmdIF
            | cmdWhile
            | cmdWhileReverse
            ;

cmdIF		: 'se'  { stack.push(new ArrayList<Command>());
                      exprList = new ArrayList<>();
                      currentIfCommand = new IfCommand();
                    }
               AP exprList FP
               'entao' comando+ 
               { currentIfCommand.setTrueList(stack.pop()); }
               ( 'senao' comando+ { currentIfCommand.setFalseList(stack.pop()); } )?
               'fimse'
               { stack.peek().add(currentIfCommand); }
             ;

cmdWhile	: 'enquanto' { stack.push(new ArrayList<Command>());
                      exprList = new ArrayList<>();
                      whileCommand = new WhileCommand(false);
                    }
                   AP exprList FP
                   'faca' comando+ 
                   'fimenquanto'
                   { stack.peek().add(whileCommand); }
              ;

cmdWhileReverse	: 'faca' comando+
                 'enquanto' AP exprList FP
                 'fimenquanto'
                 { stack.peek().add(whileCommand); }
   ;

cmdAttrib    : ID OP_AT expr PV
    { atribCommand = new AtribCommand(symbolTable.get(_input.LT(-3).getText())); }
    ;

cmdLeitura   : 'leia' AP ID FP PV
    { stack.peek().add(new ReadCommand(symbolTable.get(_input.LT(-3).getText()))); }
    ;

cmdEscrita   : 'escreva' AP (ID | TEXTO) FP PV
    { stack.peek().add(new WriteCommand(_input.LT(-3).getText())); }
    ;

expr         : termo (OP_SUM termo | OP_SUB termo)*
    { rightType = leftType; }
    ;

termo        : fator (OP_MUL fator | OP_DIV fator)*
    { rightType = leftType; }
    ;

fator        : ID | NUM | TEXTO | BOOL
    { rightType = symbolTable.get(_input.LT(-1).getText()).getType(); }
    ;

exprList     : expr (OPREL expr)*
    ;

OP_SUM       : '+';
OP_SUB       : '-';
OP_MUL       : '*';
OP_DIV       : '/';
OP_AT        : ':=' | '+=' | '-=' | '++' | '--';
OPREL        : '>' | '<' | '>=' | '<= ' | '<>' | '==';
ID           : [a-z] ( [a-z] | [A-Z] | [0-9] )*;
NUM          : ('-')?[0-9]+('.'[0-9]+)?;
VIRG         : ',';
PV           : ';';
AP           : '(';
FP           : ')';
DP           : ':';
AND          : 'AND';
OR           : 'OR';
TEXTO        : '"' .*? '"';
WS           : [ \t\r\n]+ -> skip;
BOOL         : 'Verdadeiro' | 'Falso';
CLASS        : [A-Z] ( [A-Z] | [a-z] | [0-9] )*;
```

