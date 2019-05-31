
Cadastro-api

Simple CRUD using a RESTfull application, where we knowingly call backend Java8, Spring rest, MVC, Spring Tools, 
MySql, MySql Workbench, FlyWey.
The other part, frontend has not yet been implemented, but soon I hope to start it and make it available. 
In short, the backend is responsible for providing a web service that can be called through a URL and 
responding to what was requested in JSON.

Technologies and Prerequisites
– Java 1.8
– Maven 3.3.9
– Spring Tool Suite – Version 2.1.2.RELEASE
– Spring Boot: 2.1.2.RELEASE

Installing and Step to do
– Create Spring Boot project & add Dependencies 
– Configure Spring JPA
– Create DataModel Class Funcionario
– Create Spring JPA Repository Interface “FuncionarioRepository”
– Create Web Controller “FuncionarioController” 
– Create MySQL table 
– Run Spring Boot Application & Enjoy Result

Class and Interfaces and methods
– Funcionario class corresponds to entity and table customer.
– FuncionarioRepository is an interface extends CrudRepository, will be autowired in CustomerController for implementing repository methods and custom finder methods.
– FuncionarioController is a REST Controller which has request mapping methods for RESTful requests such as: buscar, adicionar, atualizar, remover.
– Configuration for Spring Datasource and Spring JPA properties in application.properties
– Dependencies for Spring Boot and MySQL in pom.xml

application.properties
Configuration for Spring Datasource & JPA properties

spring.datasource.url=jdbc:mysql://localhost:3306/cadastro?useSSL=false
spring.datasource.username=root
spring.datasource.password=12xyz
spring.jpa.generate-ddl=true

Our Spring Boot Server can work with MySQL Database and provides APIs:
GET /funcionarios/: get all customers
GET /funcionarios/[id]: get a funcionario by id
POST /funcionarios/: save a funcionario
PUT /funcionarios/[id]: update a funcionarioby id
DELETE /funcionarios/[id]: delete a funcionarioby id
