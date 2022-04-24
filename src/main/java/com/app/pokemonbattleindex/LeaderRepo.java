package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LeaderRepo extends MongoRepository <Leader,String>{
	public List<Leader> findAll();

	
}