package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepo extends MongoRepository <User,String>{
	public List<User> findAll();

	@Query("{username : ?0}")                                       
        List<User> getUser(String user);
	
}
