package com.xeland314.telefonos;

public class NúmeroDuplicado extends Exception{
    
    public NúmeroDuplicado(String numero){
        super("Este número ya existe: " + numero);
    }
}