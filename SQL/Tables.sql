-- -----------------------------------------------------
-- Table `Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Roles (
    idRol VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(20) UNIQUE NOT NULL
);

-- -----------------------------------------------------
-- Table `Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuarios (
    idUsuario VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    rol VARCHAR(20) NOT NULL,
    clave VARCHAR(20) NOT NULL,
    FOREIGN KEY (rol) REFERENCES Roles(nombre)
);
-- -----------------------------------------------------
-- Table `Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Categorias (
    idCategoria VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    descripcion VARCHAR(1000),
    fechaCreacion DATE NOT NULL,
    fechaModificacion DATE NOT NULL,
    estado VARCHAR(10) NOT NULL
);

-- -----------------------------------------------------
-- Table `Ofetas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Ofertas (
    idOferta VARCHAR(50) PRIMARY KEY,
    idUsuario VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    fechaCreacion DATE NOT NULL,
    fechaModificacion DATE NOT NULL,
    estado VARCHAR(10) NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

-- -----------------------------------------------------
-- Table `Necesidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Necesidades (
    idNecesidad VARCHAR(50) PRIMARY KEY,
    idUsuario VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    urgencia VARCHAR(50) NOT NULL,
    fechaCreacion DATE NOT NULL,
    fechaModificacion DATE NOT NULL,
    estado VARCHAR(10) NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

INSERT INTO Roles VALUES ('1','Administrador');
INSERT INTO Roles VALUES ('2','Administrativo');
INSERT INTO Roles VALUES ('3','Egresado');
INSERT INTO Roles VALUES ('4','Profesor');
INSERT INTO Roles VALUES ('5','Estudiante');

INSERT INTO Usuarios VALUES ('1','admin','0000000000','admin@mail.com','Administrador','123654');