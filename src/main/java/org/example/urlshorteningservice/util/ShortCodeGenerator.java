package org.example.urlshorteningservice.util;

import java.util.Random;

public class ShortCodeGenerator {

    private static final String CHARSET =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateCode(){

        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for(int i=0;i<6;i++){
            code.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }

        return code.toString();
    }
}