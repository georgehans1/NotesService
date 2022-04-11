package com.example.notesservice.repository;

import com.example.notesservice.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface NotesRepository extends MongoRepository<Note,String> {
  ArrayList<Note> findNotesByUserID(String userID);
}
