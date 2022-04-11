package com.example.notesservice.request;
import lombok.Data;

@Data
public class NotesRequest {
    String userID;
    private String title;
    private String description;

}
