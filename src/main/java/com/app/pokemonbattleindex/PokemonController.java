package com.app.pokemonbattleindex;
import java.lang.Math;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String register2(@ModelAttribute("user") User user) {
		user.setLoggedIn("false");
		userRepo.save(user);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginuser", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login2(@ModelAttribute("loginuser") User user) {
		List<User> loginUser =  userRepo.getUser(user.getUsername());
		if(loginUser.size() == 0) {
			return "redirect:/register";
		}
		else {
			if(loginUser.get(0).getPassword().equals(user.getPassword())) {
				loginUser.get(0).setLoggedIn("true");
				userRepo.save(loginUser.get(0));
				return "redirect:/";
			}
			else {
				return "redirect:/login";
			}
		}
	}

	@GetMapping("/fight")
	public String fightPokemon(Model model) {
		List<PokeMove> pokemove1 = movesRepo.getPokeId("Pikachu");
		model.addAttribute("p1", pokemove1.get(0));
		List<PokeMove> pokemove2 = movesRepo.getPokeId("Charmander");
		model.addAttribute("p2", pokemove2.get(0));
		return "fight_poke1";
	}

	@PostMapping("/fight")
	public String fight2(@ModelAttribute("p1") PokeMove pokemove) {
		/* System.out.println(pokemove.getName());
		System.out.println(pokemove.getPoke_move1_name());
		System.out.println(pokemove.getPoke_move1_damage()); */
 
		int dam = pokemove.getPoke_move1_damage() - ((int)(Math.random() * pokemove.getPoke_move1_acc())) ;
		System.out.println(dam);
		List<PokeMove> pokemove1 = movesRepo.getPokeId("Charmander");
		PokeMove p = pokemove1.get(0);

		/* System.out.println(p.getHp()); */
		if((p.getHp() - dam)>0){
			p.setHp(p.getHp() - dam);
		}
		else {
			p.setHp(200);
			movesRepo.save(p);
			List<PokeMove> pokemove2 = movesRepo.getPokeId("Pikachu");
			PokeMove p2 = pokemove2.get(0);
			p2.setHp(200);
			movesRepo.save(p2);
			return "victory2";
		}
		/* System.out.println(p.getHp()); */
		movesRepo.save(p);

		/* System.out.println(p.getPoke_move1_name()); */
		return "redirect:/fight2";
	}

	@GetMapping("/fight2")
	public String fightPokemon2(Model model) {
		List<PokeMove> pokemove1 = movesRepo.getPokeId("Pikachu");
		model.addAttribute("p1", pokemove1.get(0));
		List<PokeMove> pokemove2 = movesRepo.getPokeId("Charmander");
		model.addAttribute("p2", pokemove2.get(0));
		return "fight_poke2";
	}

	@PostMapping("/fight2")
	public String fight22(@ModelAttribute("pokemoves") PokeMove pokemove) {
		/* System.out.println(pokemove.getName());
		System.out.println(pokemove.getPoke_move1_name());
		System.out.println(pokemove.getPoke_move1_damage()); */

		int dam = pokemove.getPoke_move1_damage() - ((int)(Math.random() * pokemove.getPoke_move1_acc())) ;

		List<PokeMove> pokemove1 = movesRepo.getPokeId("Pikachu");
		PokeMove p = pokemove1.get(0);

		/* System.out.println(p.getHp()); */
		if((p.getHp() - dam)>0){
			p.setHp(p.getHp() - dam);
		}
		else {
			p.setHp(200);
			movesRepo.save(p);
			List<PokeMove> pokemove2 = movesRepo.getPokeId("Charmander");
			PokeMove p1 = pokemove2.get(0);
			p1.setHp(200);
			movesRepo.save(p1);
			return "victory1";
		}
		/* System.out.println(p.getHp()); */
		movesRepo.save(p);
		/* System.out.println(p.getPoke_move1_name()); */
		return "redirect:/fight";
	}

	@GetMapping("/")
	public String index(Model model){
		List<User> u1 = userRepo.getUserbyLogin("true");
		if(u1.size() == 0) {
			return "redirect:/login";
		}
		else {
			model.addAttribute("user", u1.get(0));
			return "index";
		}
		
	}

	

	@GetMapping("/viewpokemon")
	public String viewPokemon(Model model) {
		List<User> u1 = userRepo.getUserbyLogin("true");
		if(u1.size() == 0) {
			return "redirect:/login";
		}
		else {
			List<Pokemon> pokemons = pokeRepo.findAll();
			model.addAttribute("allpokemon",pokemons);
			return "viewpokemon";
		}
		
	}

	@GetMapping("/pokemon")
	public String displayPokemon(Model model) {
		List<User> u1 = userRepo.getUserbyLogin("true");
		if(u1.size() == 0) {
			return "redirect:/login";
		}
		else {
			List<Pokemon> pokemons = pokeRepo.getPokebyName("Pikachu");
			model.addAttribute("pokemon",pokemons.get(0));
			System.out.println(pokemons.get(0).getName());
			return "pokemon";
		}
	}

	@GetMapping("/settings")
	public String viewSettings(Model model){
		List<User> u1 = userRepo.getUserbyLogin("true");
		model.addAttribute("user", u1.get(0));
		return "settings";
	}


	@PostMapping("/settings")
	public String settings(@ModelAttribute("user") User user) {	
		List<User> u1 = userRepo.getUserbyLogin("true");
		User u = u1.get(0);
		System.out.println(user.getTrainername());
		u.setUsername(user.getUsername());
		u.setTrainername(user.getTrainername());
		u.setPassword(user.getPassword());
		u.setLoggedIn("false");
		userRepo.save(u);

		return "redirect:/login";
	}

	@GetMapping("/signout")
	public String signout(){
		List<User> u1 = userRepo.getUserbyLogin("true");
		User u = u1.get(0);
		u.setLoggedIn("false");
		userRepo.save(u);
		return "redirect:/";
	}
}