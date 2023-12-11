create table socios(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(100) not null,
    dtcreate timestamp not null,
    dtupdate timestamp,

    primary key(id)
);