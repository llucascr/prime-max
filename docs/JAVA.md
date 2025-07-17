> ## Instalação Java Windows 10/11
**Primeiramente, faça o downloado do Java 17 JDK**

> [https://adoptium.net/temurin/releases/?os=windows&arch=x64&package=jdk&version=17](https://adoptium.net/temurin/releases/?os=windows&arch=x64&package=jdk&version=17)

**Execute a instalação conforme instruções do executável do Produto**

> ### Configurando o JDK

**Para esse etapa, será necessário que o **JDK ESTEJA INSTALADO****

 - Inicie configurando a variável de ambiente do Windows chamada “JAVA_HOME“, com o valor do caminho do JDK instalado na sua máquina. 
No meu ficou com o caminho `C:\Program Files\Java\jdk-17`

 - Acesse a pasta “Este Computador”, clique com botão direito e depois em propriedade:

 - Depois, clique em `Configurações avançadas do sistema` presente no seu canto direito da tela:

 - Clique no botão “Variáveis de Ambiente”:

**Abrindo a janela, você consegue configurar apenas no usuário logado ou para o sistema (todos os usuários). No meu caso, escolhi configurar para variáveis de ambiente de sistema:**

**Selecione Path e clique em Editar**

**Pressione o botão novo**

**Depois, é só colocar o caminho do diretório abaixo:**
```bash
   C:\> \Program Files\Java\jdk-17
```