package com.example.notesservice.models;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.PrePersist;
import java.sql.Timestamp;
import java.util.Date;

@Document("notes")
@Data
@Builder
@Slf4j

//@AllArgsConstructor
public class Note {
    @Id
    private String id;

    private String userID;
    private String title;
    private String description;

    @CreatedDate
    private Date creationDate;

    @PrePersist
    private Date setDate(){
        Date newDate = new Date();
        Timestamp timestamp = new Timestamp(newDate.getTime());
        this.creationDate = timestamp;
        return this.creationDate;
    }

    public Note(String id, String userID, String title, String description, Date creationDate) {
        this.id = id;
        this.userID = userID;
        this.title = title;
        this.description = description;
        this.creationDate = setDate();
    }
}
