package com.app.pokemonbattleindex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")

public class User {
    private String _id;
    private String username;
    private String password;
    private String trainername;
    private String loggedIn;
    
    //Create Getters and Setters
    public String get_id() {
        return _id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getTrainername() {
        return trainername;
    }
    public void setTrainername(String trainername) {
        this.trainername = trainername;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(String loggedIn) {
        this.loggedIn = loggedIn;
    }

}
