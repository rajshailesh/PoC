package com.cdfi.group.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFileTask implements Runnable {

    private InputStream srcFile;
    private final Path toPath;

    public CopyFileTask(InputStream srcFile, Path toPath) {
        this.srcFile = srcFile;
        this.toPath = toPath;
    }

    @Override
    public void run() {
        try {

            Files.copy(srcFile, toPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}