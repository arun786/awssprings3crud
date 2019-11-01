package com.arun.springs3read;

import com.arun.springs3read.config.ReadS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springs3readApplication  implements CommandLineRunner {

    @Autowired
    private ReadS3 readS3;

    public static void main(String[] args) {
        SpringApplication.run(Springs3readApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        readS3.lists3Bucket();
    }
}
