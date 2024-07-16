create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(300) not null unique,
    data_criacao TIMESTAMP not null,
    autor varchar(100) not null,
    curso varchar(100) not null,
    ativo tinyint not null,

    primary key(id)
);