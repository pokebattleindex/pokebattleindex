package com.app.pokemonbattleindex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PokemonController {

	@Autowired
	public MongoRepo repo;

	@GetMapping("/")
	public String homepage(Model model){
		return "homepage";
	}

	@GetMapping("/index")
	public String index(Model model){
		return "index";
	}

	@GetMapping("/viewpokemon")
	public String viewSongs(Model model) {
		List<Pokemon> pokemons = repo.findAll();
		model.addAttribute("allpokemon",pokemons);
		return "viewpokemon";
	}
}
