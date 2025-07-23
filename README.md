<p align="center">
 <img src="https://img.shields.io/static/v1?label=Status&message=Em Desenvolvimento&color=&labelColor=90876I" alt="Status" />
</p>

> # Aplicação de Streaming prime-max

> ## Descrição do Projeto
O projeto consiste na construção de uma plataforma Web/API para Entretenimento e criação de streams de videos

O intuito é, o Entretenimento visual com conceito de diversão, informação, educação e o fomento da liberdade cultural e visual

Sendo assim, foram criados os serviços:
* Visualização e cadastramento dos usuários
* Publicação de videos
* Criação de playlists
* Publicação de comentários
* Listar usuários cadastrados
* Encontrar usuário(s), playlist(s) e/ou video(s) por filtragem (por letra/terminação inicial e/ou final) ou seu nome/sobrenome


> ## Tecnologias Utilizadas
As seguintes ferramentas foram utilizadas na construção do projeto
- [Java - v17](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/get-started/)
- [Spring Boot](https://spring.io/)
- [PostgresSQL](https://www.postgresql.org/)
- [PGAdmin 4](https://www.pgadmin.org/)
- [Git SCM](https://git-scm.com/)
- [Swagger Docs](https://swagger.io/)

> ## Práticas adotadas

- API REST
- Containerização
- Tratamento de respostas de erro otimizada
- Implementação de esteira CI/CD

> ## Instalação
Tenha instalado em seu sistema operacional:
> - [JAVA NA VERSÃO 17 OU SUPERIOR](https://www.oracle.com/br/java/technologies/downloads/#java17)
>
> - [MAVEN](https://maven.apache.org/download.cgi)
>
> - [DOCKER](https://www.docker.com/)
> 
> - [GIT](https://git-scm.com/downloads)

> ## Instrução de Configuração e Instação
**Guia de Documentação com Instruções para Configuração do Ambiente de Desenvolvimento**
- [JAVA](docs/JAVA.md)
- [Maven](docs/MAVEN.md)
- [GIT](docs/GIT.md)
- [Docker](docs/DOCKER.md)
- [IntelliJ](docs/INTELLIJ.md)

> ## Como Executar

- Clonar repositório `GITHUB`
```bash
   git clone https://github.com/ivancarlosantos/video-max.git
```
- Ir até o diretório/pasta localizando a aplicação
```bash
   cd [caminho onde realizou o clone]
```
- Construir o projeto

> ## DEMO

- Caso desejar testar a aplicação em ambiente `dev`, com o Docker ativo, execute:
````bash
    docker run --name prime-max -d -p 8080:8080 -e DB_USERNAME='avnadmin' -e DB_PASSWORD='AVNS_0mfT6t5QKarNQzHbmzy' -e DB_URL='jdbc:postgresql://prime-max-database-staging-ivansantos-ec22.b.aivencloud.com:15151/prime-max' devmenorzera/prime-max:latest
````
- Para acessar a aplicação, via [Web](http://localhost:8080)
````bash
    http://localhost:8080
````
- Para acessar a API, via [Swagger-UI](http://localhost:8080/swagger-ui/index.html#/):
````bash
    http://localhost:8080/swagger-ui/index.html#/
````
> ## EXECUTAR APLICAÇÃO VIA IDE

Clone realizado, inicializar o projeto:

- Na raíz do projeto, em um terminal, executar a aplicação com o ambiente desejado (dev/prod)
```bash
   mvn spring-boot:run
```
- ou use o wrapper run
```bash
  .\mvnw spring-boot:run
```

# API Endpoints

Você pode acessar a API via [SWAGGER](http://localhost:8080/swagger-ui/index.html) como client HTTP

- Cadastrar um Usuário [[POST]]()
```bash
   http POST :8080/api/users/save name="name" email="email" password="password"
{
  "name": "name",
  "email": "email",
  "password": "password",
}
```

- Listar Usuários Cadastrados [[GET]]()
```bash
   http GET :8080/api/users/list

[
 {
  "name": "name1",
  "email": "email1",
  "password": "password1",
 },
 {
  "name": "name2",
  "email": "email2",
  "password": "password2",
 }
]
```
- Encontrar Usuário pelo nome [[GET]]()

`PS: Você pode encontrar/filtrar por inicio, meio ou final do nome`
```bash
   http GET :8080/api/users/find?name=

[
  {
  "name": "name",
  "email": "email",
  "password": "password",
  }
]
```

- Encontrar Usuário por ID [[GET]]()

```bash
   http GET :8080/api/users/search/{id}

[
  {
  "name": "name",
  "email": "email",
  "password": "password",
  }
]
```

- Atualizar Cadastro de um Usuário [[PUT]]()
```bash
   http PUT :8080/api/users/update/{id}

 { 
  "name": "name update",
  "email": "email update",
  "password": "password update",
 }
```

- Excluir Cadastro de um Usuário [[DELETE]]()
```bash
   http DELETE :8080/api/users/delete/{id}
   [NO_CONTENT]
```