package com.kazopidis.app.utils;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class Resources {
    public static File getFile(String resourceName) {
        resourceName = resourceName.replace("\\", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        var thisClass = Resources.class.getName();
        var thisURL = Resources.class.getResource("Resources.class");
        var protocol = thisURL.getProtocol();

        File file = null;
        if(Objects.equals(protocol, "jar")){

            System.out.println("In JAR");
            URL url = classLoader.getResource(resourceName);
            System.out.println(url);
            //file = new File(url.toExternalForm());

            try {
                JarURLConnection connection = (JarURLConnection) url.openConnection();
                file = new File(connection.getJarFileURL().toURI());
                return file;
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else if(Objects.equals(protocol, "file")) {
            System.out.println("In IDE");
            URL url = classLoader.getResource(resourceName);
            file = new File(url.getFile());
        }
        return file;
    }
}
