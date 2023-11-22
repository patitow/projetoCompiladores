grammar BananaScript;

// Regras léxicas
ID: [a-zA-Z]+;         // Identificadores (nomes de variáveis, funções, etc.)
INT: [0-9]+;           // Números inteiros
STRING: '"' ~["\r\n]* '"'; // Strings delimitadas por aspas duplas
WS: (' '|'\n')+ -> skip; // Espaço em branco (ignorado)
COMMENT: '//' ~[\r\n]* -> skip; // Comentários de linha

// Regras de parser
program: function* EOF;     // Programa consiste em uma ou mais funções

function: 'fun' ID '(' params ')' type block; // Definição de função

params: (param (',' param)*)?; // Lista de parâmetros de função
param: type ID;                // Parâmetro da função

type: 'int' | 'float' | 'string' | 'boolean' | 'void' | 'char' | 'double' | ID; // Tipos de dados

block: statement+; // Bloco de código

statement: assignment
         | ifStatement
         | whileStatement
         | forStatement
         | tryCatchStatement
         | returnStatement
         | expression; // Diferentes tipos de instruções

assignment: ID '=' expression; // Atribuição de variável

ifStatement: 'if' expression ':' block ('else' block)?; // Estrutura condicional if

whileStatement: 'while' expression ':' block; // Loop while

forStatement: 'for' ID '=' expression ':' block; // Loop for

tryCatchStatement: 'try' ':' block 'catch' '(' ID ')' ':' block; // Tratamento de exceção

returnStatement: 'return' expression; // Retorno de função

expression: term (('*' | '+' | '-' | '/') term)*; // Expressões aritméticas

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
