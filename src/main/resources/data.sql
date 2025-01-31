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

/* Flights */
/*INSERT INTO flights (origin, destination, date, totalSeats, availableSeats, available) VALUES ('Peru','madrid', '2025-01-30', 50, 2, true);*/









/* Airports */
INSERT INTO airports (city, code, country, name) VALUES ('Madrid', 'A1', 'España', 'Aeropuerto Internacional de Madrid');
INSERT INTO airports (city, code,country, name) VALUES ('Lima', 'A2','Peru', 'Aeropuerto Internacional Jorge Chavez');
INSERT INTO airports (city, code, country, name) VALUES ('Barcelona', 'A3', 'España', 'Aeropuerto Internacional de Barcelona');
