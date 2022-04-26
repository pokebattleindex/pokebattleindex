package com.app.pokemonbattleindex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("linky")

public class link 
{
    private String _id;
    private String move_name;
    private String pokemon;

    private String link;

    //Create Getters and Setters
    public String get_id() {
        return _id;
    }
    
    public String getMove_name() {
        return move_name;
    }
    public void setMove_name(String move_name) {
        this.move_name = move_name;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getPokemon() {
        return pokemon;
    }
    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }
}