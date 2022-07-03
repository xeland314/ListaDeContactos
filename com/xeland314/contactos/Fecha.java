package com.xeland314.contactos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha implements Serializable {

    public static final String ToStringTemplate = "Fecha{fecha='%1s'}";
    private String fechaEnTexto;
    private LocalDate fecha;

    public Fecha(String fechaEnTexto) {
        try {
            this.validarFechaEnTexto(fechaEnTexto);
        } catch (FechaInválida e) {
            e.printStackTrace();
        }
        this.fechaEnTexto = fechaEnTexto;
        this.fecha = LocalDate.parse(this.fechaEnTexto, DateTimeFormatter.ofPattern("yyyy/M/d") );
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    // FIXME: mejorar la expresión regular
    private boolean esUnaFechaVálida(String fechaEnTexto) {
        String expresiónRegular = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3})";
        expresiónRegular += "(/)((((0)?[13578]|1[02])(/)((0)?[1-9]|[12][0-9]|3[01]))|(((0)?[469]|11)(/)";
        expresiónRegular += "((0)?[1-9]|[12][0-9]|30))|((0)?2(/)((0)?[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})";
        expresiónRegular += "((0)?[48]|[2468][048]|[13579][26])|(((0)?[48]|[2468][048]|[3579][26])00))(/)(0)?2(/)29))$";
        Pattern patrón = Pattern.compile(expresiónRegular);
        Matcher expresión = patrón.matcher(fechaEnTexto);
        return expresión.matches();
    }

    private void validarFechaEnTexto(String fechaEnTexto) throws FechaInválida {
        if(!this.esUnaFechaVálida(fechaEnTexto)) {
            throw new FechaInválida(fechaEnTexto);
        }
    }

    @Override
    public String toString() {
        return String.format(ToStringTemplate, fechaEnTexto);
    }
    
}
