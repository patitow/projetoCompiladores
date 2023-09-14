
# Guia de instruções para o ANTLR do BananaScript
Para rodar quaisquer dos comandos abaixos, é de extrema importancia que esteja no diretorio 'bananaScript'
Além disso, esse repositório somente pode ser executado em ambiente linux. Ele foi testado e projetado para o Codespaces.

## Para rodar o código e as gramaticas:

```java -jar antlr.jar BananaScript.g4 -o gen```

## Para compilar a linguagem e suas classes, use: (os arquivos irão para a pasta bin)

```javac -cp antlr.jar:gen *.java gen/*.java -d bin```

## Para rodar a main:

```java -cp antlr.jar:bin MainBananaScript```