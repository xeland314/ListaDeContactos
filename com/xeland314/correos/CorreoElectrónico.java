package com.xeland314.correos;

import java.io.Serializable;

public abstract class CorreoElectrónico implements Serializable, Comparable<CorreoElectrónico> {
    
    protected String correo;

    public CorreoElectrónico(String correo) {
        try {
            this.validarCorreoElectrónico(correo);
        } catch (CorreoInválido e) {
            e.printStackTrace();
        }
        this.correo = correo;
    }

    public String getCorreoElectrónico() {
        return this.correo;
    }

    protected abstract boolean esUnCorreoVálido(String correo);

    private void validarCorreoElectrónico(String correo) throws CorreoInválido {
        if(!this.esUnCorreoVálido(correo)) {
            throw new CorreoInválido(correo);
        }
    }

    @Override
    public int compareTo(CorreoElectrónico correo) {
        return this.correo.compareTo(correo.getCorreoElectrónico());
    }
}
