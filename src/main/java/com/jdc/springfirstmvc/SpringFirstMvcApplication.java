package com.jdc.springfirstmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class SpringFirstMvcApplication {
    @Autowired
    private ApplicationContext applicationContext;

    private static Logger logger= LoggerFactory.getLogger(SpringFirstMvcApplication.class);

   /* @Autowired
    private Environment environment;*/

    public static void main(String[] args) {
        SpringApplication.run(SpringFirstMvcApplication.class, args);
    }
    @Bean @Profile("dev")
    public CommandLineRunner run(){
        logger.error("Logger Error Message");
        logger.info("Logger Info Message");
        logger.warn("Logger Warn Message");
        logger.debug("Logger Debug Message");
        return args -> {
            Arrays.stream(this.applicationContext.getBeanDefinitionNames()).sorted().forEach(System.out::println);
        };
    }

  /*  public void getActiveProfiles(){
        for (String profiles:environment.getActiveProfiles()
             ) {
            System.out.println("Active Profiles : : : "+profiles);
        }
    }*/

}
