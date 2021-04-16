-- -----------------------------------------------------
-- Table `Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Roles (
    idRol INT(11) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL);


-- -----------------------------------------------------
-- Table `Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuarios (
    idUsuario INT(11) PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    rol VARCHAR(20) NOT NULL,
    clave VARCHAR(20) NOT NULL,
    FOREIGN KEY (rol) REFERENCES Roles(nombre));

INSERT INTO Roles VALUES (1,'Administrador');
INSERT INTO Roles VALUES (2,'Administrativo');
INSERT INTO Roles VALUES (3,'Egresado');
INSERT INTO Roles VALUES (4,'Profesor');
INSERT INTO Roles VALUES (5,'Estudiante');

INSERT INTO Usuarios VALUES (1,'admin','0000000000','admin@mail.com','Administrador','123654');