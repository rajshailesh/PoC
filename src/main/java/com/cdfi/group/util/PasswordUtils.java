package com.cdfi.group.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordUtils {

    // ======================================
    // =          Business methods          =
    // ======================================

    public static String digestPassword(String plainTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainTextPassword.getBytes(StandardCharsets.UTF_8));
            byte[] passwordDigest = md.digest();
            //return new String(Base64.getEncoder().encode(passwordDigest));
            return new String(passwordDigest);
          } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }

}
