
# Guia de instruções para o ANTLR do BananaScript
Para rodar quaisquer dos comandos abaixos, é de extrema importancia que esteja no diretorio 'bananaScript'
Além disso, esse repositório somente pode ser executado em ambiente linux. Ele foi testado e projetado para o Codespaces.

## Configurando as ferramentas para o ANTLR. Adicionando o ANTLR ao CLASSPATH:

```export CLASSPATH=".:antlr-4.13.1-complete.jar:$CLASSPATH"```

## Configurando os aliases para o antlr4 e grun:

```alias antlr4='java -Xmx500M -cp "antlr-4.13.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool'```

```alias grun='java -Xmx500M -cp "antlr-4.13.1-complete.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'```

## Para gerar as classes a partir da gramática, use: (os arquivos irão para a pasta gen)

```java -jar antlr.jar BananaScript.g4 -o gen```

## Para compilar a linguagem e suas classes, use: (os arquivos irão para a pasta bin)

```javac -cp antlr.jar:gen *.java gen/*.java -d bin```

## Para rodar a main:

```java -cp antlr.jar:bin MainBananaScript```