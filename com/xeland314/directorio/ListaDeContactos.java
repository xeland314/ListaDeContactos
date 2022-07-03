package com.xeland314.directorio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import com.xeland314.contactos.Contacto;
import com.xeland314.telefonos.NúmeroDeTeléfono;

public class ListaDeContactos implements Serializable, Comparable<ListaDeContactos> {

    public static final String ToStringTemplate = "ListaDeContactos{nombre='%1s', contactos='%2s'}";

    private String nombre;
    private NavigableSet<Contacto> contactos;

    public ListaDeContactos(String nombre) {
        this.nombre = nombre;
        this.contactos = new TreeSet<Contacto>();
    }

    public void agregarContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    // TODO: evitar agragar contactos con el mismo número de teléfono
    public void agregarContactos(Contacto ... contactos) {
        for(Contacto contacto: contactos) {
            this.contactos.add(contacto);
        }
    }

    public Set<Contacto> buscarContactosPorNúmero(String fragmentoDeBúsqueda) {
        Set<Contacto> resultado = new HashSet<Contacto>();
        for(Contacto contacto: this.contactos) {
            for(NúmeroDeTeléfono número: contacto.getNúmerosTeléfonicos()){
                if(número.contains(fragmentoDeBúsqueda)){
                    resultado.add(contacto);
                }
            }
        }
        return resultado;
    }

    public Set<Contacto> buscarContactosPorAlias(String fragmentoDeBúsqueda) {
        Set<Contacto> resultado = new HashSet<Contacto>();
        for(Contacto contacto: this.contactos) {
            if(contacto.getAlias().contains(fragmentoDeBúsqueda)){
                resultado.add(contacto);
            }
        }
        return resultado;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return String.format(ToStringTemplate, this.nombre, this.contactos);
    }

    @Override
    public int compareTo(ListaDeContactos lista) {
        return this.nombre.compareTo(lista.getNombre());
    }

}
