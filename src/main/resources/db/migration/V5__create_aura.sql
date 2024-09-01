create table if not exists auras(
    id bigint not null auto_increment,
    nome varchar(255),
    principal boolean,
    nivel int,
    personagem_id bigint,
    primary key(id),
    foreign key (personagem_id) references personagens(id)
);