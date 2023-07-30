CREATE DATABASE DCI;

USE DCI;

drop table Empleado;
drop table Construccion;
drop table Cliente;
drop table Venta;

CREATE TABLE Cliente (
  identification BIGINT PRIMARY KEY NOT NULL,
  name VARCHAR(255),
  first_sur_name VARCHAR(255),
  second_sur_name VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  password VARCHAR(255),
  photo VARCHAR(255),
  id_usuario BIGINT,
  foreign key (id_usuario) references Usuario(id_usuario)
);


CREATE TABLE Construccion (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  initial_investment BIGINT,
  location VARCHAR(255),
  descripcion VARCHAR(255),
  chief_identification BIGINT,
  client_identification BIGINT,
  FOREIGN KEY (chief_identification) REFERENCES Empleado(identification),
  FOREIGN KEY (client_identification) REFERENCES Cliente(identification),
  expected_finish DATE,
  amount_workers INT
);

CREATE TABLE Usuario (
	id_user BIGINT NOT NULL,
    type ENUM("cliente", "empleado")
);


CREATE TABLE Rol (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(25),
    id_user BIGINT,
	foreign key (id_user) references Usuario(id_user)
)

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE Venta (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  description VARCHAR(255),
  price BIGINT,
  date DATE,
  province ENUM("San José", "Alajuela", "Cartago", "Limón", "Guanacaste", "Puntaneras"),
  state ENUM("EN_PRGRESO", "TERMINADO", "PAGADO"),
  photo VARCHAR(255),
  publication_date DATE
);

CREATE TABLE Empleado (
  identification BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(255),
  first_sur_name VARCHAR(255),
  second_sur_name VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  photo VARCHAR(1024),
  active BOOLEAN,
  profession VARCHAR(255),
  password VARCHAR(255),
  id_user BIGINT,
  foreign key (id_user) references Usuario(id_user)
);

-- Inserts adicionales para la tabla "clientes"
INSERT INTO cliente (identification, name, first_sur_name, second_sur_name, phone, email, password, photo)
VALUES (1, 'María', 'López', 'García', '987654321', 'maria@example.com', 'secreto789', 'foto2.jpg');

INSERT INTO cliente (identification, name, first_sur_name, second_sur_name, phone, email, password, photo)
VALUES (2, 'Carlos', 'Martínez', 'Vargas', '456789123', 'carlos@example.com', 'secreto012', 'foto3.jpg');

INSERT INTO cliente (identification, name, first_sur_name, second_sur_name, phone, email, password, photo)
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
INSERT INTO empleado (identification, name, first_sur_name, second_sur_name, email, phone, photo, active, profession, password)
VALUES (2, 'Ana', 'Fernández', 'Morales', 'ana@example.com', '654789321', 'foto5.jpg', true, 'Arquitecta', 'secreto678');

INSERT INTO empleado (identification, name, first_sur_name, second_sur_name, email, phone, photo, active, profession, password)
VALUES (5, 'Javier', 'Rodríguez', 'Soto', 'javier@example.com', '123789456', '', false, 'Ingeniero Civil', 'secreto901');

INSERT INTO empleado (identification, name, first_sur_name, second_sur_name, email, phone, photo, active, profession, password)
VALUES (4, 'Sara', 'López', 'Herrera', 'sara@example.com', '987123654', 'foto7.jpg', true, 'Electricista', 'secreto234');
-- Crear el usuario emanuel con la contraseña costarica99 y otorgarle todos los permisos
CREATE USER 'proyecto'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'proyecto'@'localhost';
FLUSH PRIVILEGES;







