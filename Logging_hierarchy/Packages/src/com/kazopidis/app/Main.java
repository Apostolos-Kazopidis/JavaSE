package com.kazopidis.app;

import com.kazopidis.utils.Utils;

import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static Logger logPackage = Logger.getLogger("com.kazopidis");
    static {
        logger.setLevel(Level.INFO);
        logger.addHandler(new ConsoleHandler());

        try {
            logPackage.addHandler(new FileHandler("all.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        Data data = new Data();
        System.out.println(data);
        Utils.f();
    }
}
