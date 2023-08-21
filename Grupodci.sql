CREATE DATABASE DCI;

USE DCI;

drop table rol;
drop table Construccion;
drop table Cliente;
drop table Empleado;
drop table Venta;
drop table Usuario;
drop table archivos;


CREATE TABLE Cliente (
  identification BIGINT PRIMARY KEY NOT NULL,
  name VARCHAR(255),
  username VARCHAR(255),
  first_sur_name VARCHAR(255),
  second_sur_name VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  password VARCHAR(255),
  photo VARCHAR(255),
  id_user BIGINT NOT NULL,
  active BOOLEAN,
  foreign key (id_user) references Usuario(id_user)
);


CREATE TABLE Construccion (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  initial_investment BIGINT,
  location VARCHAR(255),
  description VARCHAR(255),
  chief_identification BIGINT,
  client_identification BIGINT,
  FOREIGN KEY (chief_identification) REFERENCES Empleado(identification),
  FOREIGN KEY (client_identification) REFERENCES Cliente(identification),
  expected_finish DATE,
  amount_workers INT
);

CREATE TABLE Usuario (
	id_user BIGINT PRIMARY KEY NOT NULL,
    email VARCHAR(25),
    username VARCHAR(25)
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
  state ENUM("EN_PROGRESO", "TERMINADO", "PAGADO"),
  photo VARCHAR(1024),
  publication_date DATE
);

CREATE TABLE Empleado (
  identification BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(255),
  username VARCHAR(255),
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

CREATE TABLE performance(
	identification BIGINT NOT NULL PRIMARY KEY,
    observations VARCHAR(1025),
    score INT,
    achieved_goals VARCHAR(1025),
    supervisor_identification BIGINT,
    foreign key (supervisor_identification) references Empleado(identification)
);
    
CREATE TABLE archivos (
    id BIGINT PRIMARY KEY,
    file_path VARCHAR(255),
    date DATE,
    icono VARCHAR(255)
);

-- Inserción 1
INSERT INTO archivos (id, file_path, date, icono)
VALUES (1, '/ruta/del/archivo1.txt', '2023-08-18', '/ruta/del/icono1.png');

-- Inserción 2
INSERT INTO archivos (id, file_path, date, icono)
VALUES (2, '/ruta/del/archivo2.txt', '2023-08-19', '/ruta/del/icono2.png');

-- Inserts adicionales para la tabla "clientes"
	INSERT INTO cliente (identification, name, first_sur_name, second_sur_name, phone, email, password, photo, id_user, active, username)
	VALUES (1, 'María', 'López', 'García', '987654321', 'maria@example.com', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'https://firebasestorage.googleapis.com/v0/b/proyecto-724ee.appspot.com/o/297699440_597905048370147_1274343335336204594_n.jpg?alt=media&token=d129282d-12ea-4311-9d17-5d5656c3e41f', 1, true, "maria");

INSERT INTO empleado (identification, name, first_sur_name, second_sur_name, phone, email, password, photo, id_user, profession, active, username)
VALUES (2, 'Carlos', 'Martínez', 'Vargas', '456789123', 'carlos@example.com', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', '', 2, "gerente", true, "carlos");

INSERT INTO cliente (identification, name, first_sur_name, second_sur_name, phone, email, password, photo)
VALUES (3, 'Laura', 'González', 'Hernández', '741258963', 'laura@example.com', 'secreto345', 'foto4.jpg');

-- Inserts adicionales para la tabla "rol"

-- Inserts adicionales para la tabla de "usuario"
INSERT INTO usuario(id_user, email, username) VALUES (1, "maria@example.com", "maria");
INSERT INTO usuario(id_user, email, username) VALUES (2, "carlos@example.com", "carlos");


-- Inserts adicionales para la tabla de "performance"
INSERT INTO performance (identification, observations, score, achieved_goals, supervisor_identification)
VALUES (1, 'Exceeded expectations on the recent project.', 95, 'Completed project ahead of schedule and met all performance targets.', 2);

-- Insert 2
INSERT INTO performance (identification, observations, score, achieved_goals, supervisor_identification)
VALUES (2, 'Consistently delivers high-quality work.', 88, 'Achieved monthly sales targets for the last quarter.', 2);

-- Insert 3
INSERT INTO performance (identification, observations, score, achieved_goals, supervisor_identification)
VALUES (3, 'Actively seeks out opportunities for improvement.', 75, 'Contributed to process optimization initiative by identifying inefficiencies.', 2);

-- Insert 4
INSERT INTO performance (identification, observations, score, achieved_goals, supervisor_identification)
VALUES (4, 'Strong team player and collaborator.', 92, 'Led a successful cross-functional project that improved customer satisfaction.', 2);

-- Insert 5
INSERT INTO performance (identification, observations, score, achieved_goals, supervisor_identification)
VALUES (5, 'Demonstrates exceptional problem-solving skills.', 80, 'Resolved a critical technical issue that saved the company from potential losses.', 118930275);



-- Inserts adicionales para la tabla "construccion"
INSERT INTO construccion (initial_investment, location, description, chief_identification, expected_finish, amount_workers)
VALUES (80000, 'Ciudad B', 'Construcción de centro comercial', 2, '2024-06-30', 20);

INSERT INTO construccion (initial_investment, location, description, chief_identification, expected_finish, amount_workers)
VALUES (300000, 'Ciudad C', 'Construcción de hospital', 2, '2025-03-31', 50);

INSERT INTO construccion (initial_investment, location, description, chief_identification, expected_finish, amount_workers)
VALUES (1000000, 'Ciudad D', 'Construcción de complejo residencial', 2, '2024-12-31', 100);

-- Inserts adicionales para la tabla "ventas"
INSERT INTO venta (description, price, province, photo, state)
VALUES ('Producto 2', 200, "Limón", 'imagen2.jpg', "EN_PROGRESO");

INSERT INTO venta (description, price, province, photo, state)
VALUES ('Producto 3', 150, "San José", 'imagen3.jpg', "PAGADO");

INSERT INTO venta (description, price, province, photo, state)
VALUES ('Producto 4', 300, "Alajuela", 'imagen4.jpg', "TERMINADO");


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







