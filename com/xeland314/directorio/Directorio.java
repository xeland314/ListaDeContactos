package com.xeland314.directorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import com.xeland314.contactos.Contacto;

public class Directorio implements Serializable {
    
    public static final String ToStringTemplate = "Directorio{nombre='%1s', listasDeContactos='%2s'}";
    public static final int BÚSQUEDA_POR_ALIAS = 1, BÚSQUEDA_POR_NÚMERO = 2;

    private String nombre;
    private ArrayList<ListaDeContactos> listasDeContactos;

    public Directorio(String nombre) {
        this.nombre = nombre;
        this.listasDeContactos = new ArrayList<ListaDeContactos>();
    }

    public void agregarListaDeContactos(ListaDeContactos lista) {
        this.listasDeContactos.add(lista);
    }

    public static void imprimirBúsqueda(SortedSet<Contacto> resultado) {
        System.out.println(resultado);
    }

    public SortedSet<Contacto> buscar(String fragmentoDeBúsqueda, int métodoDeBúsqueda){
        switch(métodoDeBúsqueda){
            case BÚSQUEDA_POR_ALIAS:
                return this.buscarPorAlias(fragmentoDeBúsqueda);
            case BÚSQUEDA_POR_NÚMERO:
                return this.buscarPorNúmero(fragmentoDeBúsqueda);
            default:
                return null;
        }
    }
    
    private SortedSet<Contacto> buscarPorAlias(String fragmentoDeBúsqueda) {
        SortedSet<Contacto> resultados = new TreeSet<Contacto>();
        for (ListaDeContactos lista: listasDeContactos) {
            resultados.addAll(lista.buscarContactosPorAlias(fragmentoDeBúsqueda));
        }
        return resultados;
    }

    private SortedSet<Contacto> buscarPorNúmero(String fragmentoDeBúsqueda) {
        SortedSet<Contacto> resultados = new TreeSet<Contacto>();
        for (ListaDeContactos lista: listasDeContactos) {
            resultados.addAll(lista.buscarContactosPorAlias(fragmentoDeBúsqueda));
        }
        return resultados;
    }

    @Override
    public String toString() {
        return String.format(ToStringTemplate, this.nombre, this.listasDeContactos);
    }  

}
