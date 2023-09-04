package com.kazopidis.app;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {
    private int x;

    public static Logger logger = Logger.getLogger(Data.class.getName());
    static {
        logger.setLevel(Level.INFO);
        logger.addHandler(new ConsoleHandler());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        logger.log(Level.INFO, "Data accessed");
        return "Data{" +
                "x=" + x +
                '}';
    }
}
