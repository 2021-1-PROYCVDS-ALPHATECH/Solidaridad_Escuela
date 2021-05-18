-- -----------------------------------------------------
-- Datos a cargar cuando se realizan las pruebas
-- -----------------------------------------------------

INSERT INTO Roles VALUES ('Administrador');
INSERT INTO Roles VALUES ('Administrativo');
INSERT INTO Roles VALUES ('Egresado');
INSERT INTO Roles VALUES ('Profesor');
INSERT INTO Roles VALUES ('Estudiante');

-- Clave 1234
INSERT INTO Usuarios VALUES ('1', 'Mario Doyle', '(887) 257-4554', 'puc@tumuhge.ke', 'Administrador', '1234', 2);
INSERT INTO Usuarios VALUES ('2', 'Devin Walton', '(638) 927-3662', 'sevdijek@dahapawop.sj', 'Estudiante', '1234', 100);
INSERT INTO Usuarios VALUES ('3', 'Allen Wright', '(785) 458-8387', 'swazguec@nilkit.bw', 'Estudiante', '1234',5);
INSERT INTO Usuarios VALUES ('4', 'Garrett Elliott', '(450) 244-1462', 'powbo@tumpin.sc', 'Estudiante', '1234',1);


INSERT INTO Categorias (idCategoria, nombre, descripcion, fechaCreacion, fechaModificacion, estado) VALUES ('1', 'Categoria1', 'DescripcionC1', '2013-06-01', '2013-06-01', 'Valida');
INSERT INTO Categorias (idCategoria, nombre, descripcion, fechaCreacion, fechaModificacion, estado) VALUES ('2', 'Categoria2', 'DescripcionC2', '2014-06-01', '2014-06-01', 'Valida');
INSERT INTO Categorias (idCategoria, nombre, descripcion, fechaCreacion, fechaModificacion, estado) VALUES ('3', 'Categoria3', 'DescripcionC3', '2015-06-01', '2015-06-01', 'Valida');

INSERT INTO Solicitudes VALUES ('1', '2', 'DescripcionSN1', 'Activa', '1', '2013-06-01', '2013-06-01');
INSERT INTO Solicitudes VALUES ('2', '3', 'DescripcionSN2', 'Activa', '2', '2014-06-01', '2014-06-01');
INSERT INTO Solicitudes VALUES ('3', '2', 'DescripcionSO3', 'Activa', '1', '2013-06-01', '2013-06-01');
INSERT INTO Solicitudes VALUES ('4', '3', 'DescripcionSO4', 'Activa', '2', '2014-06-01', '2014-06-01');
INSERT INTO Solicitudes VALUES ('5', '4', 'DescripcionSO5', 'Activa', '2', '2014-06-01', '2014-06-01');
INSERT INTO Solicitudes VALUES ('6', '2', 'DescripcionSO6', 'Cerrada', '2', '2014-06-01', '2014-06-01');
INSERT INTO Solicitudes VALUES ('7', '2', 'DescripcionSN7', 'Activa', '2', '2014-06-01', '2014-06-01');
INSERT INTO Solicitudes VALUES ('8', '2', 'DescripcionSO8', 'Activa', '2', '2014-06-01', '2014-06-01');




INSERT INTO Necesidades VALUES ('1', 'Solicitud1', 'Media');
INSERT INTO Necesidades VALUES ('2', 'Solicitud2', 'Alta');
INSERT INTO Necesidades VALUES ('7', 'Solicitud7', 'Baja');

INSERT INTO Ofertas VALUES('3', 'Solicitud3');
INSERT INTO Ofertas VALUES('4', 'Solicitud4');
INSERT INTO Ofertas VALUES('5', 'Solicitud5');
INSERT INTO Ofertas VALUES('6', 'Solicitud6');
INSERT INTO Ofertas VALUES('8', 'Solicitud8');


INSERT INTO Respuestas VALUES('1', '2', 'Respuesta1', 'RespuestaComent1', '2016-06-01', '1');










