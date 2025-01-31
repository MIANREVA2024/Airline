/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'Miguel', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (id_user, username, password) VALUES (default, 'Noemi', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');

/* Profiles */
INSERT INTO profiles (id_user, email, name, phone, picture)
VALUES (1, 'miguel@msc.com', 'Miguel', '123390163', 'utils/erDiagram.jpg');
INSERT INTO profiles (id_user, email, name, phone, picture)
VALUES (2, 'noemi@msc.com', 'Noemi', '123390045', 'utils/erDiagram.jpg');

/* Roles Users */
INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2);

/* Airports */
INSERT INTO airports (city, code, country, name) VALUES ('Madrid', 'A1', 'España', 'Aeropuerto Internacional de Madrid');
INSERT INTO airports (city, code,country, name) VALUES ('Lima', 'A2','Peru', 'Aeropuerto Internacional Jorge Chavez');
INSERT INTO airports (city, code, country, name) VALUES ('Barcelona', 'A3', 'España', 'Aeropuerto Internacional de Barcelona');



/* Flights */

INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('AV74', 150, '2025-01-30T17:00:00', '2025-01-30T23:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('AV15', 150, '2025-01-30T12:00:00', '2025-01-30T19:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('AV35', 150, '2025-01-30T09:00:00', '2025-01-30T12:30:00', 2,  3, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('AV70', 150, '2025-01-30T12:00:00', '2025-01-30T19:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('AV12', 150, '2025-01-27T17:00:00', '2025-01-27T23:30:00', 3,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('AV45', 150, '2025-01-26T12:00:00', '2025-01-26T19:30:00', 3,  1, true);

/* Reservations
INSERT INTO reservations (reservation_time, seats, id_flight, id_user) VALUES ('2025-01-30 17:00:00', 2, 2, 2),
INSERT INTO reservations (reservation_time, seats, id_flight, id_user) VALUES ('2025-01-30 17:00:00', 2, 1, 2),
INSERT INTO reservations (reservation_time, seats, id_flight, id_user) VALUES ('2025-01-30 17:00:00', 1, 1, 1);*/







