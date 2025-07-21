<p align="center">
 <img src="https://img.shields.io/static/v1?label=Dev&message=Ivan Santos&color=8257E5&labelColor=000000" alt="@ivan_santos"/>
 <img src="https://img.shields.io/static/v1?label=Status&message=Em Desenvolvimento&color=&labelColor=90876I" alt="Status"/>
</p>

> # Criação e Construção do Ambiente de Desenvolvimento
---
> ### Descrição do Projeto
---
**Escrever e Descrever o projeto**

> ## Tecnologias Utilizadas
---
**As seguintes ferramentas foram utilizadas na construção do projeto:**

- [Java - v17](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/get-started/)
- [Spring Boot](https://spring.io/)
- [PostgreSQL](https://www.postgresql.org/download/)
- [PGAdmin 4](https://www.pgadmin.org/download/)
- [Git SCM](https://git-scm.com/downloads)
- [Swagger Docs](https://swagger.io/)

> ## Práticas adotadas
---

- **API REST**
- **Injeção de Dependências**
- **Implementação de esteira CI/CD Actions**
- **Aplicação de testes (unidade/controle/database/arquitetura/testcontainers)**

> ## Instalação
---
**Tenha instalado em seu sistema operacional:**

> - [JAVA NA VERSÃO 17 OU SUPERIOR](https://www.oracle.com/br/java/technologies/downloads/#java17)
>
> - [MAVEN](https://maven.apache.org/download.cgi)
>
> - [DOCKER](https://docs.docker.com/engine/install/)
> 
> - [PostgreSQL](https://www.postgresql.org/download/)
>
> - [PGAdmin 4](https://www.pgadmin.org/download/)
>
> - [GIT](https://git-scm.com/downloads)

> ## Como Executar
---

- **Clonar repositório `GITHUB`**

```bash
   C:\>  git clone https://github.com/ivancarlosantos/prime-max.git
```

- **Ir até o diretório/pasta localizando a aplicação**

```bash
   C:\> cd [caminho onde realizou o clone]
```

> ## Configurações da aplicação com conexão com PostgreSQL
---
**Primeiramente, você deverá inserir as variáveis de ambiente da aplicação às informações com o banco de dados remoto**

**Para isso, vá em `Edit Configurations...` (ao lado do botão Run/Play verde da IDE)**

**No Campo `Name` insira `PrimeMaxApplication`**

**Em Modify Options, selecione a opção `Add dependencies with "provided" scope to classpath`**

**No Campo de Versão do Java, Selecione a `Versão 17`**

**No Campo de Run Application, aponte a main da aplicação. Ela deve estar no pacote [core.api.prime_max.PrimeMaxApplication.java](src/main/java/core/api/prime_max/PrimeMaxApplication.java)**

**No Campo Environment Variables, selecione o botão para edit environment variables**

**Na caixa de configuração User environmet variables, insira as seguintes variáveis de ambiente:**

```bash
    DB_PASSWORD = AVNS_0mfT6t5QKarNQzHbmzy
 
    DB_URL = jdbc:postgresql://prime-max-database-staging-ivansantos-ec22.b.aivencloud.com:15151/prime-max
 
    DB_USER = avnadmin
```

> ## Adicionar os Plugins de Suporte ao Java e a IDE
---

**Plugins de suporte são plugins para funcionamento e reconhecimento de algumas anotações espalhadas no sistema**

**Para instalar os plugins, vá até a engrenagem no seu canto superior direito da IntelliJ IDE e selecione `Settings`**

**Selecione a opção `Plugins`**

**Abrirá o Market Place de plugins oferecido pela JetBrains**

**Na caixa de texto, digite `Lombok` e aperte a opção install**
- Lombok é um plugin de iteração com código Java para redução de boilerplate, evitando assim, repetição de código

> ## PGAdmin 4
---

**PGAdmin é um serviço de SGBD para acesso e gerência de dados**

**Para criar o recurso Docker do `pgadmin`, execute o comando abaixo:**

````bash
  docker run --name pgadmin -d -p 15432:80 -e PGADMIN_DEFAULT_EMAIL='prime-max@mail.com.br' -e PGADMIN_DEFAULT_PASSWORD='prime-max@mail.com.br' -v pgadmin_data:/var/lib/pgadmin dpage/pgadmin4:latest 
````
**`Conexão do PGADMIN com o Banco de Dados Remoto (STAGING/PRODUCTION)`**

**Clique com o botão direito do mouse/mouse-pad no campo `Server` e selecione a opção `Register > Server`**

**Na aba General, no campo Name, insira `prime_max_database_staging`**

**Na aba Connections preencha os seguintes campos**

- **Host name/Address:** prime-max-database-staging-ivansantos-ec22.b.aivencloud.com
- **Port:** 15151
- **Maintenance Database:** prime-max
- **Username:** avnadmin
- **Password:** AVNS_0mfT6t5QKarNQzHbmzy

**Selecione o toggle button on para salvar o password**

**Na aba Parameters, no campo Value, abra o combobox e selecione a opção `require`**

> ## DEMO
---

**Execute o Run/Play verde da IDE**

- Para acessar a API, via [Swagger-UI](http://localhost:8080/swagger-ui/index.html#/):

````bash
    http://localhost:8080/swagger-ui/index.html#/
````