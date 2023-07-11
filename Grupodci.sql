CREATE DATABASE DCI;

USE DCI;

CREATE TABLE clientes (
    identification BIGINT PRIMARY KEY,
    name VARCHAR(255),
    first_sur_name VARCHAR(255),
    second_sur_name VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(255),
    password VARCHAR(255),
    photo VARCHAR(255)
);

CREATE TABLE construccion (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    initial_investment BIGINT,
    location VARCHAR(255),
    description VARCHAR(255),
    chief_id BIGINT,
    expected_finish DATE,
    amount_workers INT,
    FOREIGN KEY (chief_id) REFERENCES clientes (identification)
);

CREATE TABLE ventas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    price BIGINT,
    provincia VARCHAR(255),
    ruta_imagen VARCHAR(255)
);

CREATE TABLE empleados (
    identification BIGINT PRIMARY KEY,
    name VARCHAR(255),
    first_sur_name VARCHAR(255),
    second_sur_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    photo VARCHAR(255),
    active BOOLEAN,
    profession VARCHAR(255),
    password VARCHAR(255)
);

-- Inserts adicionales para la tabla "clientes"
INSERT INTO clientes (identification, name, first_sur_name, second_sur_name, phone, email, password, photo)
VALUES (1, 'María', 'López', 'García', '987654321', 'maria@example.com', 'secreto789', 'foto2.jpg');

INSERT INTO clientes (identification, name, first_sur_name, second_sur_name, phone, email, password, photo)
VALUES (2, 'Carlos', 'Martínez', 'Vargas', '456789123', 'carlos@example.com', 'secreto012', 'foto3.jpg');

INSERT INTO clientes (identification, name, first_sur_name, second_sur_name, phone, email, password, photo)
VALUES (3, 'Laura', 'González', 'Hernández', '741258963', 'laura@example.com', 'secreto345', 'foto4.jpg');


-- Inserts adicionales para la tabla "construccion"
INSERT INTO construccion (id, initial_investment, location, description, chief_id, expected_finish, amount_workers)
VALUES (1, 80000, 'Ciudad B', 'Construcción de centro comercial', 2, '2024-06-30', 20);

INSERT INTO construccion (id, initial_investment, location, description, chief_id, expected_finish, amount_workers)
VALUES (2, 300000, 'Ciudad C', 'Construcción de hospital', 3, '2025-03-31', 50);

INSERT INTO construccion (id, initial_investment, location, description, chief_id, expected_finish, amount_workers)
VALUES (3, 1000000, 'Ciudad D', 'Construcción de complejo residencial', 1, '2024-12-31', 100);

-- Inserts adicionales para la tabla "ventas"
INSERT INTO ventas (id, description, price, provincia, ruta_imagen)
VALUES (2, 'Producto 2', 200, 'Provincia B', 'imagen2.jpg');

INSERT INTO ventas (id, description, price, provincia, ruta_imagen)
VALUES (3, 'Producto 3', 150, 'Provincia C', 'imagen3.jpg');

INSERT INTO ventas (id, description, price, provincia, ruta_imagen)
VALUES (4, 'Producto 4', 300, 'Provincia D', 'imagen4.jpg');


-- Inserts adicionales para la tabla "empleados"
INSERT INTO empleados (identification, name, first_sur_name, second_sur_name, email, phone, photo, active, profession, password)
VALUES (2, 'Ana', 'Fernández', 'Morales', 'ana@example.com', '654789321', 'foto5.jpg', true, 'Arquitecta', 'secreto678');

INSERT INTO empleados (identification, name, first_sur_name, second_sur_name, email, phone, photo, active, profession, password)
VALUES (3, 'Javier', 'Rodríguez', 'Soto', 'javier@example.com', '123789456', 'foto6.jpg', true, 'Ingeniero Civil', 'secreto901');

INSERT INTO empleados (identification, name, first_sur_name, second_sur_name, email, phone, photo, active, profession, password)
VALUES (4, 'Sara', 'López', 'Herrera', 'sara@example.com', '987123654', 'foto7.jpg', true, 'Electricista', 'secreto234');


CREATE USER 'proyecto'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'proyecto'@'localhost';
FLUSH PRIVILEGES;





