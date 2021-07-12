package com.example.notesapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.example.notesapp.model.NoteAppModel;
import com.example.notesapp.service.NoteAppService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class NoteAppController {
	private final NoteAppService noteAppService;

	public NoteAppController(NoteAppService noteAppService) {
		this.noteAppService = noteAppService;
	}
	
	@CrossOrigin
	@RequestMapping("/")
	public String getAllNotes() {
		System.out.println("------------------------------------------");
		System.out.println(noteAppService.findAll());
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
//		String JSONObject = gson.toJson(noteAppService.findAll());
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(noteAppService.findAll());
		System.out.println("------------------------------------------");
		System.out.println(prettyJson);
		return prettyJson;
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "/create")
	public String createNote(
			@RequestParam(name = "daytime") long daytime,
			@RequestParam(name = "title") String title, 
			@RequestParam(name = "text") String text) {
		java.sql.Date date = new java.sql.Date(daytime);
		java.sql.Time time = new java.sql.Time(daytime);
		noteAppService.register(title, text, date, time);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
//		String JSONObject = gson.toJson(noteAppService.findAll());
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(noteAppService.findAll());
		System.out.println("------------------------------------------");
		System.out.println(prettyJson);
		return prettyJson;
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, path = "/delete")
	public String deleteNote(
			@RequestParam(name = "id") long id
			) {
		noteAppService.deleteById(id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(noteAppService.findAll());
		System.out.println("------------------------------------------");
		System.out.println(prettyJson);
		return prettyJson;
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "/updateNote")
	public String updateNote(
			@RequestParam(name = "id") long id,
			@RequestParam(name = "daytime") long daytime,
			@RequestParam(name = "text") String text,
			@RequestParam(name = "title") String title
			) {
		java.sql.Date date = new java.sql.Date(daytime);
		java.sql.Time time = new java.sql.Time(daytime);
		noteAppService.updateNote(id, date, time, text, title);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(noteAppService.findAll());
		System.out.println("------------------------------------------");
		System.out.println(prettyJson);
		return prettyJson;
	}
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "/updateTitle")
	public String updateTitle(
			@RequestParam(name = "id") long id,
			@RequestParam(name = "daytime") long daytime,
			@RequestParam(name = "title") String title
			) {
		java.sql.Date date = new java.sql.Date(daytime);
		java.sql.Time time = new java.sql.Time(daytime);
		noteAppService.updateTitle(id, date, time, title);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(noteAppService.findAll());
		System.out.println("------------------------------------------");
		System.out.println(prettyJson);
		return prettyJson;
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "/updateText")
	public String updateText(
			@RequestParam(name = "id") long id,
			@RequestParam(name = "daytime") long daytime,
			@RequestParam(name = "text") String text
			) {
		java.sql.Date date = new java.sql.Date(daytime);
		java.sql.Time time = new java.sql.Time(daytime);
		noteAppService.updateTitle(id, date, time, text);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(noteAppService.findAll());
		System.out.println("------------------------------------------");
		System.out.println(prettyJson);
		return prettyJson;
	}
	
	


}
