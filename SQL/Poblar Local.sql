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
INSERT INTO Usuarios VALUES ('2', 'Devin Walton', '(638) 927-3662', 'sevdijek@dahapawop.sj', 'Estudiante', '1234', 5);
INSERT INTO Usuarios VALUES ('3', 'Allen Wright', '(785) 458-8387', 'swazguec@nilkit.bw', 'Estudiante', '1234',5);
INSERT INTO Usuarios VALUES ('4', 'Garrett Elliott', '(450) 244-1462', 'powbo@tumpin.sc', 'Estudiante', '1234',1);


INSERT INTO Categorias VALUES ('1', 'Categoria1', 'DescripcionC1', '2013-06-01', '2013-06-01', 'Activa');
INSERT INTO Categorias VALUES ('2', 'Categoria2', 'DescripcionC2', '2014-06-01', '2014-06-01', 'Activa');
INSERT INTO Categorias VALUES ('3', 'Categoria3', 'DescripcionC3', '2015-06-01', '2015-06-01', 'Activa');

INSERT INTO Solicitudes VALUES ('1', '2', 'DescripcionSN1', 'Activa', '1', '2013-06-01', '2013-06-01');
INSERT INTO Solicitudes VALUES ('2', '3', 'DescripcionSN2', 'Activa', '2', '2014-06-01', '2014-06-01');
INSERT INTO Solicitudes VALUES ('3', '2', 'DescripcionSO3', 'Activa', '1', '2013-06-01', '2013-06-01');
INSERT INTO Solicitudes VALUES ('4', '3', 'DescripcionSO4', 'Activa', '2', '2014-06-01', '2014-06-01');
INSERT INTO Solicitudes VALUES ('5', '4', 'DescripcionSO5', 'Activa', '2', '2014-06-01', '2014-06-01');


INSERT INTO Necesidades VALUES ('1', 'Solicitud1', 'Media');
INSERT INTO Necesidades VALUES ('2', 'Solicitud2', 'Alta');

INSERT INTO Ofertas VALUES('3', 'Solicitud3');
INSERT INTO Ofertas VALUES('4', 'Solicitud4');
INSERT INTO Ofertas VALUES('5', 'Solicitud5');









