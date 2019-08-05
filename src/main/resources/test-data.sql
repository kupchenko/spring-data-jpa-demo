INSERT INTO users(idUser, username, firstName, lastName, password)
VALUES (0, 'admin', 'Dmitrii', 'Kupchenko', '$2a$16$C.xPFLoR39hnIAUvCYquM.xQ.1B.RQsznASDLCmS3mquXaA5/Ydcm');

INSERT INTO roles (name)
VALUES ('ROLE_USER');
INSERT INTO roles(name)
VALUES ('ROLE_ADMIN');

INSERT INTO user_has_roles(user, role)
VALUES (0, 0);
INSERT INTO user_has_roles(user, role)
VALUES (0, 1);