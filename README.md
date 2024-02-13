# Agregador de Investimentos

# Sobre o projeto

O Agregador de Investimentos é um projeto Backend para simular uma carteira de Investimentos onde um usuário pode criar contas e nessas contas adicionar Stocks (ações da bolsa). 
Os dados das ações, especialmente o seu valor no dia é obtido por meio da intregreção com a API da Brapi, que disponibiliza esses dados. 
Ademais, temos um CRUD básico de Usuário, além das exceções tratadas e desenvolvimento em Camadas.

## Modelo conceitual
![Modelo Conceitual](https://github.com/LucasIbiapino7/assets/blob/main/imgs/agregador-of.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Postgres
# Competências
- Desenvolvimento em Camadas
- Spring Cloud OpenFeign para Integração com a API da Brapi.dev
# Features
- CRUD básico do usuário
- Tratamento de exceções com resposta personalizada
- Get Accounts By User -> Retorna uma Lista das contas de um usuário
- New Account With User -> Cria uma conta e associa a um usuário
- Get stocks By account -> Recupera as Stocks de uma conta específica
- Get all Stocks -> Recupera Uma Lista com todas as Stocks cadastradas
- New Stock -> Insere uma Nova Stock no Banco de dados se ela existir Na Brapi.dev
- New Stock With Account -> Associa uma stock a uma Conta.
- Encontra as contas, junto com as Stocks de um Usuário e apresenta da seguinte forma:
```json
{
  "username": "lucas",
  "accounts": {
    "1": {
      "accountId": 1,
      "description": "conta do lucas",
      "accountStock": [
        {
          "stockId": "AMZN",
          "quantity": 10,
          "total": 1612.6
        },
        {
          "stockId": "VIVR3",
          "quantity": 20,
          "total": 91.6
        }
      ],
      "total": 1704.20
    },
    "2": {
      "accountId": 2,
      "description": "conta do lucas 2",
      "accountStock": [
        {
          "stockId": "NEXP3",
          "quantity": 12,
          "total": 58.92
        }
      ],
      "total": 58.92
    }
  }
}
```
O valor Total da ação no dia é Obtido por meio da API da Brapi.dev

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone git@github.com:LucasIbiapino7/Agregador-de-Investimentos.git
```
# Autor

Lucas Ibiapino Do Nascimento Duarte


