<p align="center">
 <img src="https://img.shields.io/static/v1?label=Dev&message=Ivan Santos&color=8257E5&labelColor=000000" alt="@ivan_santos"/>
 <img src="https://img.shields.io/static/v1?label=Status&message=Em Desenvolvimento&color=&labelColor=90876I" alt="Status"/>
</p>

> # **Gerador de chave SSH para autenticação em plataformas em nuvem e gerenciadores de arquivos**

> ## Tecnologias e Ferramentas Utilizadas
**Utilizado `ssh-keygen` para gerar chaves ssh criptografadas para conexão com plataformas de serviços em nuvem**

> ## Realização do processo de geração do par de chaves

**No Terminal (Powershell/CMD) digite o comando abaixo para ir a raíz do terminal**
```bash
   C:\> cd ~
```

**Na raíz do Terminal (Powershell/CMD), digite o comando abaixo para gerar seu par de chaves ssh**

```bash
   C:\> ssh-keygen -t ed25519 -C "e-mail"
```

**Par de chaves gerado, validar ao agent**
```bash
   C:\> eval "$(ssh-agent -s)"
```

**Adicionar o par de chaves ao arquivo extrusor**
```bash
   C:\> ssh-add .ssh/id_25519
```
**Gravar no txt a chave pública (opcional)**
```bash
   C:\> cat .ssh/id_ed25519.pub >> id_ed25519.txt
```

**Copiar a chave pública**
```bash
   C:\> cat .ssh/id_ed25519.pub
```