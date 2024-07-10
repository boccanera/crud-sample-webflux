create table if not exists usuario (
                                       id int primary key generated always as identity,
                                       nome varchar(50) not null unique,
                                       senha varchar(500) not null,
                                       ativo boolean not null,
                                       cargo varchar(15)
    );


create table if not exists  cliente (
                                        id integer not null primary key generated always as identity,
                                        nome varchar(120) not null,
                                        cnpj varchar(14) not null unique,
                                        email varchar(70) not null,
                                        telefone varchar(20) not null,
                                        uf varchar(2) not null,
                                        localizacao varchar(100) not null
    );

create table if not exists  venda (
                                      id integer not null primary key generated always as identity,
                                      cliente_id integer not null,
                                      data date not null,
                                      status varchar(30) not null,
                                      valor int not null,
                                      constraint fk_venda_cliente foreign key(cliente_id) references cliente(id)
    );