package com.cdfi.group.util;

import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
@Component
public class SimpleKeyGenerator implements KeyGenerator{
    @Override
    public Key generateKey() {
        String keyString = "simplekey"; // This is hardcoded now but can be fetched from DB or other sources
        // RSA API can be used generate secret key
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        return key;
    }
}
