create table clinica (cd_clinica number(19,0) generated as identity, ativo number(1,0) not null, email varchar2(255 char), nome varchar2(255 char), primary key (cd_clinica));
create table consulta (cd_consulta number(19,0) generated as identity, descricao varchar2(255 char), nome_medico varchar2(255 char), preco float(24) not null, clinica_cd_clinica number(19,0), usuario_cd_usuario number(19,0), primary key (cd_consulta));
create table endereco (cd_endereco number(19,0) generated as identity, estado varchar2(255 char), logradouro varchar2(255 char), numero number(10,0) not null, clinica_cd_clinica number(19,0), primary key (cd_endereco));
create table usuario (cd_usuario number(19,0) generated as identity, ativo number(1,0) not null, email varchar2(255 char), nome varchar2(255 char), role varchar2(255 char), senha varchar2(255 char), primary key (cd_usuario));
alter table consulta add constraint FKa3c6udhaaayxf1o2vb3la8p4u foreign key (clinica_cd_clinica) references clinica;
alter table consulta add constraint FK30wy9ub5c148pdnloicplmy54 foreign key (usuario_cd_usuario) references usuario;
alter table endereco add constraint FKcvts936nv8jco42e9pivurk74 foreign key (clinica_cd_clinica) references clinica;
