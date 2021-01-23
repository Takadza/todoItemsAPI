package com.greencoder.TodoItemAPI.domain;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class TodoItem {

    private int id;
    private String task;
    private LocalDateTime Posted;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    private Boolean isDone;


    @CreationTimestamp
   // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")

    public LocalDateTime getPosted() {
        return Posted;
    }

    public void setPosted(LocalDateTime posted) {
        Posted = posted;
    }
}
