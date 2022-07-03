package com.xeland314.telefonos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeléfonoMóvil extends NúmeroDeTeléfono {

    public static String ToStringTemplate = "TeléfonoMóvil{númeroDeTeléfono='%1s'}";  

    public TeléfonoMóvil(String numeroDeTelefono) {
        super(numeroDeTelefono);
    }
    
    @Override
    protected boolean esUnNúmeroVálido(String númeroDeTeléfono) {
        Pattern patrón = Pattern.compile("(0)[0-9]{9}");
        Matcher expresión = patrón.matcher(númeroDeTeléfono);
        return expresión.matches();
    }

    @Override
    public String toString() {
        return String.format(ToStringTemplate, this.getNúmeroDeTeléfono());
    }
}
