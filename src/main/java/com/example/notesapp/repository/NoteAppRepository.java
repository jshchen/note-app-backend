package com.example.notesapp.repository;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.notesapp.model.NoteAppModel;


public interface NoteAppRepository extends JpaRepository<NoteAppModel, Long>{

	@Modifying
	@Query("UPDATE NoteAppModel set title = ?4, date = ?2, time = ?3 where id = ?1")
	void updateTitle(long id, Date date, Time time, String title);

	
	@Modifying
	@Query("UPDATE NoteAppModel set text = ?4, date = ?2, time = ?3, time = ?2 where id = ?1")
	void updateText(long id, Date date, Time time, String title);
	
	@Modifying
	@Query("UPDATE NoteAppModel set title = ?5, text = ?4, date = ?2, time = ?3 where id = ?1")
	void updateNote(long id, Date date, Time time, String text, String title);
	

}
