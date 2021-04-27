package edu.eci.cvds.samples.services;

/**
 * Clase de excepcion para la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */
public class ExcepcionSolidaridad extends Exception{

    public static final String NO_CATEGORY_REGISTRED = "La categoria indicada no existe.";
    public static final String INVALID_NAME = "El nombre debe ser unico.";
    public static final String INVALID_ID = "El Id debe ser unico.";
    public static final String NO_APPLICATION_REGISTRED = "La solicitud indicada no existe.";
    public static final String INVALID_NUM_SOLICITUDES = "El nuevo numero de solicitudes no puede ser menor a las solicitudes ya existentes.";
    public static final String INVALID_REGISTRED = "Se ha alcanzado el tope de solicitudes.";
    public static final String INVALID_UPDATE = "Los datos ingresados son los mismos.";


    /**
     * Genera una excepcion con el mensaje dado
     * @param message mensaje de la excepción lanzad
     */
    public ExcepcionSolidaridad(String message){
        super(message);
    }

    /**
     * Genera una excepcion con el mensaje dado y una excepción
     * @param message mensaje de la excepción lanzada
     * @param e excepción
     */
    public ExcepcionSolidaridad(String message, Exception e){
        super(message, e);
    }
    
}
