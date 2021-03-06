package com.eric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author shuli
 */
@SpringBootApplication
@EnableScheduling
public class Day16CronJobApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(Day16CronJobApplication.class, args);
    }

}
