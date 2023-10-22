# ems-backend
	ems-backend
https://www.linkedin.com/in/deivid-zioto-6735b9289/ 

API para gerenciar Pessoas (CRUD) que faz parte de um treino pessoal.

Tecnologias

Spring Boot Spring MVC Spring Data JPA SpringDoc OpenAPI 3 Mysql

Práticas adotadas

SOLID, DRY, YAGNI, KISS API REST Consultas com Spring Data JPA Injeção de Dependências Tratamento de respostas de erro

Como Executar

Clonar repositório git Construir o projeto: $ ./mvnw clean package Executar a aplicação: $ java -jar target/ems-backend-0.0.1-SNAPSHOT.jar A API poderá ser acessada em localhost:8080.

API Endpoints Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta httpie:

Criar Tarefa $ http POST :8080//api/employees firstName="name" lastName="name 2" email="email@gmail.com"

[ { "id": 1, "firstName": "name", "lastName": "name 2", "email": "email@gmail.com" } ] Listar employees $ http GET :8080//api/employees

[ { "firstName": "newName", "lastName": "newnName 2", "email": "newEmail@gmail.com" } ] Atualizar employees $ http PUT :8080/api/employees/1 firstName= "newName", lastName= "newnName 2", email= "newEmail@gmail.com"

[ { "firstName": "newName", "lastName": "newnName 2", "email": "newEmail@gmail.com" } ] Remover Tarefa http DELETE :8080/api/employees/1

[ ]
