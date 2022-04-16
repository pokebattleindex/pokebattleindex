package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MongoRepo extends MongoRepository <Pokemon,String>{
	public List<Pokemon> findAll();

	@Query("{singer : ?0}")                                       
        List<Pokemon> getSongbySinger(String author);
	
}
