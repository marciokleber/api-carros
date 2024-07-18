# API de Carros com Spring Boot
Este é um projeto de exemplo que implementa uma API RESTful de carros utilizando Spring Boot.

### Tecnologias Utilizadas
- Spring Boot 3.x
- Spring Data JPA
- postgreSQL
- Maven
### Funcionalidades
A API oferece operações básicas de CRUD (Create, Read, Update, Delete) para a entidade Carro.

- Listar todos os carros
- Buscar um carro pelo ID
- Adicionar um novo carro
- Atualizar os dados de um carro existente
- Deletar um carro pelo ID

### Configuração e Execução


> ##### Inicialize a base postgres utilizando o comando:
>```shell
> docker compose up 
>```
>
> ##### set a versão do java:
>```shell
> sdk env
>```
> ##### Executar a Aplicação:
>```shell
> mvn spring-boot:run
