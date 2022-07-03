package com.xeland314.correos;

public class CorreoInválido extends Exception {
    
    public CorreoInválido(String correo) {
        super("Correo electrónico inválido: " + correo);
    }

}
