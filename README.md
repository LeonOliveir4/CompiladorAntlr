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
- [x] **Implementar Operadores Lógicos**: Adicionar suporte a operadores lógicos (AND, OR, NOT) na linguagem e no compilador.

## OPCIONAIS: Considerando o Prazo Final
- [x] **API Rest para o Compilador**: Implementação da API REST para o compilador.
- [x] **Suporte a múltiplas linguagens-alvo (C e Python)**.
- [x] **Avaliador de Expressões aritméticas e lógicas**. 
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
se (expr) entao
    comandos
senao
    comandos
fimse
```
#### Laços de Repetição (enquanto / faca...enquanto)
```
enquanto (expr) faca
    comandos
fimenquanto
```
```
faca
    comandos
enquanto (expr)
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

programa
    : 'programa' ID declaravar+ 'inicio' comando+ 'fim' 'fimprograma'
    ;

declaravar
    : 'declare' ID ( ',' ID )* ':' ( 'number' | 'text' | 'bool' ) ';'
    ;

comando
    : cmdAttrib
    | cmdLeitura
    | cmdEscrita
    | cmdIF
    | cmdWhile
    | cmdWhileReverse
    ;

cmdIF
    : 'se' '(' expr ')' 'entao' comando+ 'fimse'
    ;

cmdWhile
    : 'enquanto' '(' expr ')' 'faca' comando+ 'fimenquanto'
    ;

cmdWhileReverse
    : 'faca' comando+ 'enquanto' '(' expr ')' 'fimenquanto'
    ;

cmdAttrib
    : ID ':=' expr ';'
    ;

cmdLeitura
    : 'leia' '(' ID ')' ';'
    ;

cmdEscrita
    : 'escreva' '(' ( ID | TEXTO ) ')' ';'
    ;

expr
    : termo ( '+' termo | '-' termo )*
    ;

termo
    : fator ( '*' fator | '/' fator )*
    ;

fator
    : ID | NUM | TEXTO | BOOL
    ;

ID: [a-zA-Z] [a-zA-Z0-9]*;
NUM: ('-')? [0-9]+ ('.' [0-9]+)?;
TEXTO: '"' [a-zA-Z0-9 ]* '"';
BOOL: 'Verdadeiro' | 'Falso';
WS: [ \t\r\n]+ -> skip;
```

