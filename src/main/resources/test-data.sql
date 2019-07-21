INSERT INTO users(idUser, username, firstName, lastName)
VALUES (0, 'dmitrii', 'Dmitrii', 'Kupchenko');

INSERT INTO roles (name)
VALUES ('USER');
INSERT INTO roles(name)
VALUES ('ADMIN');

INSERT INTO user_has_roles(user, role)
VALUES (0, 0);
INSERT INTO user_has_roles(user, role)
VALUES (0, 1);