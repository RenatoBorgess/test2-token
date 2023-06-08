# Spring Boot MVC Service with H2 Database

Este é um exemplo de aplicação Spring Boot MVC que utiliza um banco de dados H2 em memória. O banco de dados é pré-populado com as tabelas "PARENT" e "CHILD", conforme descrito abaixo:

**Tabela PARENT:**

| Id | Name |
|----|------|
| 1  | John |
| 2  | Paul |
| 3  | Mary |
| 4  | Lucy |
| 5  | Mark |

**Tabela CHILD:**

| Id | Name   | FATHER_ID | MOTHER_ID |
|----|--------|-----------|-----------|
| 1  | John   | 1         | 3         |
| 2  | Paul   | 1         | 3         |
| 3  | Lucy   | 2         | 4         |
| 4  | Claire | 1         | 4         |
| 5  | Simon  | NULL      | 4         |

A aplicação oferece cinco endpoints GET para realizar as seguintes operações:

1. Obter a lista de todos os nomes dos PAIS.
```
curl -X 'GET' \
  'http://localhost:8080/fathers' \
  -H 'accept: */*'

[
  {
    "id": 1,
    "name": "John"
  },
  {
    "id": 2,
    "name": "Paul"
  }
]
```
2. Obter os nomes dos PAIS que têm mais de um filho.
```
curl -X 'GET' \
  'http://localhost:8080/fathers/multipleChildren' \
  -H 'accept: */*'
  
  [
  "John"
]
```

3. Para cada FILHO, obter o nome do seu pai e da sua mãe, caso estejam definidos.
 ```
 curl -X 'GET' \
  'http://localhost:8080/parents' \
  -H 'accept: */*'
  
  [
  {
    "childName": "John",
    "fatherName": "John",
    "motherName": "Mary"
  },
  {
    "childName": "Paul",
    "fatherName": "John",
    "motherName": "Mary"
  },
  {
    "childName": "Lucy",
    "fatherName": "Paul",
    "motherName": "Lucy"
  },
  {
    "childName": "Claire",
    "fatherName": "John",
    "motherName": "Lucy"
  },
  {
    "childName": "Simon",
    "fatherName": null,
    "motherName": "Lucy"
  }
]
```
4. Obter a quantidade de filhos que o PAI "John" tem. (Este endpoint recebe um nome de pai como parâmetro na URL)
```
curl -X 'GET' \
  'http://localhost:8080/fathers/John/countChildren/' \
  -H 'accept: */*'
  
  3
 ```
5. Obter a quantidade de filhos que a MÃE "Mary" tem. (Este endpoint recebe um nome de mãe como parâmetro na URL)
```
curl -X 'GET' \
  'http://localhost:8080/mothers/Mary/countChildren/' \
  -H 'accept: */*'
  
  2
```

A aplicação utiliza exclusivamente a biblioteca JDBC para conexão com o banco de dados e execução de consultas.

## Executando o Projeto Localmente

Para executar o projeto localmente, siga estas instruções:

1. Certifique-se de ter o Java e o Maven instalados em seu sistema.

2. Clone o repositório e acesse o diretório do projeto.

3. Abra um terminal e execute o seguinte comando para construir o projeto:

```bash
mvn clean package
```

4. Após a construção bem-sucedida, execute o seguinte comando para iniciar a aplicação:

```bash
mvn spring-boot:run
```

5. A aplicação será iniciada, e você pode acessar o Swagger UI abrindo a seguinte URL no seu navegador::

```
http://localhost:8080/swagger-ui.html
```

Agora você pode acessar os cinco endpoints mencionados acima para realizar as operações desejadas.

Certifique-se de ter o H2 Database Console configurado corretamente para acessar o banco de dados em memória. Acesse a seguinte URL no seu navegador:

```
http://localhost:8080/h2-console
```

No campo "JDBC URL", verifique se a URL de conexão está configurada como "jdbc:h2:mem:testdb". O usuário padrão é "sa" e a senha "pass".

Lembre-se de que, como o banco de dados H2 está em memória, ele será recriado toda vez que a aplicação for reiniciada.
