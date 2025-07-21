> ## Instalação Maven Windows 10/11

**Primeiramente, realize o download do Maven**

> [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)

**Descompacte o arquivo ZIP baixado em uma pasta no seu computador**

**Sugestão C:\Program Files\maven**

**Tendo a pasta/arquivo descompactado vá em ”Editar as variáveis de ambiente do sistema“ no seu Painel de Controle**

**Depois vá em ”Variáveis de Ambiente” e clique em ”Novo…” para adicionar uma nova variável de ambiente**

**Crie a variável `MAVEN_HOME` com o caminho onde você descompactou os arquivos: `C:\maven\apache-maven-x.x.x` (o x.x.x é o número da versão no momento do seu download) e clique em ”OK” para salvar a variável**

**Tendo ela criada, selecione `Path` e depois `Editar` e adicione `%MAVEN_HOME%\bin` ao Path clicando em `Novo`**

**Feito isto vá ao Prompt de Comando (CMD) e digite o comando:**

```bash
   C:\> mvn --version
```

**Se tudo foi realizado corretamente, terá o seguinte retorno no prompt do terminal**

```bash
   C:\> mvn --version
Apache Maven 3.9.9 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: C:\apache-maven-3.9.9
Java version: 17.0.10, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17
Default locale: pt_BR, platform encoding: UTF-8
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```
