DROP TABLE roles IF EXISTS;

CREATE TABLE roles
(
    idRole integer identity,
    name   varchar(50) not null,
    PRIMARY KEY (idRole)
);

DROP TABLE users IF EXISTS;

CREATE TABLE users
(
    idUser    integer identity primary key,
    username  varchar(50)  not null,
    password  varchar(256) not null,
    firstName varchar(50)  not null,
    lastName  varchar(50)  not null
);

DROP TABLE user_has_roles IF EXISTS;

CREATE TABLE user_has_roles
(
    user integer,
    role integer
);