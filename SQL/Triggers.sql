CREATE OR REPLACE FUNCTION fechasCategoria() RETURNS TRIGGER AS
$$
BEGIN
	new.fechaCreacion := current_date;
	new.fechaModificacion := current_date;
	RETURN new;
END;
$$ LANGUAGE 'plpgsql';

CREATE trigger AD_Categoria
BEFORE INSERT ON public.Categorias 
FOR EACH ROW
EXECUTE PROCEDURE fechasCategoria();


CREATE OR REPLACE FUNCTION fechaModCategoria() RETURNS TRIGGER AS
$$
BEGIN
	new.fechaModificacion := current_date;
	RETURN new;
END;
$$ LANGUAGE 'plpgsql';

CREATE trigger MO_Categoria
BEFORE INSERT ON public.Categorias 
FOR EACH ROW
EXECUTE PROCEDURE fechaModCategoria();

CREATE trigger AD_Necesidad
BEFORE INSERT ON public.Necesidades
FOR EACH ROW
EXECUTE PROCEDURE fechasCategoria();

CREATE trigger MO_Necesidad
BEFORE INSERT ON public.Necesidades
FOR EACH ROW
EXECUTE PROCEDURE fechaModCategoria();
