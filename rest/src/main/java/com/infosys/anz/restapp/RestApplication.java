package com.infosys.anz.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * A SpringBoot application allows a user to view accounts and subsequently view transactions on any of the accounts they hold.
 * 
 * @author Tim Coy tim.coy@me.com
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.infosys.anz.restapp.dao")
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
