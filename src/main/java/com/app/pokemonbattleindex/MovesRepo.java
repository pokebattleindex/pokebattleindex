package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MovesRepo extends MongoRepository <PokeMove,String>{
	public List<PokeMove> findAll();

	@Query("{name : ?0}")                                       
        List<PokeMove> getPokeId(String id);
	
}