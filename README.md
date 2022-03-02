# Cadastro Veiculos 
![GitHub top language](https://img.shields.io/github/languages/top/karpegnogueira/cadastroveiculos?style=plastic)


# Sobre o projeto:

https://cadastro-veiculos.herokuapp.com/swagger-ui.html

Um serviço de cadastro de veículos onde dados básicos são fornecidos pelo usuário.

Obs: Na parte do consumo de API externa , eu notei que o consumo da api(https://github.com/giovanigenerali/fipe-json) iria ser muito complexo , pois iria ter que fazer varias chamadas , varios filtros e isso iria me demandar mais tempo pra conseguir fazer. Porém , no lugar dela , pra exemplificar , fiz consumo da api(https://viacep.com.br/), um webservice gratuito e de alto desempenho para consultar Códigos de Endereçamento Postal (CEP) do Brasil.

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Spring Validation
- JPA / Hibernate
- Maven
- MVC
- Lombok
- Consumo de Api com o RestTemplate
- Testes Unitários
- Swagger
## Implantação em produção
- Back end: Heroku
- Banco de dados: Postgresql

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/karpegnogueira/cadastroveiculos.git

# Instalar o PostgresSQL: 
- https://www.postgresql.org/
- Durante a instalação use como senha '1234'

# Caso ja tenha instalado o PostgresSQL:
- Ajustar configurações de banco de dados no aplication.properties 
- troque usuário e senha do arquivo para poder conectar

#Crie um novo database no banco de dados PostgresSQL:
- DB: cadastro-veiculos-db

#Abra a aplicação em sua IDE de preferencia;
- importe as dependencias e inicie a aplicação.

#Após iniciar acesse:
http://localhost:8080/swagger-ui.html

```

# Autor

Karpeg Nogueira
