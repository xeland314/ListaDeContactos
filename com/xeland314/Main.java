package com.xeland314;

import com.xeland314.contactos.ContactoEmpresarial;
import com.xeland314.contactos.ContactoPersonal;
import com.xeland314.contactos.Fecha;
import com.xeland314.correos.Gmail;
import com.xeland314.directorio.Directorio;
import com.xeland314.directorio.ListaDeContactos;
import com.xeland314.telefonos.TeléfonoMóvil;

public class Main {

    public static void main(String[] args) {
        
        Directorio miDirectorio = new Directorio("Christopher");
        ListaDeContactos listaGoogle = new ListaDeContactos("Google");

        listaGoogle.agregarContactos(
            new ContactoPersonal(
                "Alex", "EPN", new Fecha("2001/6/21"),
                new TeléfonoMóvil("0987654321")
            ),             new ContactoPersonal(
                "Cris", "EPN", new Fecha("2001/06/21"),
                new TeléfonoMóvil("0987654322"),
                new TeléfonoMóvil("0987654323")
            ), new ContactoEmpresarial("Cris2", "EPN",
                new Gmail("cris.v@gmail.com"),
                new TeléfonoMóvil("0987654324")
            )
        );

        miDirectorio.agregarListaDeContactos(listaGoogle);
        System.out.println(miDirectorio);

        Directorio.imprimirBúsqueda(miDirectorio.buscar("Cris2", Directorio.BÚSQUEDA_POR_ALIAS));

    }

}
