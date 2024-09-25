create table if not exists personagens(
    id bigint not null auto_increment,
    nome varchar(255),
    aura_principal varchar(255),
    hp int,
    eneru int,
    intuicao int,
    agilidade int,
    nivel_despertar int,
    hp_atual int,
    eneru_atual int,
    personagem_imagem varchar(255),
    user_id bigint,
    primary key(id),
    foreign key (user_id) references users(id)
);