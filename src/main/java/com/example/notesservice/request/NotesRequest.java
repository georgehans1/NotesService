package com.example.notesservice.request;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.PrePersist;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class NotesRequest {
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

}
