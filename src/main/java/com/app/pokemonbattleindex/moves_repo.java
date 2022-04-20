package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface moves_repo extends MongoRepository <poke_move,String>{
	public List<poke_move> findAll();

	@Query("{id : ?0}")                                       
        List<poke_move> getbattlepokeid(String id);	
}
