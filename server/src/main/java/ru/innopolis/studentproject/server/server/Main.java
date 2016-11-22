package ru.innopolis.studentproject.server.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by innopolis on 17.11.16.
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(RootConfig.class);
        ctx.refresh();
    }


}
