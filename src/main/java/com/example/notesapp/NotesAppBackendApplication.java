package com.example.notesapp;



import java.util.Calendar;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import com.example.notesapp.model.NoteAppModel;
import com.example.notesapp.repository.NoteAppRepository;

@SpringBootApplication
public class NotesAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesAppBackendApplication.class, args);
	}
	
	@Bean
	ApplicationRunner applicationRunner(NoteAppRepository noteAppRepository) {
		java.sql.Date date= new java.sql.Date(System.currentTimeMillis());
		java.sql.Time time= new java.sql.Time(System.currentTimeMillis());
		return args -> {
			noteAppRepository.save(new NoteAppModel("New Note Title 1", "New Note 1", date, time));
		};
	}

}
