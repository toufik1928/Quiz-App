package com.quizApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String name;

    public void setId(long l) {
        this.id=l;
    }

    public void setName(String testUser) {

        this.name=testUser;
    }
}
