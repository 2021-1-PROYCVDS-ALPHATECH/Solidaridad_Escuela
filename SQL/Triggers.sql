CREATE OR REPLACE FUNCTION fechas() RETURNS TRIGGER AS $fechas$
DECLARE
BEGIN
	new.fechaCreacion := current_date;
	new.fechaModificacion := current_date;
	RETURN new;
END;
$fechas$ LANGUAGE 'plpgsql';

CREATE TRIGGER AD_Categoria
BEFORE INSERT ON public.Categorias 
FOR EACH ROW
EXECUTE PROCEDURE fechas();

CREATE TRIGGER AD_Solicitud
BEFORE INSERT ON public.Solicitudes
FOR EACH ROW
EXECUTE PROCEDURE fechas();

CREATE OR REPLACE FUNCTION fechaModificacion() RETURNS TRIGGER AS $fechaModificacion$
DECLARE
BEGIN
	new.fechaModificacion := current_date;
	RETURN new;
END;
$fechaModificacion$ LANGUAGE 'plpgsql'; 


CREATE TRIGGER MO_Categoria
BEFORE UPDATE ON public.Categorias 
FOR EACH ROW
EXECUTE PROCEDURE fechaModificacion();

CREATE TRIGGER MO_Solicitud
BEFORE UPDATE ON public.Solicitudes
FOR EACH ROW
EXECUTE PROCEDURE fechaModificacion();



