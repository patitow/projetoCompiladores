
# Guia de instruções para o ANTLR do BananaScript
Para rodar quaisquer dos comandos abaixos, é de extrema importancia que esteja no diretorio 'bananaScript'

## Para gerar as classes a partir da gramática, use: (os arquivos irão para a pasta gen)

```java -jar antlr.jar BananaScript.g4 -o gen```

## Para compilar a linguagem e suas classes, use: (os arquivos irão para a pasta bin)

```javac -cp antlr.jar -d bin ./main/*.java ./gen/*.java ```

## Deveria rodar normalmente:

```java -cp antlr.jar:bin MainBananaScript```