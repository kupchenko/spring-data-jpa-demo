INSERT INTO users(idUser, username, firstName, lastName, password)
VALUES (0, 'admin', 'Dmitrii', 'Kupchenko', '$2a$16$ZsgP6l22BWZ8vZqUCqE1Pe6f3ntGhCxxd8s/maLcAOgJSdKVUglS2');
-- Username: admin, Password: admin

INSERT INTO roles (name)
VALUES ('ROLE_USER');
INSERT INTO roles(name)
VALUES ('ROLE_ADMIN');

INSERT INTO user_has_roles(user, role)
VALUES (0, 0);
INSERT INTO user_has_roles(user, role)
VALUES (0, 1);