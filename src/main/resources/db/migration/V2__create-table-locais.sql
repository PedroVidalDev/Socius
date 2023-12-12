create table locais(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    categoria varchar(100) not null,
    qntMaxPessoas int not null,
    qntHoras float not null,
    dtcreate timestamp not null,
    dtupdate timestamp,

    primary key(id)
);