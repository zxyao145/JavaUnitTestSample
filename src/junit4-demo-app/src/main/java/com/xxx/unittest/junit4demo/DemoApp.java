package com.xxx.unittest.junit4demo;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(DemoApp.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
