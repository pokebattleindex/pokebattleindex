package com.app.pokemonbattleindex;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("pokemon")
public class Pokemon {

	private String id;
	private String name;
	private ArrayList<String> type;
	private String num;
	private String img;
	private String height;
	private String weight;
	private String candy;
	private String candy_count;
	private String egg;
	private String spawn_chance;
	private String avg_spawns;
	private String spawn_time;
	private ArrayList<String> multipliers;
	private ArrayList<String> weaknesses;
	private ArrayList<Pokemon> next_evolution;

	//Create Getters and Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getType() {
		return type;
	}
	public void setType(ArrayList<String> type) {
		this.type = type;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getCandy() {
		return candy;
	}
	public void setCandy(String candy) {
		this.candy = candy;
	}

	public String getCandy_count() {
		return candy_count;
	}
	public void setCandy_count(String candy_count) {
		this.candy_count = candy_count;
	}

	public String getEgg() {
		return egg;
	}
	public void setEgg(String egg) {
		this.egg = egg;
	}

	public String getSpawn_chance() {
		return spawn_chance;
	}
	public void setSpawn_chance(String spawn_chance) {
		this.spawn_chance = spawn_chance;
	}

	public String getAvg_spawns() {
		return avg_spawns;
	}
	public void setAvg_spawns(String avg_spawns) {
		this.avg_spawns = avg_spawns;
	}

	public String getSpawn_time() {
		return spawn_time;
	}
	public void setSpawn_time(String spawn_time) {
		this.spawn_time = spawn_time;
	}

	public ArrayList<String> getMultipliers() {
		return multipliers;
	}
	public void setMultipliers(ArrayList<String> multipliers) {
		this.multipliers = multipliers;
	}

	public ArrayList<String> getWeaknesses() {
		return weaknesses;
	}
	public void setWeaknesses(ArrayList<String> weaknesses) {
		this.weaknesses = weaknesses;
	}

	public ArrayList<Pokemon> getNext_evolution() {
		return next_evolution;
	}
	public void setNext_evolution(ArrayList<Pokemon> next_evolution) {
		this.next_evolution = next_evolution;
	}
}
