package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PokeRepo extends MongoRepository <Pokemon,String>{
	public List<Pokemon> findAll();

	@Query("{id : ?0}")                                       
        List<Pokemon> getPokeId(String user);

	@Query("{name : ?0}")                                       
        List<Pokemon> getPokebyName(String user);
	
}
