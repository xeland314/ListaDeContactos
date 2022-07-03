package com.xeland314.telefonos;

import java.io.Serializable;

public abstract class NúmeroDeTeléfono implements Serializable, Comparable<NúmeroDeTeléfono> {

    protected String númeroDeTeléfono;

    public NúmeroDeTeléfono(String númeroDeTeléfono) {
        try {
            this.validarNúmero(númeroDeTeléfono);
        } catch (NúmeroInválido e) {
            e.printStackTrace();
        }
        this.númeroDeTeléfono = númeroDeTeléfono;
    }

    public String getNúmeroDeTeléfono() {
        return this.númeroDeTeléfono;
    }

    protected abstract boolean esUnNúmeroVálido(String númeroDeTeléfono);

    private void validarNúmero(String númeroDeTeléfono) throws NúmeroInválido {
        if(!esUnNúmeroVálido(númeroDeTeléfono)) {
            throw new NúmeroInválido(númeroDeTeléfono);
        }
    }

    public boolean contains(CharSequence s) {    
        return this.númeroDeTeléfono.contains(s);   
    }    

    @Override
    public int compareTo(NúmeroDeTeléfono número) {
        return this.númeroDeTeléfono.compareTo(número.getNúmeroDeTeléfono());
    }

}