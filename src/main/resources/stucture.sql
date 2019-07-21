DROP TABLE roles IF EXISTS;

CREATE TABLE roles
(
    idRole integer identity primary key,
    name   varchar(50) not null
);

DROP TABLE users IF EXISTS;

CREATE TABLE users
(
    idUser    integer identity primary key,
    username  varchar(50) not null,
    firstName varchar(50) not null,
    lastName  varchar(50) not null
);

DROP TABLE user_has_roles IF EXISTS;

CREATE TABLE user_has_roles
(
    user integer,
    role integer
);