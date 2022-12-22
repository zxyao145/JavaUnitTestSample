package com.xxx.unittest.junit4demo.mockadapter;


public class SystemWrapper {

    public static String getProperty(final String name) {
        return System.getProperty(name);
    }

    public static String getenv(final String name) {
        return System.getProperty(name);
    }


    public static Long getCurrentTimeInMillis() {
        return System.currentTimeMillis();
    }
}
