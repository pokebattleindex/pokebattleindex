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
	@Autowired
	public LeaderRepo leaderRepo;
	@Autowired
	public linkyRepo linkyRepo;

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

	@GetMapping("/choose")
	public String choose(Model model) {
		model.addAttribute("poke", new PokeMove());
		return "choose";
	}

	@PostMapping("/choose")
	public String choose2(@ModelAttribute("poke") PokeMove poke) {
		String poke_name = poke.getName();
		String poke_vs_name = poke.getPoke_vs_name();
		String redirectUrl = "redirect:/fight?poke1="+poke_name+"&poke2="+poke_vs_name+"&move=1";
		return redirectUrl;
	}


	@GetMapping("/fight")
	public String fightPokemon(@RequestParam("poke1") String p1,@RequestParam("poke2") String p2,@RequestParam("move") String move, Model model) {
		//p1 = Pikachu
		//p2 = Charmander
		String video_link="";
		System.out.println(move);
		video_link = linkyRepo.getMove(move).get(0).getLink();
		String video_link_h = linkyRepo.getMove(move).get(0).getHeight();
		String video_link_w = linkyRepo.getMove(move).get(0).getWidth();
		
		
		List<PokeMove> pokemove1 = movesRepo.getPokeId(p1);
		List<PokeMove> pokemove2 = movesRepo.getPokeId(p2);

		PokeMove poke1 = pokemove1.get(0);
		PokeMove poke2 = pokemove2.get(0);
		
		System.out.println(video_link);
		poke1.setMove_vid(video_link);
		poke2.setMove_vid("");

		poke1.setMove_vid_w(video_link_w);
		poke1.setMove_vid_h(video_link_h);

		model.addAttribute("p1", poke1);
		model.addAttribute("p2", poke2);
		return "fight_poke1";
	}

	@PostMapping("/fight")
	public String fight2(@ModelAttribute("p1") PokeMove pokemove) {
		String poke_name = pokemove.getName();
		String poke_vs_name = pokemove.getPoke_vs_name();
		String poke_move_name = pokemove.getPoke_move1_name();
		int dam = (int)(pokemove.getPoke_move1_damage()*((Math.random() * pokemove.getPoke_move1_acc()*0.01)) ) ;
		System.out.println(dam);
		List<PokeMove> pokemove1 = movesRepo.getPokeId(poke_vs_name);
		PokeMove p = pokemove1.get(0);

		/* System.out.println(p.getHp()); */
		if((p.getHp() - dam)>0){
			p.setHp(p.getHp() - dam);
		}
		else {
			
			List<PokeMove> pokemove2 = movesRepo.getPokeId(poke_name);
			PokeMove p2 = pokemove2.get(0);

			Leader l = new Leader();
			l.setWinner(poke_name);
			l.setLoser(poke_vs_name);
			l.setWinner_hp(p2.getHp());
			l.setLoser_hp(0);
			l.setWinner_move(pokemove.getPoke_move1_name());
			l.setLoser_move(p.getPoke_move1_name());
			leaderRepo.save(l);
			p.setHp(200);
			p2.setHp(200);
			movesRepo.save(p);
			movesRepo.save(p2);
			String redirectUrl2 = "redirect:/victory?poke1="+poke_name;
			return redirectUrl2;
		}
		/* System.out.println(p.getHp()); */
		movesRepo.save(p);

		/* System.out.println(p.getPoke_move1_name()); */
		String redirectUrl = "redirect:/fight2?poke1="+poke_name+"&poke2="+poke_vs_name+"&move="+poke_move_name;
		return redirectUrl;
	}

	@GetMapping("/fight2")
	public String fightPokemon2(@RequestParam("poke1") String p1,@RequestParam("poke2") String p2,@RequestParam("move") String move,Model model) {
		String video_link;
		video_link = linkyRepo.getMove(move).get(0).getLink();
		String video_link_h = linkyRepo.getMove(move).get(0).getHeight();
		String video_link_w = linkyRepo.getMove(move).get(0).getWidth();

		
		List<PokeMove> pokemove1 = movesRepo.getPokeId(p1);
		List<PokeMove> pokemove2 = movesRepo.getPokeId(p2);

		PokeMove poke1 = pokemove1.get(0);
		PokeMove poke2 = pokemove2.get(0);
		
		poke1.setMove_vid(video_link);
		poke1.setMove_vid_w(video_link_w);
		poke1.setMove_vid_h(video_link_h);


		model.addAttribute("p1", poke1);
		model.addAttribute("p2", poke2);
		return "fight_poke2";
	}

	@PostMapping("/fight2")
	public String fight22(@ModelAttribute("pokemoves") PokeMove pokemove) {
		String poke_name = pokemove.getName();
		String poke_vs_name = pokemove.getPoke_vs_name();
		String poke_move_name = pokemove.getPoke_move1_name();

		int dam =  (int)(pokemove.getPoke_move1_damage()*((Math.random() * pokemove.getPoke_move1_acc()*0.01)) ) ;

		List<PokeMove> pokemove1 = movesRepo.getPokeId(poke_vs_name);
		PokeMove p = pokemove1.get(0);

		/* System.out.println(p.getHp()); */
		if((p.getHp() - dam)>0){
			p.setHp(p.getHp() - dam);
		}
		else {
			
			List<PokeMove> pokemove2 = movesRepo.getPokeId(poke_name);
			PokeMove p1 = pokemove2.get(0);

			Leader l = new Leader();
			l.setWinner(poke_name);
			l.setLoser(poke_vs_name);
			l.setWinner_hp(p1.getHp());
			l.setLoser_hp(0);
			l.setWinner_move(pokemove.getPoke_move1_name());
			l.setLoser_move(p.getPoke_move1_name());
			leaderRepo.save(l);


			p1.setHp(200);
			p.setHp(200);
			movesRepo.save(p);
			movesRepo.save(p1);
			String redirectUrl1 = "redirect:/victory?poke1="+poke_name;
			return redirectUrl1;
		}
		/* System.out.println(p.getHp()); */
		movesRepo.save(p);
		String redirectUrl = "redirect:/fight?poke1="+poke_vs_name+"&poke2="+poke_name+"&move="+poke_move_name;
		return redirectUrl;
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
	public String displayPokemon(@RequestParam("name") String name, Model model) {
		List<User> u1 = userRepo.getUserbyLogin("true");
		if(u1.size() == 0) {
			return "redirect:/login";
		}
		else {
			List<Pokemon> pokemons = pokeRepo.getPokebyName(name);
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

	@GetMapping("/leaderboard")
	public String viewLeaderboard(Model model){
		List<User> u1 = userRepo.getUserbyLogin("true");
		if(u1.size() == 0) {
			return "redirect:/login";
		}
		else {
			List<Leader> leaders = leaderRepo.findAll();
			model.addAttribute("leaders", leaders);
			return "leaderboard";
		}
	}

	@GetMapping("/signout")
	public String signout(){
		List<User> u1 = userRepo.getUserbyLogin("true");
		User u = u1.get(0);
		u.setLoggedIn("false");
		userRepo.save(u);
		return "redirect:/";
	}
	@GetMapping("/victory")
	public String vic(@RequestParam("poke1") String p1,Model model){
		List<Pokemon> u1 = pokeRepo.getPokebyName(p1);
		Pokemon p = u1.get(0);
		model.addAttribute("p1", p);
		return "victory1";
	}
}


