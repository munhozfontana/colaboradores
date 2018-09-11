# Desafio Colaboradores

Proposta de desafio feita pela Ecos Serviços de Engenharia de Sistemas Ltda

## Frameworks

Angular5 no front-end
Spring Boot no Back-end

Bootstrap
Material Angular

### Pré Requisitos

npm
angular-cli
JDK8
banco de dados PostgreSQL

### Instalação

Instale o postgreSQL e crie o banco de dados chamado: colaboradores

```
https://www.postgresql.org/download/

```

Com o npm já instalado, faça.

```
npm install -g @angular/cli
```

Entre na pasta frontend e digite:
```
npm i
```
Após a intalação:

```
ng serve
```

para Iniciar o back end:

baixe o STS
```
https://spring.io/tools/sts/all
```
execute-o, e inicie a aplicação

## SCRIPTS INCIAIS

INSERT INTO public.usuario(login, senha) VALUES ( 'admin', 'admin');


INSERT INTO public.cargo(nome)	VALUES ('Analista de sistemas');
INSERT INTO public.cargo( nome)	VALUES ('Programador Junior');
INSERT INTO public.cargo( nome)	VALUES ('Programador pleno');
INSERT INTO public.cargo( nome)	VALUES ('Programador Senior');
INSERT INTO public.departamento( nome)	VALUES ( 'departamento de teste');
INSERT INTO public.departamento( nome)	VALUES ( 'departamento de execução');
INSERT INTO public.departamento( nome)	VALUES ( 'departamento de requisitos');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'Movel');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'Fixo');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'Trabalho');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'Linkedin');
INSERT INTO public.tipo_contato( nome)	VALUES ( 'E-mail');


