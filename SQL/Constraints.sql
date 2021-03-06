/*ALTER TABLE Usuarios
ADD CONSTRAINT email_check
CHECK(
    email ~* (?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
);*/

ALTER TABLE Roles
ADD CONSTRAINT Roles_CK
CHECK (
	nombre IN ('Administrador', 'Estudiante', 'Profesor', 'Egresado', 'Administrativo')
);

ALTER TABLE Solicitudes
ADD CONSTRAINT EstadoSolicitud_CK
CHECK (
    estado IN ('Activa', 'En Proceso', 'Resuelta', 'Cerrada')
);


ALTER TABLE categorias 
ADD CONSTRAINT EstadoCategoria_CK
CHECK (
    estado IN ('Valida', 'Invalida')
);
