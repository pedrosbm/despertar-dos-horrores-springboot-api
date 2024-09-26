create table if not exists users(
    id bigint not null auto_increment,
    nome varchar(255),
    senha varchar(255),
    cargo varchar(255),
    primary key(id)
);

insert into users(id, nome, senha, cargo) values(1, 'Pedro', 'Pedrosenha', 'PLAYER');
insert into users(id, nome, senha, cargo) values(2, 'nellaf', 'nellafsenha', 'MESTRE'); 