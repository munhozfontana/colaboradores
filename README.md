# Desafio Colaboradores

Proposta de desafio feita pela Ecos ServiÃ§os de Engenharia de Sistemas Ltda

## Frameworks

Angular5 no front-end
Spring Boot no Back-end

Bootstrap
Material Angular

### PrÃ© Requisitos

npm
angular-cli
JDK8
banco de dados PostgreSQL

### InstalaÃ§Ã£o

Instale o postgreSQL e crie o banco de dados chamado: colaboradores

```
https://www.postgresql.org/download/

```

Com o npm jÃ¡ instalado, faÃ§a.

```
npm install -g @angular/cli
```

Entre na pasta frontend e digite:
```
npm i
```
ApÃ³s a intalaÃ§Ã£o:

```
ng serve
```

para Iniciar o back end:

baixe o STS
```
https://spring.io/tools/sts/all
```
execute-o, e inicie a aplicaÃ§Ã£o

## SCRIPTS INCIAIS

INSERT INTO public.usuario(login, senha) VALUES ( 'admin', 'admin');


INSERT INTO public.cargo(nome)	VALUES ('Analista de sistemas');
INSERT INTO public.cargo( nome)	VALUES ('Programador Junior');
INSERT INTO public.cargo( nome)	VALUES ('Programador pleno');
INSERT INTO public.cargo( nome)	VALUES ('Programador Senior');
INSERT INTO public.departamento( nome)	VALUES ( 'departamento de teste');
INSERT INTO public.departamento( nome)	VALUES ( 'departamento de execuÃ§Ã£o');
INSERT INTO public.departamento( nome)	VALUES ( 'departamento de requisitos');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'Movel');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'Fixo');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'Trabalho');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'Linkedin');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'E-mail');

### Anotações geradas pelo Angular

# O frontend foi gerado com [Angular CLI](https://github.com/angular/angular-cli) version 1.7.3, onde posteriormente foi atualizado para a versão 6.2.1.



Servidor de desenvolvimento

Execute `ng serve` para um servidor dev. Navegue até `http: // localhost: 4200 /`. O aplicativo será recarregado automaticamente se você alterar qualquer um dos arquivos de origem.


## Andaime de código

Execute `ng generate component nome do componente` para gerar um novo componente. Você também pode usar o `ng generate directive | pipe | service | class | guarda | interface | enum | module`.


## Build

Execute `ng build` para construir o projeto. Os artefatos de construção serão armazenados no diretório `dist /`. Use o sinalizador `-prod` para uma construção de produção.

## Testes de unidade em execução

Execute `ng test` para executar os testes unitários via [Karma] (https://karma-runner.github.io).

## Execução de testes de ponta a ponta

Execute `ng e2e` para executar os testes de ponta a ponta via [Protractor] (http://www.protractortest.org/).

## Ajuda adicional

Para obter mais ajuda sobre o Angular CLI, use `ng help` ou vá conferir o [Angular CLI README] (https://github.com/angular/angular-cli/blob/master/README.md).


## CARGA DE DADOS

 INSERT INTO public.cargo(nome)	VALUES ('Analista de sistemas'); INSERT INTO public.cargo( nome)	VALUES ('Programador Junior'); INSERT INTO public.cargo( nome)	VALUES ('Programador pleno'); INSERT INTO public.cargo( nome)	VALUES ('Programador Senior'); INSERT INTO public.departamento( nome)	VALUES ( 'departamento de teste'); INSERT INTO public.departamento( nome)	VALUES ( 'departamento de execuÃ§Ã£o'); INSERT INTO public.departamento( nome)	VALUES ( 'departamento de requisitos'); INSERT INTO public.tipo_contato( nome)	VALUES ( 'Movel'); INSERT INTO public.tipo_contato( nome)	VALUES ( 'Fixo'); INSERT INTO public.tipo_contato( nome)	VALUES ( 'Trabalho'); INSERT INTO public.tipo_contato( nome) VALUES ( 'Linkedin'); INSERT INTO public.tipo_contato( nome)	VALUES ( 'E-mail');
INSERT INTO public.tipo_contato(nome)VALUES ( 'Facebook'); 


