package edu.eci.cvds.samples.services;

/**
 * Clase de excepcion para la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 19/04/2021 v1.0
 */
public class ExcepcionSolidaridadEscuela extends Exception{
    /**
     * Genera una excepcion con el mensaje dado
     * @param message mensaje de la excepción lanzad
     */
    public ExcepcionSolidaridadEscuela(String message){
        super(message);
    }

    /**
     * Genera una excepcion con el mensaje dado y una excepción
     * @param message mensaje de la excepción lanzada
     * @param e excepción
     */
    public ExcepcionSolidaridadEscuela(String message, Exception e){
        super(message, e);
    }
    
}
