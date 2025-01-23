package com.airbusiness.airbusinessmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.airbusiness.airbusinessmvc.entities.Client;

@SpringBootApplication
public class AirbusinessMvcApplication {
 private static Client client= new Client();
	public static void main(String[] args) {
		SpringApplication.run(AirbusinessMvcApplication.class, args);		
	}

}
