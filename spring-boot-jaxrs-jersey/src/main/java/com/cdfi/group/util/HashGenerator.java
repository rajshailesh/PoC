package com.cdfi.group.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.util.EncodingUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.Base64Utils;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Component
public class HashGenerator {
    private final Environment environment;

    @Autowired
    public HashGenerator(Environment environment) {
        this.environment = environment;
    }

    @Nonnull
    public byte[] hash(@Nonnull String password, @Nonnull byte[] salt, @Nonnegative int iterationCount, @Nonnegative int length) {
        Assert.notNull(password, "Password must be given!");
        Assert.notNull(salt, "Salt must be given!");
        Assert.isTrue(iterationCount > 0, "Iteration count must be greater than zero!");
        Assert.isTrue(length > 0, "Length must be greater than zero!");

        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, length);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] encodedHash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
            return encodedHash;
        } catch (InvalidKeySpecException | NoSuchAlgorithmException var8) {
            throw new IllegalStateException(var8);
        }
    }

    public boolean isEqual(@Nonnull byte[] knownHash, @Nonnull byte[] password, @Nonnull byte[] secret, @Nonnull byte[] salt, @Nonnegative int iterationCount, @Nonnegative int length) {
        Assert.notNull(knownHash, "Known hash must be given!");
        Assert.notNull(password, "Password must be given!");
        Assert.notNull(salt, "Salt must be given!");
        Assert.isTrue(iterationCount > 0, "Iteration count must be greater than zero!");
        Assert.isTrue(length > 0, "Length must be greater than zero!");
        byte[] internalSalt = EncodingUtils.concatenate(new byte[][]{salt, secret});
        byte[] computedHash = this.hash(Base64Utils.encodeToString(password), internalSalt, iterationCount, length);
        return MessageDigest.isEqual(knownHash, computedHash);
    }
}
