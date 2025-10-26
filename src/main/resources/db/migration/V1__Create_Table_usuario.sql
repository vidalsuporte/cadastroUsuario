    create table tb_usuario(

        id bigint not null auto_increment,
        nome varchar(100) not null ,
        email varchar(100) not null unique,
        senha varchar(100) not null,
        telefone varchar(50),
        primary key(id)

    );