# 📘 API REST CRUD - Servidores Públicos

Este projeto é uma API RESTful desenvolvida para gerenciar registros de servidores públicos. A aplicação permite criar, listar, atualizar e remover dados de servidores, seguindo as boas práticas de design REST.

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- PostgreSQL  
- Maven  
- Lombok  


## 🔧 Funcionalidades

- `POST /cadastrarServidor` - Cadastrar um novo servidor público  
- `GET //listarServidores` - Listar todos os servidores  
- `GET /listarServidor/{matricula}` - Buscar servidor pela matricula  
- `PUT /editarServidor/{matricula}` - Atualizar dados de um servidor  
- `DELETE /excluirServidor/{matricula}` - Remover um servidor  

## 📦 Exemplo de Payload

```json
{
    "matricula": 1,
    "nome": "Caio F S Pimentel",
    "foto": "https://abctreinamentos.com.br/imgs/caio.png",
    "orgao": "RFB",
    "vinculo": "Estatutário",
    "cargo": "Analista Tributário",
    "lotacao": "São Paulo",
    "exercicio": "Departamento de TI",
    "email": "caiosantos@rfb.gov.br",
    "telefone": "(21) 3255-6010",
    "celular": "(21) 99910-5713",
    "cpf": "123.4567.789-01",
    "naturalidade": "São Paulo"
}
