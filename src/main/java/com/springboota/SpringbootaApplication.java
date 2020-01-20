package com.springboota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Binquan.Cao
 */
@EnableScheduling
@SpringBootApplication
public class SpringbootaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootaApplication.class, args);
    }

}
