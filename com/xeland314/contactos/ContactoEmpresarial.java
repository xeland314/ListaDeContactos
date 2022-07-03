package com.xeland314.contactos;

import com.xeland314.correos.CorreoElectrónico;
import com.xeland314.telefonos.NúmeroDeTeléfono;

public class ContactoEmpresarial extends Contacto {

    public static final String ToStringTemplate = "Contacto{alias='%1s', categoría='%2s', correo='%3s', númerosDeTeléfono='%4s'}";

    private CorreoElectrónico correo;

    public ContactoEmpresarial(String alias,
            String categoría, CorreoElectrónico correo,
            NúmeroDeTeléfono... númerosDeTeléfono) {
        super(alias, categoría, númerosDeTeléfono);
        this.correo = correo;
    }

    public void setCorreo(CorreoElectrónico correoNuevo) {
        this.correo = correoNuevo;
    }

    public CorreoElectrónico getCorreo() {
        return this.correo;
    }

    @Override
    public String toString() {
        return String.format(ToStringTemplate, alias, categoría, correo, númerosDeTeléfono);
    }
}
