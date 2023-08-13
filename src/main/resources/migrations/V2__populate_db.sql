INSERT INTO client (id,name)
VALUES
(10,'Anna'),
(11,'Nikolai'),
(12,'Denys'),
(13,'Petr'),
(14,'Yulia'),
(15,'Alex'),
(16,'Michel'),
(17,'Josh'),
(18,'Angelina'),
(19,'Daniella');

INSERT INTO planet (id , name)
VALUES
('MARS88','Mars'),
('SATURN99','Saturn'),
('VENERA21','Venera'),
('MERCURY12','Mercury'),
('JUPITER22','Jupiter');
INSERT INTO ticket (id , created_at, client_id, from_planet_id, to_planet_id)
VALUES
    (20,now(), 10, 'MARS88','JUPITER22'),
    (19,now(), 11, 'SATURN99','MERCURY12'),
    (18,now(), 12, 'VENERA21','VENERA21'),
    (17,now(), 13, 'MERCURY12','SATURN99'),
    (16,now(), 14, 'JUPITER22','MARS88'),
    (14,now(), 16, 'MARS88','JUPITER22'),
    (13,now(), 17, 'VENERA21','MERCURY12'),
    (12,now(), 18, 'SATURN99','VENERA21'),
    (11,now(), 19, 'MERCURY12','SATURN99'),
    (10,now(), 20, 'JUPITER22','MARS88');