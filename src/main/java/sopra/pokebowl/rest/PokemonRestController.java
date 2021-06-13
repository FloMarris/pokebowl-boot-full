package sopra.pokebowl.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.model.Views;
import sopra.pokebowl.repository.IPokemonRepository;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin("*")
public class PokemonRestController {

	@Autowired
	private IPokemonRepository pokemonRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewPokemon.class)
	public List<Pokemon> findAll() {
		return pokemonRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewPokemon.class)
	public Pokemon find(@PathVariable Long id) {
		Optional<Pokemon> optpokemon = pokemonRepo.findById(id);
		
		if(optpokemon.isPresent()) {
			return optpokemon.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	//MARCHE JUSTE POUR 2 TYPES
	//FAIRE POUR 1 TYPE QUI AFFICHE LES MONO ET DOUBLE TYPE
	@GetMapping("/by-types/{type1}/{type2}")
	@JsonView(Views.ViewPokemon.class)
	public List<Pokemon> findAllPokemonsByTypes(@PathVariable TypeEnum type1, @PathVariable TypeEnum type2) {
		return pokemonRepo.findAllPokemonByType(type1, type2);
	}
	
	@GetMapping("/by-types/{type1}")
	@JsonView(Views.ViewPokemon.class)
	public List<Pokemon> findAllPokemonsByType(@PathVariable TypeEnum type1) {
		return pokemonRepo.findAllPokemonByType(type1, null);
	}
	
	@GetMapping("/by-string/{begginingName}")
	@JsonView(Views.ViewPokemon.class)
	public List<Pokemon> findAllPokemonByString(@PathVariable String begginingName) {
		return pokemonRepo.findAllPokemonByString(begginingName);
	}
		
}
