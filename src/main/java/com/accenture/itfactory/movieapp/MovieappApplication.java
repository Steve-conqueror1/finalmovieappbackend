package com.accenture.itfactory.movieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.accenture.itfactory.movieapp")
@ServletComponentScan(basePackages = "com.accenture.itfactory.movieapp")
@RestController
public class MovieappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);
	}

	@RequestMapping("/")
	public  String home(){
	    return "Welcome to our movieapp";
    }
}
