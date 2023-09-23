package org.osbo.jwtmessage.link;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/**
 *
 * @author programmercito
 */
public class LinkGenerator {

    public static String genlink(String linkWithoutFinished, String jwt) {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("jwt", jwt);
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        String resolvedString = sub.replace(linkWithoutFinished);
        return resolvedString;
    }
}
