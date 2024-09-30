create table if not exists users(
    id bigint not null auto_increment,
    nome varchar(255),
    senha varchar(255),
    cargo varchar(255),
    primary key(id)
);

create table if not exists personagens(
    id bigint not null auto_increment,
    nome varchar(255),
    hp int,
    eneru int,
    intuicao int,
    agilidade int,
    nivel_despertar int,
    pontos int,
    hp_atual int,
    eneru_atual int,
    personagem_imagem varchar(255),
    user_id bigint,
    primary key(id),
    foreign key (user_id) references users(id) ON DELETE CASCADE
);

create table if not exists itens(
    id bigint not null auto_increment,
    nome varchar(255),
    tipo varchar(255),
    icone varchar(255),
    descricao varchar(255),
    personagem_id bigint,
    primary key(id),
    foreign key (personagem_id) references personagens(id) ON DELETE CASCADE
);