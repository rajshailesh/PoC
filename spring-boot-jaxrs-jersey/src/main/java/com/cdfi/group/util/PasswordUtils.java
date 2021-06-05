package com.cdfi.group.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class PasswordUtils {

    // ======================================
    // =          Business methods          =
    // ======================================

    public static String digestPassword(String plainTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainTextPassword.getBytes("UTF-8"));
            byte[] passwordDigest = md.digest();
            return new String(Base64.getEncoder().encode(passwordDigest));
            // Considering the password is already Base64 encoded
            //return new String(passwordDigest);
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }

    public static String encodeBase64(String plainTextPassword) {
        try {
             return Base64.getEncoder().encodeToString(plainTextPassword.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }
}
