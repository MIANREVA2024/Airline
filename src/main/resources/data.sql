/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'Miguel', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (id_user, username, password) VALUES (default, 'Noemi', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');

/* Profiles */
INSERT INTO profiles (id_profile,email, address, user_id) VALUES (default,'miguel@mail.com', 'portal 1',1);
INSERT INTO profiles (id_profile,email, address, user_id) VALUES (default,'noemi@mail.com', 'portal 1',2);

/* Roles Users */
INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2);


/*flight*/
INSERT INTO flights (id, origin, destination, date, total_seats, available_seats, available) VALUES
(1, 'New York', 'Los Angeles', '2025-02-01', 150, 150, true),
(2, 'London', 'Paris', '2025-02-02', 100, 100, true),
(3, 'Tokyo', 'Seoul', '2025-02-03', 200, 200, true),
(4, 'Sydney', 'Melbourne', '2025-01-25', 50, 0, false);

/*
INSERT INTO users (id_user, username, password)
VALUES (default, 'admin', '$2a$10$yI7wK2JpQqTpQcZJsOCSbeZtxm4GZ05soEayPJP7fHCN9L6oDGmAe');admin123
$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO*/
