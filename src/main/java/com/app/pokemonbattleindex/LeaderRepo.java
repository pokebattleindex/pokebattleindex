package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeaderRepo extends MongoRepository <Leader,String>{
	public List<Leader> findAll();

	
}