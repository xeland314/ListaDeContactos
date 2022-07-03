package com.xeland314.contactos;

import java.io.Serializable;
import java.util.NavigableSet;
import java.util.TreeSet;

import com.xeland314.telefonos.NúmeroDeTeléfono;

public abstract class Contacto implements Serializable, Comparable<Contacto> {

    protected String alias, categoría;
    protected NavigableSet<NúmeroDeTeléfono> númerosDeTeléfono;

    public Contacto(String alias, String categoría, NúmeroDeTeléfono... númerosDeTeléfono) {
        this.alias = alias;
        this.categoría = categoría;
        this.númerosDeTeléfono = new TreeSet<NúmeroDeTeléfono>();
        this.agregarNúmerosDeTeléfono(númerosDeTeléfono);
    }

    public void agregarNúmeroDeTeléfono(NúmeroDeTeléfono numeroDeTelefono) {
        this.númerosDeTeléfono.add(numeroDeTelefono);
    }

    public void agregarNúmerosDeTeléfono(NúmeroDeTeléfono... númerosDeTeléfono) {
        for(NúmeroDeTeléfono número : númerosDeTeléfono) {
            this.númerosDeTeléfono.add(número);
        }
    }

    public void setAlias(String aliasNuevo) {
        this.alias = aliasNuevo;
    }

    public void setCategoría(String categoríaNueva) {
        this.categoría = categoríaNueva;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCategoría() {
        return this.categoría;
    }

    public NavigableSet<NúmeroDeTeléfono> getNúmerosTeléfonicos() {
        return this.númerosDeTeléfono;
    }

    @Override
    public int compareTo(Contacto contacto) {
        return this.alias.compareTo(contacto.getAlias());
    }

}