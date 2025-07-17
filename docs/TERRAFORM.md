<p align="center">
 <img src="https://img.shields.io/static/v1?label=Dev&message=Ivan Santos&color=8257E5&labelColor=000000" alt="@ivan_santos"/>
 <img src="https://img.shields.io/static/v1?label=Status&message=Em Desenvolvimento&color=&labelColor=90876I" alt="Status"/>
</p>

> # Criação e Construção do Ambiente de Infraestrutura

> ### Descrição do Projeto
**O projeto consiste na construção da infraestutura em nuvem para consumo de uma plataforma API Web  [prime-max]()**

> ## Tecnologias e Ferramentas Utilizadas
**Utilizado o Terraform para construção e gerenciamento dos recursos em nuvem**

**Terraform é uma ferramenta de software que gerencia infraestrutura como código (IaaC)**

**O Terraform usa arquivos de estado para armazenar informações sobre os componentes de infraestrutura na nuvem. O arquivo de estado mapeia o código da infraestrutura para recursos do mundo real**

**O ciclo de vida dos recursos no Terraform tem três estágios principais: Criação, Modificação, Destruição**

> ## **Realize o Download em seu sistema operacional:**

- [Terraform](https://developer.hashicorp.com/terraform/install?product_intent=terraform)

> ## **Modo de Instalação do Terraform no Windows**

**Após realizado o download do link acima, faça a extração `[unzip]` do pacote baixado**

**Crie uma pasta no seu diretório raíz `C:\` com o nome de `terraform`**

**Dentro da pasta `terraform` no diretório `C:\`, cole o conteúdo extraído**

**Na lupa do Windows, digite `editar variáveis de ambiente do sistema`**

**Na opção: `Variáveis de usuário para Administrador`, selecione a opção Path e dê `editar`**

**Clique no botão `Novo` e coloque a seguinte path:**
```bash
   C:\> terraform
```
**Pressione `OK`**

**Abra o terminal (CMD/PowerShell/GitBash) e insira o comando abaixo:**
```bash
   C:\> terraform --version
```

**Caso retorne as seguintes informações abaixo:**

```bash
   C:\> terraform --version
   Terraform v1.10.1
   on windows_amd64
```

**Seu terraform foi configurado com sucesso!**