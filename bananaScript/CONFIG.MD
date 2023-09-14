# Configurando as ferramentas para o ANTLR. Adicionando o ANTLR ao CLASSPATH:

```export CLASSPATH=".:antlr.jar:$CLASSPATH"```

## Configurando os aliases para o antlr4 e grun:

```alias antlr4='java -Xmx500M -cp "antlr.jar:$CLASSPATH" org.antlr.v4.Tool'```s

```alias grun='java -Xmx500M -cp "antlr.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'```