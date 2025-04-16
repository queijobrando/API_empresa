create table setor (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    descricao varchar(200) not null,
    area varchar(100) not null,

    primary key(id)
);