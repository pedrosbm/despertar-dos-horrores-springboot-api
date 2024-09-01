create table if not exists itens(
    id bigint not null auto_increment,
    nome varchar(255),
    tipo varchar(255),
    icone varchar(255),
    descricao varchar(255),
    personagem_id bigint,
    primary key(id),
    foreign key (personagem_id) references personagens(id)
);