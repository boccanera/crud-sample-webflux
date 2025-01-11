<br/>
<div align="center">
<h3 align="center">SAMPLE</h3>
<p align="center">
</div>


### SOBRE

Desenvolvimento de um sistema para cadastro de clientes e vendas de uma empresa, assim como exibir
alguns relatórios de vendas realizadas.

### Tecnologias

- Java (versão 17)
- Spring Boot (versão 2.7.3)
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot Starter WebFlux
- Spring Boot Starter Security
- Spring Boot Starter Validation
- Spring Boot DevTools
- Spring Cache with Caffeine

### Padrões

- Clean code
- SOLID
- Strategy
- Cache
- Factory (em andamento)
- [HTTP Api Design](https://learn.microsoft.com/pt-br/azure/architecture/best-practices/api-design)

### Prerequisitos

IDE de sua escolha, java 17 jre, Docker ou Postgresql 14, ferramenta de testes de API (postman, insomnia).

### Configurando ambiente
- Para rodar esse projeto escolha uma IDE de sua preferência.
- Caso possua preferência por utilizar docker para o postgres siga os passos:
  1. Utilizando o terminal e na pasta devops, execute esses comandos no terminal:
     ```sh 
     docker-compose up -d
  - Assim que finalizar os testes digite:
     ```sh
    docker-compose down
    ```
    ```sh
    docker-compose rm
- Caso possua o postgres 14 em sua máquina, configure o ambiente no properties dentro da pasta resources e rode o script.sql da pasta ./devops
- Você deve possuir o java 17 jre instalado em sua máquina

### Rodando o projeto

Após rodar o projeto na IDE de sua escolha siga as etapas abaixo:

- Acesse localhost:8080/usuarios para seu criar usuário e faça um request POST enviando como body o exemplo abaixo:
  ```
  {
  "nome": "sample",
  "senha": "sample",
  "ativo": true,
  "cargo": "administrador"
  }
- Caso queira pular o processo de login para o gerar token JWT, deixo abaixo um válido por 7 dias 
```
eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJZb3V4Iiwic3ViIjoiSldUIFRva2VuIiwidXN1YXJpbyI6InlvdXgiLCJjYXJnbyI6ImFkbWluaXN0cmFkb3IiLCJpYXQiOjE3MjA1NjUzNDMsImV4cCI6MTcyMTE3MDE0M30.YOjobVt3fmdUEgnZdNYepuk4B65YTpnOmcozGu3Ju_Qvo9euzm89K45gSvvRGweHEOs1cRM6V59seT3VFlrCLA
```
- Utilizando um navegador de sua preferência, acesse localhost:8080/login e insira o nome e senha do request do /usuarios para pegar seu token que estará disponível no terminal do spring;
- Agora para permanecer autenticado coloque a key Authorization no Header de cada request;
- Para testar, faça um request GET em uma ferramente de testes (postman, por exemplo) para /estados e confira se está exibindo os estados na resposta;
- Prossiga e crie um Cliente com um POST para /clientes com o body abaixo (lembre-se de colocar o Authorization com o token no header):
```
{
  "nome": "cliente",
  "cnpj": "45399180000164",
  "email": "cliente@teste.com",
  "telefone": "11999999999",
  "uf": "SP",
  "localizacao": "165161981516216"
}
```
- Para realizar uma venda faça um POST para /vendas com o body:
```
{
  "cliente": {
    "nome": "Cliente",
    "cnpj": "45399180000164",
    "email": "cliente@teste.com",
    "telefone": "9999999999",
    "uf": "SP",
    "localizacao": "165161981516216"
  },
  "status": "AGUARDANDO_PAGAMENTO",
  "valor": 1020.00
}
```
- Faça um request GET para /relatorios/vendas para pegar o relatorio de vendas de determinados clientes com top 10 do faturamento total. Dica: Você pode inserir mais vendas e mais clientes para gerar um relatório mais completo.
- Você pode testar novamente o request e perceber uma diminuição considerável no request pois estamos utilizando caffeine cache para esse request.

### Prova de conceito
Reuni capturas de tela como evidência disponíveis no link [Dropbox](https://www.dropbox.com/scl/fi/spzqydg1otb411ud9l5xm/Prova-de-conceito.zip?rlkey=p6w4ksj2cplcba1zhsi3kno3j&st=u4ue24hk&dl=0)

### Contato
Caso possua alguma dúvida pode me um [enviar email](mailto:nailtonboccanera@gmail.com).

- LinkedIn [@nailtonboccanera](https://www.linkedin.com/in/nailtonboccanera/);
