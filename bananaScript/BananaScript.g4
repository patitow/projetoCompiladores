grammar BananaScript;

// Regras léxicas
ID: [a-zA-Z]+;         // Identificadores (nomes de variáveis, funções, etc.)
INT: [0-9]+;           // Números inteiros
STRING: '"' ~["\r\n]* '"'; // Strings delimitadas por aspas duplas
WS: [ \t\r\n]+ -> skip; // Espaço em branco (ignorado)
COMMENT: '//' ~[\r\n]* -> skip; // Comentários de linha

// Regras de parser
program: function+;     // Programa consiste em uma ou mais funções OK

function: 'fun' ID '(' params ')' type block; // Definição de função OK

params: (param (',' param)*)?; // Lista de parâmetros de função OK
param: type ID;                // Parâmetro da função DEFAULT

type: 'int' | 'float' | 'string' | 'boolean' | 'void' | 'char' | 'double'; // Tipos de dados OK

block: statement+; // Bloco de código DEFAULT

statement: assignment // DEFAULT
         | ifStatement
         | whileStatement
         | forStatement
         | tryCatchStatement
         | returnStatement;

assignment: ID '=' expression; // Atribuição de variável OK

ifStatement: 'if' booleanExpression ':' block  elseStatement?; // Estrutura condicional if

elseStatement: 'else' block;

whileStatement: 'while' booleanExpression ':' block; // Loop while

forStatement: 'for' ID '=' expression ';' booleanExpression ';' ID ('++' | '--') ':' block; // Loop for

tryCatchStatement: 'try' ':' block 'catch' '(' ID ')' ':' block; // Tratamento de exceção

returnStatement: 'return' expression ;// Retorno de função

expression: term (('*' | '+' | '-' | '/') term)*; // Expressões aritméticas

booleanExpression: term (('==' | '!=' | '!' | '>=' | '<=' | '&&' | '||') term)*;

term: INT
    | ID
    | STRING
    | '(' expression ')'
    | functionCall; // Termos em uma expressão

functionCall: ID '(' (expression (',' expression)*)? ')'; // Chamada de função

// Definindo prioridade de operadores
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
