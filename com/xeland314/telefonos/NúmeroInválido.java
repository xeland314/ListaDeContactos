package com.xeland314.telefonos;

public class NúmeroInválido extends Exception {
    public NúmeroInválido(String numero){
        super("Numero Invalido: " + numero);
    }
}