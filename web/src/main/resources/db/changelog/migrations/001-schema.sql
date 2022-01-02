CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    password varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO users (name, password) VALUES('user', '$2a$10$5.jgxHqb.vaxuIpPaxt51OEoip/jgvU/Ga/mOTfAhcuOrkYoVzd6u');
