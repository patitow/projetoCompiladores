# bananaScript
Seja bem-vindo ao manual do usuário do bananaScript, a sua linguagem de scripting.

## As funcionalidades do bananaScript são semelhantes a de linguaguens já existentes:

 - Funções
 - Print
 - Estruturas condicionais
 - Estruturas de Repetição

## O bananaScript é compilado em Java.
A sintaxe do banana script deve ser semelhante/análoga a disponível abaixo:

## Primeiros passos para começar a escrever em bananaScript:
O bananaScript consiste em uma ou mais funções. Portanto, para entendê-lo, vamos começar o nosso guia demonstrando como declarar funções em bananaScript:
#### Declarando funções: 
Uma função em bananaScript é declarada usando a palavra reservada 'fun', seus parâmetros são definidos entre parênteses e o tipo de retorno vem logo após os parâmetros. 
```
fun minhaFuncao(int id, string valor) int
    // código
    return retorno
```

#### Como os statements são formados? 
1. ##### Declarando variáveis: 
    Para declarar uma variável em bananaScript: 
    `{tipo} {nome} = {valor}`
    Por exemplo, para definir um inteiro: 
    `int var = 3`
    Os tipos primitivos suportados são: 
    - int 
    - float
    - char
    - string
    - boolean
    - double
2. ##### Estrutura condicional
    Estruturas condicionais em bananaScript são simples: 
    ```
    if condicao: 
        // código
    else: 
        // código
    :
    ```
2. ##### Estruturas de repetição: 
    *Definindo uma estrutura for:*
    ```
    for var = 2: 
        // código
    :
    ```
    *Definindo uma estrutura while:*
    ```
    while condicao: 
        // código
    :
    ```
4. ##### Bloco try/catch e exceções
    O tratamento de exceções em bananaScript é feito da seguinte forma: 
    ```
    try: 
        // código
    catch(exceção): 
        // tratamento
    :
    ```
    Podemos lançar excessões usando o comando throw da seguinte forma:
    ```
    throw "mensagem de erro"
    ```

#### Para printar em bananaScript, é simples: 
    `print "valor":`