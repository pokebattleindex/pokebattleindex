package com.app.pokemonbattleindex;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")

public class User {
    private String id;
    private String username;
    private String password;
    
    //Create Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
