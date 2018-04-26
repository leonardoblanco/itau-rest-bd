# Itau REST BD

Projeto realizando utilizando Spring e banco H2

Trata-se de um sistema que disponibiliza uma interface REST de clientes com 4 verbos GET, POST, PUT, DELETE

## Obtendo o código
```
git clone https://github.com/leonardoblanco/itau-rest-bd.git
cd itau-rest-bd
mvn clean install
mvn spring-boot:run
```

## Build

Executar `mvn clean install` para realizar o build do projeto. Os artefatos do build serão gerados na pasta  `target/` .

## Executando testes unitários

Executar `mvn clean install` ira compilar, empacotar e executar os testes.

## Uso da API REST

Executar um GET em `http://localhost:8080/clientes` - Irá trazer uma lista com todos os clientes.

Executar um GET em `http://localhost:8080/clientes/1` - Irá trazer o cliente de ID 1.

Executar um POST em `http://localhost:8080/clientes` - Passando um JSON no formato do objeto Cliente e ira cadastrar um novo cliente.

Exemplo de objeto JSON de Cliente:

`{
   "nome": "11958787545",
   "telefone": "rodrigo@gmail.com",
   "email": "Rodrigo"
}`

Executar um PUT em `http://localhost:8080/clientes` - Passando um JSON no formato do objeto Cliente e ira atualizar o cliente informado com os novos dados do JSON.

Exemplo de objeto JSON de Cliente:

`{
   "id": 3,
   "nome": "11958787545",
   "telefone": "rodrigo@gmail.com",
   "email": "Rodrigo"
}`

Executar um DELETE em `http://localhost:8080/clientes/1` - Irá deletar o cliente de ID 1.

## Swagger API DOCS V2

Ao subir a aplicação será disponibilizada uma url de documentação padrão swagger em `http://localhost:8080/v2/api-docs`

Esta documentação pode ser verificada através do swagger-ui disponivel em `https://swagger.io/swagger-ui/`

## Ajuda

Qualquer dúvida entrar em contato em (leonardo.info@gmail.com).
