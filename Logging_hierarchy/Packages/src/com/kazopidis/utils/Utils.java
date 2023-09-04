package com.kazopidis.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    public static Logger logger = Logger.getLogger(Utils.class.getName());
    static {
        logger.setLevel(Level.INFO);
        logger.addHandler(new ConsoleHandler());
    }

    public static void f() {
        logger.log(Level.INFO, "in Utils.f()");
    }
}
