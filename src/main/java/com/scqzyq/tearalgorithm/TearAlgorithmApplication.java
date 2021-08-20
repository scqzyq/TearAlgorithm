package com.scqzyq.tearalgorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TearAlgorithmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TearAlgorithmApplication.class, args);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
    }

}
