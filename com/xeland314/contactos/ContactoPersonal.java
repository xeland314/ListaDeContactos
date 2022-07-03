package com.xeland314.contactos;

import com.xeland314.telefonos.NúmeroDeTeléfono;

public class ContactoPersonal extends Contacto {

    public static final String ToStringTemplate = "Contacto{alias='%1s', categoría='%2s', cumpleaños='%3s', númerosDeTeléfono='%4s'}";
    private Fecha cumpleaños;

    public ContactoPersonal(String alias,
            String categoría, Fecha cumpleaños,
            NúmeroDeTeléfono... númerosDeTeléfono) {
        super(alias, categoría, númerosDeTeléfono);
        this.cumpleaños = cumpleaños;
    }

    public void setCumpleaños(Fecha cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public Fecha getCumpleaños() {
        return this.cumpleaños;
    }

    @Override
    public String toString() {
        return String.format(ToStringTemplate, alias, categoría, cumpleaños, númerosDeTeléfono);
    }

}
