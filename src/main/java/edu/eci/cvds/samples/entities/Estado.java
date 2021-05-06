package edu.eci.cvds.samples.entities;

public enum Estado{
    ACTIVA("Activa"),
    PROCESO("En Proceso"),
    RESUELTA("Resuelta"),
    CERRADA("Cerrada");

    private String descripcion;

    private Estado(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
