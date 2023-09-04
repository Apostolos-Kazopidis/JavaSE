package com.kazopidis.app.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Resources {
    public static void initData() {
        String fullPath = System.getProperty("user.dir");

        if (Files.notExists(Path.of(fullPath + "\\data"))) {
            try {
                Files.createDirectory(Path.of(fullPath + "\\data"));
            } catch (IOException e) {
                System.err.println("Cannot create directory!");
            }
        }
    }
    public static File getFile(String resourceName) {
        return new File(System.getProperty("user.dir") + "\\" + resourceName);
    }
}
