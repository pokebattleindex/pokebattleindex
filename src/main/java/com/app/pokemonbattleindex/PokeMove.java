package com.app.pokemonbattleindex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("poke_moves")
public class PokeMove{
    private int pid;
    private String name;
    private int hp;
    private String poke_move1_name;
    private int poke_move1_damage;
    private int poke_move1_acc;
    private String poke_move2_name;
    private int poke_move2_damage;
    private int poke_move2_acc;
    private String poke_move3_name;
    private int poke_move3_damage;
    private int poke_move3_acc;
    private String poke_move4_name;
    private int poke_move4_damage;
    private int poke_move4_acc;
    private String img;
    
    public int getId() {
        return pid;
    }
    public void setId(int id) {
        this.pid = id;
    }
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public String getPoke_move1_name() {
        return poke_move1_name;
    }
    public void setPoke_move1_name(String poke_move1_name) {
        this.poke_move1_name = poke_move1_name;
    }
    public int getPoke_move1_damage() {
        return poke_move1_damage;
    }
    public void setPoke_move1_damage(int poke_move1_damage) {
        this.poke_move1_damage = poke_move1_damage;
    }
    public int getPoke_move1_acc() {
        return poke_move1_acc;
    }
    public void setPoke_move1_acc(int poke_move1_acc) {
        this.poke_move1_acc = poke_move1_acc;
    }
    public String getPoke_move2_name() {
        return poke_move2_name;
    }
    public void setPoke_move2_name(String poke_move2_name) {
        this.poke_move2_name = poke_move2_name;
    }
    public int getPoke_move2_damage() {
        return poke_move2_damage;
    }
    public void setPoke_move2_damage(int poke_move2_damage) {
        this.poke_move2_damage = poke_move2_damage;
    }
    public int getPoke_move2_acc() {
        return poke_move2_acc;
    }
    public void setPoke_move2_acc(int poke_move2_acc) {
        this.poke_move2_acc = poke_move2_acc;
    }
    public String getPoke_move3_name() {
        return poke_move3_name;
    }
    public void setPoke_move3_name(String poke_move3_name) {
        this.poke_move3_name = poke_move3_name;
    }
    public int getPoke_move3_damage() {
        return poke_move3_damage;
    }
    public void setPoke_move3_damage(int poke_move3_damage) {
        this.poke_move3_damage = poke_move3_damage;
    }
    public int getPoke_move3_acc() {
        return poke_move3_acc;
    }
    public void setPoke_move3_acc(int poke_move3_acc) {
        this.poke_move3_acc = poke_move3_acc;
    }
    public String getPoke_move4_name() {
        return poke_move4_name;
    }
    public void setPoke_move4_name(String poke_move4_name) {
        this.poke_move4_name = poke_move4_name;
    }
    public int getPoke_move4_damage() {
        return poke_move4_damage;
    }
    public void setPoke_move4_damage(int poke_move4_damage) {
        this.poke_move4_damage = poke_move4_damage;
    }
    public int getPoke_move4_acc() {
        return poke_move4_acc;
    }
    public void setPoke_move4_acc(int poke_move4_acc) {
        this.poke_move4_acc = poke_move4_acc;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}