package com.xeland314.correos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProtonMail extends CorreoElectrónico {

    public static final String ToStringTemplate = "ProtonMail{correo='%1s'}";

    public ProtonMail(String correo) {
        super(correo);
    }

    @Override
    protected boolean esUnCorreoVálido(String correo) {
        Pattern patrón = Pattern.compile("^[a-z0-9]+([.+-_]{0,1}[a-z0-9])*@protonmail.com$");
        Matcher expresión = patrón.matcher(correo);
        return expresión.matches();
    }
    
    @Override
    public String toString(){
        return String.format(ToStringTemplate, this.getCorreoElectrónico());
    }

}
