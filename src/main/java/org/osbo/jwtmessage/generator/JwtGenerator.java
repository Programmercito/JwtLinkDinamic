package org.osbo.jwtmessage.generator;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author programmercito
 */
public class JwtGenerator {

    static String privada = null;

    public static String getPrivate(String ruta) {
        if (privada == null) {
            try {
                String privateKey = new String(Files.readAllBytes(Paths.get(ruta)));
                privada = privateKey;
                return privateKey;
            } catch (IOException ex) {
                return null;
            }

        } else {
            return privada;
        }
    }

    public static String getDefault() {
        return "/opt/osbo/private.pem";
    }

    public static String signer(String json) {
        String defaul = getDefault();
        return signer(defaul, json);
    }

    public static String signer(String rutaprivate, String json) {
        try {
            String temp = JwtGenerator.getPrivate(rutaprivate);
            RSAKey rsaJWK = (RSAKey) JWK.parseFromPEMEncodedObjects(temp);
            JWSSigner signer = new RSASSASigner(rsaJWK);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 2);
            Date expirationDate = calendar.getTime();
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .expirationTime(expirationDate)
                    .claim("v", json)
                    .build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), claimsSet);
            signedJWT.sign(signer);
            return signedJWT.serialize();
        } catch (JOSEException ex) {
            throw new RuntimeException("error al firmar jwt");
        }
    }
}
