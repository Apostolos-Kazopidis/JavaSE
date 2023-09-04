package com.psounis.utils;

import java.io.IOException;
import java.io.InputStream;

public class Resources {
    public static byte[] getFileBytesFromJAR(String resourceName) {
        resourceName = resourceName.replace("\\", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        byte[] bytes = null;
        try (InputStream stream = classLoader.getResourceAsStream(resourceName)) {
            bytes = stream.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }
    public static InputStream getInputStream(String resourceName) {
        resourceName = resourceName.replace("\\", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        return classLoader.getResourceAsStream(resourceName);
    }
}
