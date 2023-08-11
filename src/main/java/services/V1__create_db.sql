CREATE TABLE client (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(200) NOT NULL
);
CREATE TABLE planet (
                        id VARCHAR(10) PRIMARY KEY,
                        name VARCHAR(500) NOT NULL
);
CREATE TABLE ticket (
                        id BIGSERIAL PRIMARY KEY,
                        created_at TIMESTAMP NOT NULL,
                        client_id BIGINT NOT NULL,
                        from_planet_id VARCHAR(10) NOT NULL,
                        to_planet_id VARCHAR(10) NOT NULL,
                        FOREIGN KEY (client_id) REFERENCES client(id),
                        FOREIGN KEY (from_planet_id) REFERENCES planet(id),
                        FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
