CREATE DATABASE DCI;

USE DCI;

CREATE TABLE Cliente (
  identification BIGINT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  password VARCHAR(255)
);

ALTER TABLE Cliente ADD INDEX idx_cedula (cedula);

CREATE TABLE Construccion (
  id INT PRIMARY KEY AUTO_INCREMENT,
  initial_investment BIGINT,
  location VARCHAR(255),
  descripcion VARCHAR(255),
  FOREIGN KEY (chief_identification) REFERENCES Empleado(identification),
  FOREIGN KEY (client_identification) REFERENCES Cliente(identification),
  expected_finish Date,
  amount_workers INt
);

CREATE TABLE Venta (
  id INT PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(255),
  price BIGINT
);

CREATE TABLE Empleado (
  identification BIGINT PRIMARY KEY,
  name VARCHAR(255),
  first_sur_name VARCHAR(255),
  second_sur_name VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  password VARCHAR(255)
);

-- Insertar registros en la tabla Cliente
INSERT INTO Cliente (nombre, cedula, correo, telefono, contrasena)
VALUES ('Cliente 1', '111111111', 'cliente1@example.com', '1111111111', 'contraseña1'),
       ('Cliente 2', '222222222', 'cliente2@example.com', '2222222222', 'contraseña2'),
       ('Cliente 3', '333333333', 'cliente3@example.com', '3333333333', 'contraseña3');

-- Insertar registros en la tabla Construccion
INSERT INTO Construccion (cedula, localizacion, precio, descripcion, imagen_progreso)
VALUES ('111111111', 'Localizacion 1', 1000.00, 'Descripcion 1', 'imagen1.jpg'),
       ('222222222', 'Localizacion 2', 2000.00, 'Descripcion 2', 'imagen2.jpg'),
       ('333333333', 'Localizacion 3', 3000.00, 'Descripcion 3', 'imagen3.jpg');

-- Insertar registros en la tabla Venta
INSERT INTO Venta (localizacion, precio, descripcion, imagen)
VALUES ('Localizacion 1', 1000.00, 'Descripcion 1', 'imagen1.jpg'),
       ('Localizacion 2', 2000.00, 'Descripcion 2', 'imagen2.jpg'),
       ('Localizacion 3', 3000.00, 'Descripcion 3', 'imagen3.jpg');

-- Insertar registros en la tabla Empleado
INSERT INTO Empleado (nombre, empleado, correo, telefono, contrasena)
VALUES ('Empleado 1', 'empleado1', 'empleado1@example.com', '1111111111', 'contraseña1'),
       ('Empleado 2', 'empleado2', 'empleado2@example.com', '2222222222', 'contraseña2'),
       ('Empleado 3', 'empleado3', 'empleado3@example.com', '3333333333', 'contraseña3');

-- Crear el usuario emanuel con la contraseña costarica99 y otorgarle todos los permisos
CREATE USER 'proyecto'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'proyecto'@'localhost';
FLUSH PRIVILEGES;







