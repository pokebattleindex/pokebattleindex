package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface linkyRepo extends MongoRepository <link,String>{
	public List<link> findAll();

	@Query("{name : ?0}")                                       
        List<link> getmove(String move_name);
	
}