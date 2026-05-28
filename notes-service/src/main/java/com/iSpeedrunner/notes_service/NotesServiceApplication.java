package com.iSpeedrunner.notes_service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotesServiceApplication {

	public static void main(String[] args) {
		Dotenv env = Dotenv.configure().directory("../").filename(".env").ignoreIfMalformed().ignoreIfMissing().load();

		env.entries().forEach(entry ->
			System.setProperty(entry.getKey(), entry.getValue())
		);

		SpringApplication.run(NotesServiceApplication.class, args);
	}

}
