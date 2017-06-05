# Integrando Java EE 7 com AngularJS

Back-end: Java EE 7(JAX-RS) / Front-end: AngularJS

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 8
Wildflyw 8.2.0.Final
PostgreSQL 9.3.10 ou superior
maven 3.3.3 ou superior
bower 1.8.0 ou superior
```
## Setup

Primeiramente, faça o clone do repositório:
```
https://github.com/emmanuelneri/javaee-angularjs.git
```

Na sequência execute o clean install para baixar as dependências
```
mvn clean install
```
Obs: Está configurado para o install do maven tambm executar o bower install e baixar as dependências web.

Após baixado as dependências, é preciso criar a base dados no Postgres:
```
CREATE DATABASE "javaee-angular";
```

E configurar o dataSource no Wildfly no arquivo standalone.xml
```
<datasource jndi-name="java:jboss/datasources/javaeeAngularDs" pool-name="javaeeAngularDs" enabled="true" use-java-context="true">
    <connection-url>jdbc:postgresql://localhost:5432/javaee-angular</connection-url>
    <driver>postgresql</driver>
    <security>
        <user-name>postgres</user-name>
        <password>postgres</password>
    </security>
</datasource>
```

## Inicialização
Após feito o setup, apenas fazer deploy do arquivo javaee-angularjs.war, que é gerando dentro da pasta target pelo maven, no servidor de aplicaço Wildfly.

## Outros
Serviços disponíveis no back-end:
 - GET: http://localhost:8080/ws/pessoa/listar
 - GET: http://localhost:8080/ws/pessoa/buscar/1
 - POST: http://localhost:8080/ws/pessoa/cadastrar
