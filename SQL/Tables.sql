
-- -----------------------------------------------------
-- Table `Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Roles (
    nombre VARCHAR(20)  PRIMARY KEY
);

-- -----------------------------------------------------
-- Table `Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuarios (
    idUsuario VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    rol VARCHAR(20) NOT NULL,
    clave VARCHAR(100) NOT NULL,
    numSolicitudes INTEGER NOT NULL,
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
    estado VARCHAR(10) DEFAULT 'Activa'
);

-- -----------------------------------------------------
-- Table `Solicitudes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Solicitudes (
    idSolicitud VARCHAR(50) PRIMARY KEY,
    idUsuario VARCHAR(50) NOT NULL,
    descripcion VARCHAR(1000) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    idCategoria VARCHAR(50) NOT NULL,
    fechaCreacion DATE NOT NULL,
    fechaModificacion DATE NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario),
    FOREIGN KEY (idCategoria) REFERENCES Categorias(idCategoria)
);

-- -----------------------------------------------------
-- Table `Necesidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Necesidades (
    idNecesidad VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    urgencia VARCHAR(50) NOT NULL,
    FOREIGN KEY (idNecesidad) REFERENCES Solicitudes(idSolicitud)
);

-- -----------------------------------------------------
-- Table `Ofertas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Ofertas (
    idOferta VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    FOREIGN KEY (idOferta) REFERENCES Solicitudes(idSolicitud)
);

-- -----------------------------------------------------
-- Table `Respuestas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Respuestas (
    idRespuesta VARCHAR(50) PRIMARY KEY,
    idUsuario VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    comentarios VARCHAR(1000) NOT NULL,
    fechaCreacion DATE NOT NULL,
    idSolicitud VARCHAR(50) NOT NULL,
    FOREIGN KEY (idSolicitud) REFERENCES Solicitudes(idSolicitud),
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)

);