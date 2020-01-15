### Desafio Desenvolvedor Java - BrasilPrev - Digital

## Introdução

Você foi convidado a realizar um desafio de cadastro de produtos bem simples. Queremos
avaliar sua qualidade de código, padrões REST e criatividade.
Implemente uma api rest utilizando spring boot com java 8.

## Informações do projeto

	1. O projeto foi desenvolvido com Java 8 e utilizando o framework Spring Boot v2.2.2.
	2. Para testes unitários foi utilizadoo Junit 5
	
## Pré Requisitos 
	1. Ter o Java 8 instalado
	2. Ter o Maven Instalado
	
## Compilando o projeto

	1. Apos ter baixado o projeto, abra um terminal de comando(ex: git bash)  no diretório do projeto.
	2. Digite o comando "mvn clean package" e aguarde o fim da compilação.
		
## Configurações da API - Propiedades da aplicacao

    1. Application.properties    
	
	
	Temos o parametro "appapi.origin-permitida=* " para que possa ser passado a url de origem permitida e a requisição não trave no cors.
	
## Executando os testes unitários
		1. Apos ter baixado o projeto, abra um terminal de comando(ex: git bash)  no diretório do projeto.
		2. Digite o comando "mvn test" e aguarde o fim dos testes.
		 
## Executando a API no ambiente local

	1. Após ter compilado o projeto, vá até a pasta target que se encontra no diretório do projeto.

	2. Na pasta target, copie o .jar da API para um local de sua escolha e abra o terminal de comando(ex: git bash)
	
	3. Digite o comando "java -jar o_jar_da_sua_api.jar". Caso queira passar o um arquivo de propiedade customizado, basta rodar o              comando "java -jar o_jar_da_sua_api.jar -Dspring.config.location=your.properties"
	
	4. Aguarde o sua api inicializar, se tudo der certo as últimas mensagens impressas no console serão;
		
		Tomcat initialized with port(s): xxxx (http)
		Starting service [Tomcat]
		Starting Servlet engine: [Apache Tomcat/9.0.29]
		Initializing Spring embedded WebApplicationContext
		Root WebApplicationContext: initialization completed in 2664 ms
		
## Link Swagger

	your_domain/v2/api-docs
