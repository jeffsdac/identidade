# iDENTEdade API
Projeto de uma API para cadastro e controle de cadastro de clinicas dentarias

## Endpoints
- __Usuario__
  - [Cadastrar](#cadastrar-usuario)
  - [Atualizar](#atualizar-usuario)
  - [Apagar](#apagar-usuario) 
  - [Listar todos](#listar-todos-usuarios)
  - [Detalhes](#listar-usuario-pelo-id)
  
- __Consulta__ 
  - [Cadastrar](#cadastrar-consulta)
  - [Atualizar](#atualizar-consulta)
  - [Apagar](#deletar-consulta) 
  - [Listar todos](#listar-todas-consultas)
  - [Detalhes](#listar-consulta-pelo-id)
  - [Pegar pelo id do cliente](#listar-todas-consultas-pelo-cliente)
  - [Pegar pelo id da clinica](#listar-todas-consultas-pela-clinica)
  
- __Clinica(s)__
  - [Cadastrar](#cadastrar-clinica)
  - [Atualizar](#atualizar-clinica)
  - [Apagar](#apagar-clinica)
  - [Listar todas](#listar-todas-clinicas)
  - [Detalhes](#listar-clinica-pelo-id)
  
- __Endereço__
  - [Cadastrar](#cadastrar-endereço)
  - [Atualizar](#atualizar-endereco)
  - [Apagar](#apagar-endereco)
  - [Listar todos](#listar-todos-endereços)
  - [Detalhes](#listar-endereço-pelo-id)
  
## Cadastrar usuario
`POST`      /identedade/api/usuario

__Campos de requisição__
| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
|cd_usuario|inteiro|SIM|Chave primária dessa entidade
|nm_usuario|texto|SIM|Nome do usário
|dt_nascimento|data|SIM|Data de nascimento do usuário, serve para sabermos a idade do usuario
|ds_email|texto|SIM|Email do usuario para contato e login
|ds_senha|texto|SIM|Senha do usuario para logar
|nr_telefone|inteiro|SIM|Número de telefone para contato

__Exemplo de requisição__
```js
{
    cd_usuario: 1,
    nm_usuario: 'Jefferson',
    dt_nascimento: '1999-12-27',
    ds_email: 'email@email.com',
    ds_senha: '@mor5758',
    nr_telefone: 11954089999
}
```

__Resposta__

| código | descrição 
|--------|----------
|201| o usuario foi cadastrada com sucesso
|400| campos inválidos

## Listar usuario pelo id

`GET` identedade/api/usuario/{id}

__Exemplo de resposta__

```js
{
    cd_usuario: 1,
    nm_usuario: 'Jefferson',
    dt_nascimento: '1999-12-27',
    ds_email: 'email@email.com',
    ds_senha: '@mor5758',
    nr_telefone: 11954089999
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| não foi  encontrado usuario com esse ID

## Atualizar usuario
`PUT` identedade/api/usuario/{id}

__Exemplo de requisição__
```js
{
    cd_usuario: 1,
    nm_usuario: 'Jefferson',
    dt_nascimento: '1999-12-27',
    ds_email: 'email@email.com',
    ds_senha: '@mor575546848',
    nr_telefone: 11954089999
}
```
__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| não foi  encontrado usuario com esse ID


## Apagar usuario
`DELETE` identedade/api/usuario/{id}

__Resposta__

| código | descrição 
|--------|----------
|204| no-content
|404| não foi  encontrado usuario com esse ID

## Listar todos usuarios

`GET` identedade/api/usuario

__Exemplo de resposta__

```js
{
  {
      cd_usuario: 1,
      nm_usuario: 'Jefferson',
      dt_nascimento: '1999-12-27',
      ds_email: 'email@email.com',
      ds_senha: '@mor5758',
      nr_telefone: 11954089999
  }
  {
      cd_usuario: 2,
      nm_usuario: 'Andressa',
      dt_nascimento: '2001-12-27',
      ds_email: 'email@email.com',
      ds_senha: '@mor5758',
      nr_telefone: 11954229999
  }
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| endereço não encontrado


## Cadastrar consulta
`POST`      /identedade/api/consulta

__Campos de requisição__
| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
|cd_consulta|inteiro|SIM|Primary key de consulta
|cd_usuario|inteiro|SIM|foreign key de consulta, vem de usuario e representa a PK do usuario na API
|cd_clinica|inteiro|SIM|foreign key de clinica, vem da tabela clinica e representa a PK da clinica do sistema
|dt_consulta|data|SIM|Data de quando a consulta será realizada
|nm_medico|texto|SIM|Nome do médico que irá atender
|ds_consulta|texto|SIM|Sobre o que se trata uma consulta
|vl_preco|float|SIM|Valor total da consulta em R$

__Exemplo de requisição__
```js
{
  cd_consulta: 1,
  cd_usuario: 1,
  cd_clinica: 1,
  dt_consulta: '2023-12-27',
  nm_medico: 'José da silva',
  ds_consulta: 'arrumar o aparelho',
  vl_preco: 385.00
}
```

__Resposta__

| código | descrição 
|--------|----------
|201| a consulta foi cadastrada com sucesso
|400| campos inválidos
  
## Atualizar consulta
`PUT` identedade/api/consulta/{id}

__Exemplo de requisição__
```js
{
  cd_consulta: 1,
  cd_usuario: 1,
  cd_clinica: 1,
  dt_consulta: '2023-12-27',
  nm_medico: 'José da silva',
  ds_consulta: 'arrumar o aparelho',
  vl_preco: 385.00
}
```
__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| não foi  encontrado consulta com esse ID

## Deletar consulta
`DELETE` identedade/api/consulta/{id}

__Resposta__

| código | descrição 
|--------|----------
|204| no-content
|404| não foi  encontrado consulta com esse ID

## Listar consulta pelo id

`GET` identedade/api/consulta/{id}

__Exemplo de resposta__

```js
{
  cd_consulta: 1,
  cd_usuario: 1,
  cd_clinica: 1,
  dt_consulta: '2023-12-27',
  nm_medico: 'José da silva',
  ds_consulta: 'arrumar o aparelho',
  vl_preco: 385.00
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| não foi encontrado consulta com esse ID

## Listar todas consultas

`GET` identedade/api/consulta

__Exemplo de resposta__

```js
{
  {
    cd_consulta: 1,
    cd_usuario: 1,
    cd_clinica: 1,
    dt_consulta: '2023-12-27',
    nm_medico: 'José da silva',
    ds_consulta: 'arrumar o aparelho',
    vl_preco: 385.00
  }
  {
    cd_consulta: 2,
    cd_usuario: 2,
    cd_clinica: 1,
    dt_consulta: '2023-12-24',
    nm_medico: 'José da silva',
    ds_consulta: 'arrumar o aparelho',
    vl_preco: 385.00
  }
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| endereço não encontrado


## Listar todas consultas pelo cliente

`GET` identedade/api/consulta/cliente/{id}

__Exemplo de resposta__

```js
{
  {
    cd_consulta: 1,
    cd_usuario: 1,
    cd_clinica: 1,
    dt_consulta: '2023-12-27',
    nm_medico: 'José da silva',
    ds_consulta: 'arrumar o aparelho',
    vl_preco: 385.00
  }
  {
    cd_consulta: 45,
    cd_usuario: 1,
    cd_clinica: 1,
    dt_consulta: '2023-12-24',
    nm_medico: 'José da silva',
    ds_consulta: 'Limpeza de dente',
    vl_preco: 157.50
  }
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| id do cliente não foi encontrado


## Listar todas consultas pela clinica

`GET` identedade/api/consulta/clinica/{id}

__Exemplo de resposta__

```js
{
  {
    cd_consulta: 87,
    cd_usuario: 2,
    cd_clinica: 1,
    dt_consulta: '2023-12-27',
    nm_medico: 'José da silva',
    ds_consulta: 'arrumar o aparelho',
    vl_preco: 385.00
  }
  {
    cd_consulta: 454,
    cd_usuario: 32,
    cd_clinica: 1,
    dt_consulta: '2023-12-24',
    nm_medico: 'José da silva',
    ds_consulta: 'Limpeza de dente',
    vl_preco: 157.50
  }
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| id da clinica não foi encontrado


## Cadastrar Clinica
`POST`      /identedade/api/clinica

__Campos de requisição__
| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
|cd_clinica|inteiro|SIM|primary key da clinica
|nm_clinica|texto|SIM|nome da clinica na API
|ds_email|texto|SIM|email para contato e login na API
|ds_senha|texto|SIM|senha para login na API

__Exemplo de requisição__
```js
{
    cd_clinica: 1,
    nm_clinica: 'Sorriso branco',
    ds_email: 'contato@sorrisobranco.com.br',
    ds_senha: '@RT453sdwxa89!!@'
}
```

__Resposta__

| código | descrição 
|--------|----------
|201| a clinica foi cadastrada com sucesso
|400| campos inválidos

## Atualizar clinica
`PUT` identedade/api/clinica/{id}

__Exemplo de requisição__
```js
{
    cd_clinica: 1,
    nm_clinica: 'Sorriso branco',
    ds_email: 'contato@sorrisobranco.com.br',
    ds_senha: '@RT453sdwxa89!!@'
}
```
__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| não foi  encontrado clinica com esse ID


## Apagar clinica
`DELETE` identedade/api/clinica/{id}

__Resposta__

| código | descrição 
|--------|----------
|204| no-content
|404| não foi  encontrado clinica com esse ID


## Listar todas clinicas
`GET` identedade/api/clinicas

__Exemplo de resposta__

```js
{
  {
      cd_clinica: 1,
      nm_clinica: 'Sorriso branco',
      ds_email: 'contato@sorrisobranco.com.br',
      ds_senha: '@RT453sdwxa89!!@'
  }
  {
      cd_clinica: 2,
      nm_clinica: 'Sorriso colgate',
      ds_email: 'contato@sorrisocolgate.com.br',
      ds_senha: '@#$578dawdFGVCX15'
  }
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| endereço não encontrado


## Listar clinica pelo id
`GET` identedade/api/clinicas/{id}

__Exemplo de resposta__

```js
{
  cd_clinica: 1,
  nm_clinica: 'Sorriso branco',
  ds_email: 'contato@sorrisobranco.com.br',
  ds_senha: '@RT453sdwxa89!!@'
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| Não foi encontrado clinica com esse id

## Cadastrar endereço
`POST`      /identedade/api/endereco

__Campos de requisição__
| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
|cd_clinica|inteiro|SIM|Foreign key e Primary key vinda da entidade clinica
|ds_logradouro|texto|SIM|Logradouro do endereço onde a clinica está
|ds_estado|texto|SIM|estado onde a clinica está em UF (ex: SP, RJ)
|nr_numero|inteiro|SIM|numero onde a clinca está

__Exemplo de requisição__
```js
{
  cd_clinica: 2,
  ds_logradouro: 'R. Alvares Cunha 158',
  ds_bairro: 'zeca pagodinho bairro',
  ds_estado: 'ES',
  nr_numero: 157
}
```

__Resposta__

| código | descrição 
|--------|----------
|201| o usuario foi cadastrada com sucesso
|400| campos inválidos

## Apagar endereco
`DELETE` identedade/api/endreco/{id}

__Resposta__

| código | descrição 
|--------|----------
|204| no-content
|404| não foi  encontrado endereco com esse ID


## Atualizar endereco
`PUT` identedade/api/endereco/{id}

__Exemplo de requisição__
```js
{
  cd_clinica: 2,
  ds_logradouro: 'R. Alvares Cunha 158',
  ds_bairro: 'zeca pagodinho bairro',
  ds_estado: 'ES',
  nr_numero: 157
}
```
__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| não foi  encontrado endereco com esse ID

## Listar todos endereços
`GET` identedade/api/endereco

__Exemplo de resposta__

```js
{
  {
    cd_clinica: 2,
    ds_logradouro: 'R. Alvares Cunha 158',
    ds_bairro: 'zeca pagodinho bairro',
    ds_estado: 'ES',
    nr_numero: 157
  }
  {
    cd_clinica: 4,
    ds_logradouro: 'R. Alvares Pereira 158',
    ds_bairro: 'frajola bairro',
    ds_estado: 'SP',
    nr_numero: 187
  }
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| URL não encontrada

## Listar endereço pelo id
`GET` identedade/api/endereco/{id}

__Exemplo de resposta__

```js
{
  cd_clinica: 2,
  ds_logradouro: 'R. Alvares Cunha 158',
  ds_bairro: 'zeca pagodinho bairro',
  ds_estado: 'ES',
  nr_numero: 157
}
```

__Resposta__

| código | descrição 
|--------|----------
|200| os dados foram retornados
|404| Não foi encontrado nenhum endereço com esse ID
