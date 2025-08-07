> # Aplicação de Streaming prime-max
> ![T](https://img.shields.io/static/v1?label=Status&message=EmDesenvolvimento&color=&labelColor=90876I)
---

> ## Participantes
---
| Dev                                        | Github                                                                                                                                                                                                                   |
|--------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Ivan](https://github.com/ivancarlosantos) | ![Ivan](https://img.shields.io/badge/Ivan%20Santos-100000?style=for-the-badge&logo=github&logoColor=white)                                                                                                               |
| [Luis](https://github.com/LuisSilvah)      | ![Luis](https://img.shields.io/badge/Luis%20Gustavo-100000?style=for-the-badge&logo=github&logoColor=white)                                                                                                              |
| [Lucas](https://github.com/llucascr)       | ![Lucas](https://img.shields.io/badge/Lucas%20Ranzani-100000?style=for-the-badge&logo=github&logoColor=white)                                                                                                            |


> ## Descrição do Projeto
---

**O projeto consiste na construção de uma plataforma Web/API para Entretenimento e criação de streams de videos**

**O intuito é, o Entretenimento visual com conceito de diversão, informação, educação e o fomento da liberdade cultural e visual**

**Sendo assim, foram criados os serviços:**
* **Visualização e cadastramento dos usuários**
* **Publicação de videos**
* **Criação de playlists**
* **Publicação de comentários**
* **Listar usuários cadastrados**
* **Encontrar usuário(s), playlist(s) e/ou video(s) por filtragem (por letra/terminação inicial e/ou final) ou seu nome/sobrenome**

> ## Tecnologias Utilizadas
---

**As seguintes ferramentas foram utilizadas na construção do projeto**

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![Portainer](https://img.shields.io/badge/Portainer-13BEF9?style=for-the-badge&logo=portainer&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Discord](https://img.shields.io/badge/Discord-%235865F2.svg?style=for-the-badge&logo=discord&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Prometheus](https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=Prometheus&logoColor=white)
![Grafana](https://img.shields.io/badge/Grafana-F2F4F9?style=for-the-badge&logo=grafana&logoColor=orange&labelColor=F2F4F9)

> ## Práticas adotadas
___

- **API REST**
- **Containerização**
- **Tratamento de respostas de erro otimizada**
- **Implementação de esteira CI/CD**

> ## Instalação
---
**Tenha instalado em seu sistema operacional:**
> - [JAVA NA VERSÃO 17 OU SUPERIOR](https://www.oracle.com/br/java/technologies/downloads/#java17)
>
> - [MAVEN](https://maven.apache.org/download.cgi)
>
> - [DOCKER](https://www.docker.com/)
> 
> - [GIT](https://git-scm.com/downloads)

> ## Instrução de Configuração e Instalação
---
**Guia de Documentação com Instruções para Configuração do Ambiente de Desenvolvimento**
- [JAVA](docs/JAVA.md)
- [Maven](docs/MAVEN.md)
- [GIT](docs/GIT.md)
- [Docker](docs/DOCKER.md)
- [IntelliJ](docs/INTELLIJ.md)

> ## Como Executar
---
- **Clonar repositório `GITHUB`**
```bash
   git clone https://github.com/ivancarlosantos/prime-max.git
```
- **Ir até o diretório/pasta localizando a aplicação**
```bash
   cd [caminho onde realizou o clone]
```
- **Construir o projeto**

> ## DEMO
---

- **Caso desejar testar a aplicação em modo container, com o Docker ativo, execute:**
````bash
    docker run --name prime-max -d -p 8080:8080 -e DB_USERNAME='avnadmin' -e DB_PASSWORD='AVNS_sRtjVAQ_epZELVqZ4n9' -e DB_URL='jdbc:postgresql://prime-max-database-ivansantos-ec22.h.aivencloud.com:15151/prime-max' devmenorzera/prime-max:feature
````
- **Para acessar a aplicação, via [Web](http://localhost:8080)**
````bash
    http://localhost:8080
````
- **Para acessar a API, via [Swagger-UI](http://localhost:8080/swagger-ui/index.html#/):**
````bash
    http://localhost:8080/swagger-ui/index.html#/
````
> ## EXECUTAR APLICAÇÃO VIA IDE
---
**Clone realizado, inicializar o projeto:**

- **Na raíz do projeto, em um terminal, executar a aplicação**
```bash
   mvn spring-boot:run
```
- **ou use o wrapper run**
```bash
  .\mvnw spring-boot:run
```

>## API Endpoints
---

**Você pode acessar a API via [SWAGGER](http://localhost:8080/swagger-ui/index.html) como client HTTP**

- **Cadastrar um Usuário [[POST]]()**
```bash
   http POST :8080/api/users/save name="name" email="email" password="password"
{
  "name": "name",
  "email": "email",
  "password": "password",
}
```

- **Listar Usuários Cadastrados [[GET]]()**
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
- **Encontrar Usuário pelo nome [[GET]]()**

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

- **Encontrar Usuário por ID [[GET]]()**

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

- **Atualizar Cadastro de um Usuário [[PUT]]()**
```bash
   http PUT :8080/api/users/update/{id}

 { 
  "name": "name update",
  "email": "email update",
  "password": "password update",
 }
```

- **Excluir Cadastro de um Usuário [[DELETE]]()**
```bash
   http DELETE :8080/api/users/delete/{id}
   [NO_CONTENT]
```