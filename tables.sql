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

