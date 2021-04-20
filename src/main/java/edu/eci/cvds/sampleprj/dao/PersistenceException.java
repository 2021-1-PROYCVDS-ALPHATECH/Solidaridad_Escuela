package edu.eci.cvds.sampleprj.dao;

/**
 * Clase de excepcion en relacion con la persistencia
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 19/04/2021 v1.0
 */
public class PersistenceException extends Exception {
    
    /**
     * Genera una excepcion con el mensaje dado
     * @param message mensaje de la excepción lanzad
     */
    public PersistenceException(String message){
        super(message);
    }

    /**
     * Genera una excepcion con el mensaje dado y una excepción
     * @param message mensaje de la excepción lanzada
     * @param e excepción
     */
    public PersistenceException(String message, Exception e){
        super(message, e);
    }
    
}
