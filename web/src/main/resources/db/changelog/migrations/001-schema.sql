CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (name, password) VALUES('user', '$2a$10$5.jgxHqb.vaxuIpPaxt51OEoip/jgvU/Ga/mOTfAhcuOrkYoVzd6u');
