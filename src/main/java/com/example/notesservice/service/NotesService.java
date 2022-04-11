package com.example.notesservice.service;

import com.example.notesservice.models.Note;
import com.example.notesservice.repository.NotesRepository;
import com.example.notesservice.request.NotesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public HttpStatus createNote(NotesRequest note){
       notesRepository.save(
                 Note.builder()
                         .userID(note.getUserID())
                         .title(note.getTitle())
                         .description(note.getDescription())
                .build());
        return HttpStatus.CREATED;
    }

    public List<Note> getNotesByID(String userID){
        return notesRepository.findNotesByUserID(userID);
    }

}
