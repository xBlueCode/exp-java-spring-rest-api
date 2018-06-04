package com.univ.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication is equivalent to the set of annotations:
 @Configuration, @EnableAutoConfiguration and @ComponentScan
*/
@SpringBootApplication(scanBasePackages = {"com.univ.cinema"})
public class CinemaApplication {

	public static void main(String[] args) {
	  /*
	  Tasks performed by run() method:
      - Sets the default configuration
      - Starts Spring application context
      - Performs classpath scan
      - Starts Tomcat server
      */
		SpringApplication.run(CinemaApplication.class, args);
	}
}
