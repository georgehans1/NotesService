package com.example.notesservice.controller;

import com.example.notesservice.models.Note;
import com.example.notesservice.request.NotesRequest;
import com.example.notesservice.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping("add")
    public HttpStatus addNote(@RequestBody NotesRequest note){
        notesService.createNote(note);
        return HttpStatus.OK;
    }


    @GetMapping("/get/{userID}")
    public List<Note> getNotesByID(@PathVariable (value = "userID") String userID){
        return notesService.getNotesByID(userID);
    }




}
