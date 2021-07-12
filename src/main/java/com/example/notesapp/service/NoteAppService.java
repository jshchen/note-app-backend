package com.example.notesapp.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.notesapp.model.NoteAppModel;
import com.example.notesapp.repository.NoteAppRepository;

@Service
@Transactional
@ComponentScan(basePackages = { "com.example.repository" })
public class NoteAppService {

	private final NoteAppRepository noteAppRepository;

	public NoteAppService(NoteAppRepository noteAppRepository) {
		this.noteAppRepository = noteAppRepository;

	}

	public NoteAppModel register(String title, String text, Date date, Time time) {
		return this.noteAppRepository.save(new NoteAppModel(title, text, date, time));
	}

	@Transactional(readOnly = true)
	public List<NoteAppModel> findAll() {
		return this.noteAppRepository.findAll();
	}

	public Optional<NoteAppModel> findOne(long id) {
		return this.noteAppRepository.findById(id);
	}

	public List<NoteAppModel> deleteById(long id) {
		this.noteAppRepository.deleteById(id);
		return this.findAll();
	}

	public List<NoteAppModel> updateTitle(long id, Date date, Time time, String title) {
		this.noteAppRepository.updateTitle(id, date, time, title);
		return this.findAll();
	}

	public List<NoteAppModel> updateText(long id, Date date, Time time, String text) {
		this.noteAppRepository.updateTitle(id, date, time, text);
		return this.findAll();
	}
	
	public List<NoteAppModel> updateNote(long id, Date date, Time time, String text, String title) {
		this.noteAppRepository.updateNote(id, date, time, text, title);
		return this.findAll();
	}

}
