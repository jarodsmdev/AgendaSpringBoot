DROP DATABASE agenda;
CREATE DATABASE agenda;

USE agenda;

CREATE TABLE contacto(
	idcontacto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    fechanac DATE,
    celular VARCHAR(15),
    email VARCHAR(50)
);

SELECT * FROM contacto;