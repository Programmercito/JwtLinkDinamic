package org.osbo.jwtmessage.message;

import com.nimbusds.jose.shaded.gson.Gson;
import org.osbo.jwtmessage.generator.JwtGenerator;
import org.osbo.jwtmessage.link.LinkGenerator;

/**
 *
 * @author programmercito
 */
public class JwtMessage {

    public static String generate(String linkwithout, String mensaje, String rutaprivate) {
        String jwt = JwtGenerator.signer(rutaprivate, mensaje);
        String genlink = LinkGenerator.genlink(linkwithout, jwt);
        return genlink;
    }

    public static String generate(String linkwithout, String mensaje) {
        return generate(linkwithout, mensaje, JwtGenerator.getDefault());
    }

    public static String generate(String linkwithout, Object mensaje, String ruta) {
        Gson gson = new Gson();
        String toJson = gson.toJson(mensaje);
        return generate(linkwithout, toJson, ruta);
    }

    public static String generate(String linkwithout, Object mensaje) {
        return generate(linkwithout, mensaje, JwtGenerator.getDefault());
    }
}
