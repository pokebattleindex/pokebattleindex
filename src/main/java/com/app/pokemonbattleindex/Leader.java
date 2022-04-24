package com.app.pokemonbattleindex;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("leaderboard")
public class Leader {

	private String winner;
    private String loser;
    private int winner_hp;
    private int loser_hp;
    private String winner_move;
    private String loser_move;

    // Create Getters and Setters
    public String getWinner() {
        return winner;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }
    public void setLoser(String loser) {
        this.loser = loser;
    }

    public int getWinner_hp() {
        return winner_hp;
    }
    public void setWinner_hp(int winner_hp) {
        this.winner_hp = winner_hp;
    }

    public int getLoser_hp() {
        return loser_hp;
    }
    public void setLoser_hp(int loser_hp) {
        this.loser_hp = loser_hp;
    }

    public String getWinner_move() {
        return winner_move;
    }
    public void setWinner_move(String winner_move) {
        this.winner_move = winner_move;
    }

    public String getLoser_move() {
        return loser_move;
    }
    public void setLoser_move(String loser_move) {
        this.loser_move = loser_move;
    }
    


}
