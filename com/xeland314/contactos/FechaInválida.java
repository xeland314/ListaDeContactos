package com.xeland314.contactos;

public class FechaInválida extends Exception {
    
    public FechaInválida(String fecha) {
        super("Fecha Inválida: " + fecha);
    }

}
