package com.pet.supplies.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.pet.supplies.repository")
@ComponentScan("com.pet.supplies")
@EntityScan("com.pet.supplies.domain")
public class Application extends SpringBootServletInitializer
{

   public static void main(String[] args)
   {
      SpringApplication.run(Application.class, args);
   }

   @Override
   protected final SpringApplicationBuilder configure(SpringApplicationBuilder application)
   {
      return application.sources(Application.class);
   }
}