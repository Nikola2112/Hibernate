INSERT INTO client (name)
VALUES ('Yan'),
       ('Oleg'),
       ('Lina'),
       ('Evgeniy'),
       ('Pavel'),
       ('Oksana'),
       ('Anna'),
       ('Petr'),
       ('Irina'),
       ('Vladimir');

INSERT INTO planet (planet_id, name)
VALUES ('MARS22', 'Mars'),
       ('ERTH', 'Earth'),
       ('SATURN11', 'Saturn'),
       ('VENERA88','Venera'),
       ('JUPITER17', 'Jupiter');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES (1, 'ERTH', 'MARS22'),
       (2, 'SATURN11', 'ERTH'),
       (3, 'MARS22', 'JUPITER17'),
       (4, 'JUPITER17', 'SATURN11'),
       (5, 'ERTH', 'JUPITER1'),
       (6, 'SATURN11', 'ERTH'),
       (7, 'JUPITER17', 'ERTH'),
       (8, 'SATURN11', 'VENERA88C'),
       (9, 'VENERA88', 'MARS22'),
       (10, 'VENERA88', 'JUPITER17');