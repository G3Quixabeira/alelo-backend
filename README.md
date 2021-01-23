# Desafio Alelo-backend

Criar uma API (tema livre) com:

    - Get/Post/Delete/Put;
    - Testes unitários, usando banco em memória;
    - Teste “mockando” o retorno de uma API de terceiros;
    - Documentação via Swagger;

### Documentação Swagger

http://localhost:8080/swagger-ui.html


### Base de dados
Utilizo no projeto o H2, juntamente com JPA


### O Web Service
O projeto se basea no padrão REST e trabalha com o status code padrão HTPP:

### Payload Json para Testes

**Clientes** /clientes [GET/POST/PUT/DELETE]
>[GET] Retorna lista de Clientes

>[POST] Adiciona um Cliente
```json
{
  "cpf": "12345678910",
  "nascimento": "2020-01-01",
  "nome": "Julios",
  "rg": "123456"
}
```

>[PUT] /{id} Atualiza um Cliente
```json
{
  "cpf": "12345678910",
  "id": 1,
  "nascimento": "2020-01-01",
  "nome": "Julios o pai do cris",
  "rg": "123456"
}
```

>[DELETE] /{id} Apaga um cliente com base na id /{id}

