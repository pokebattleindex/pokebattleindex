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
	public PokeRepo pokeRepo;
	@Autowired
	public UserRepo userRepo;
	@Autowired
	public MovesRepo movesRepo;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register2(@ModelAttribute("loggeduser") User user) {
		userRepo.save(user);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginuser", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login2(@ModelAttribute("user") User user) {
		List<User> loginUser =  userRepo.getUser(user.getUsername());
		if(loginUser.size() == 0) {
			return "redirect:/";
		}
		else {
			return "redirect:/viewpokemon";
		}
	}

	@GetMapping("/fight")
	public String fightPokemon(Model model) {
		List<PokeMove> pokemoves = movesRepo.findAll();
		model.addAttribute("pokemoves", pokemoves);
		return "fight";
	}

	@PostMapping("/fight")
	public String fight2(@ModelAttribute("user1pokemon") Pokemon user1pokemon, @ModelAttribute("user2pokemon") Pokemon user2pokemon) {
		List<Pokemon> user1Pokemon = pokeRepo.getPokeId(user1pokemon.getId());
		List<Pokemon> user2Pokemon = pokeRepo.getPokeId(user2pokemon.getId());
		if(user1Pokemon.size() == 0 || user2Pokemon.size() == 0) {
			return "redirect:/";
		}
		else {
			return "redirect:/fight";
		}
	}

	@GetMapping("/")
	public String index(Model model){
		// Add Login Functionality
		model.addAttribute("user", new User());
		return "index";
	}

	

	@GetMapping("/viewpokemon")
	public String viewPokemon(Model model) {
		List<Pokemon> pokemons = pokeRepo.findAll();
		model.addAttribute("allpokemon",pokemons);
		return "viewpokemon";
	}


}
