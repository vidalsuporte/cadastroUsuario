# 🚀 Cadastro de Usuários
> Api para prática de manipulação de dados, login com perfis de autorização .

## 📖 Descrição
Este projeto é uma API REST desenvolvida em **Java com Spring Boot** para gerenciamento de usuários.  
Ele implementa autenticação via **JWT**, persistência em **banco de dados relacional** e documentação com **Swagger**.  

## 🛠️ Tecnologias Utilizadas
- Java 21+
- Spring Boot (Web, Data JPA, Security)
- JWT (JSON Web Token)
- Banco de Dados: MySQL 
- FlywayDB (versionamento do banco)
- Swagger (OpenAPI 3.0)
- Maven

## ⚙️ Funcionalidades
- ✅ Cadastro, edição e exclusão de usuários
- ✅ Autenticação e autorização com JWT
- ✅ Integração com banco relacional
- ✅ Documentação da API com Swagger


## 📂 Estrutura do Projeto

src/
├─ main/java/com/vidalsuporte/cadastroUsuario
│ ├─ controller
│ ├─ service
│ ├─ domain
│ └─ infra
|   ├─ configuracao  
|   ├─ exception
|   ├─ security
|   └─ springDoc
└─ main/resources
| └─ db.migrations
└─ application.properties
