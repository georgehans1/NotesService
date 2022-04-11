package com.example.notesservice.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("notes")
@Data
@Builder
public class Note {
    @Id
    private String id;

    private String userID;
    private String title;
    private String description;

    public Note(String id,String userID,String title, String description) {
        this.id = id;
        this.userID = userID;
        this.title = title;
        this.description = description;
    }
}
