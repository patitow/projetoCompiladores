grammar BananaScript;

// Regras léxicas
ID: [a-zA-Z]+;         // Identificadores (nomes de variáveis, funções, etc.)
INT: [0-9]+;           // Números inteiros
STRING: '"' ~["\r\n]* '"'; // Strings delimitadas por aspas duplas
WS: [ \t\r\n]+ -> skip; // Espaço em branco (ignorado)
COMMENT: '//' ~[\r\n]* -> skip; // Comentários de linha

// Regras de parser
program: function+ EOF;     // Programa consiste em uma ou mais funções OK

function: 'fun' ID '(' params ')' funType block returnStatement?; // Definição de função OK

params: paramOptional?; // Lista de parâmetros de função OK

paramOptional: param paramRecursive*;

paramRecursive: ',' param;

param: type ID;                // Parâmetro da função DEFAULT

type: 'int' | 'float' | 'string' | 'boolean' | 'char' | 'double';

funType: type | 'void' ; // Tipos de dados OK

block: (statement|operation|expression)+; // Bloco de código DEFAULT

statement: assignment // DEFAULT
         | ifStatement
         | whileStatement
         | forStatement
         | tryCatchStatement
         | returnStatement
         | print;

assignment: type ID '=' expression; // Atribuição de variável OK

ifStatement: 'if' booleanExpression block (':'|elseStatement?); // Estrutura condicional if OK

elseStatement: 'else' block ':'; // OK

whileStatement: 'while' booleanExpression block ':'; // Loop while OK

forStatement: 'for' ID '=' expression ';' booleanExpression ';' ID ('++' | '--') block ':'; // Loop for

tryCatchStatement: 'try' block 'catch' '(' ID ')' block ':'; // Tratamento de exceção

returnStatement: 'return' expression ':' ; // Retorno de função

expression: term (('*' | '+' | '-' | '/') expression)*; // Expressões aritméticas

operation: ID '=' expression;

booleanExpression: term (('==' | '!=' | '!' | '>' | '<' | '>=' | '<=' | '&&' | '||') term)*;

term: INT
    | ID
    | STRING 
    | functionCall; // Termos em uma expressão falta implementar na main

functionCall: ID '(' functionExpression? ')'; // Chamada de função

functionExpression: expression functionExpressionRecursive*;

functionExpressionRecursive: ',' expression;

print: 'print' term ':'; 
