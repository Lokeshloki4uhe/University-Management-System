CREATE DATABASE UniversityManagement;
USE UniversityManagement;

CREATE TABLE Login(
    username VARCHAR(30),
    password VARCHAR(30)
);

INSERT INTO Login (username, password) VALUES ('Lokesh', 'Lokesh44');

SELECT * FROM Login;
