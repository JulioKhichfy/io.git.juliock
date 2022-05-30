####0 create a new repository on the command line
```
https://github.com/JulioKhichfy/io.git.juliock.git
Get started by creating a new file or uploading an existing file. We recommend every repository include a README, LICENSE, and .gitignore.
```

###### Utilizado o abaixo, pois previamente foi criado o repositório
```
echo "# io.git.juliock" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/JulioKhichfy/io.git.juliock.git
git push -u origin main
```

###### …or push an existing repository from the command line
```
git remote add origin https://github.com/JulioKhichfy/io.git.juliock.git
git branch -M main
git push -u origin main
```

####1 Starters: Como funciona a mágica por trás do Spring Boot
Bastou incluir as anotações @SpringBootApplication e @RestController que possibilitou 
acessar pelo browser http://localhost:8080/hello

Antigamente era preciso muitos arquivos de configuração xml e um servidor externo(tomcat por exemplo) 
para rodar a aplicação. Com o springboot tudo funcionou automáticamente.

Isso acontece porque o springboot já configura automáticamente a medida que vamos adicionando os STARTERS.

1 - Ao criar o projeto, adicionamos o parent (starter parent):

Com ele obtemos todas as dependências básicas e vamos adicionando os módulos que iremos precisar. 
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.2.4.RELEASE</version>
</parent>
```

2 - O starter Resumindo, é um módulo/dependência que engloba várias outras dependências que vem com classes de configuração.
```
Starter PADRÃO, sem ele o springboot não funciona.
Sem ele não temos @SpringBootApplication
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    version>2.2.4.RELEASE</version> não precisa pois ja herda do parent 
</dependency>
```

####2 - Principais Starters
1 starter web: Módulo adicionado para desenvolver Rest
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

2 starter data: Módulo adicionado para banco de dados
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

3 starter security: Módulo adicionado para autenticação
```
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

4 starter test
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
</dependency>
```

####3 - Configurations e Beans
Como vimos, os starters são auto-configuráveis e já vem prontos para o uso.

P: Como customizar ou fazer alguma configuração?

R: Configurations e Beans  

