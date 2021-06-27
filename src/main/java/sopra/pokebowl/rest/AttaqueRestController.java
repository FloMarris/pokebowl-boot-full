package sopra.pokebowl.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Views;
import sopra.pokebowl.repository.IAttaqueRepository;

@RestController
@RequestMapping("/attaque")
@CrossOrigin("*")
public class AttaqueRestController {
	
	@Autowired
	private IAttaqueRepository attaqueRepo;

	@GetMapping("")
	@JsonView(Views.ViewAttaque.class)
	public List<Attaque> findAll() {
		return attaqueRepo.findAll(); 
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAttaque.class)
	public Attaque find(@PathVariable Long id) {

		Optional<Attaque> optAttaque = attaqueRepo.findById(id);

		if (optAttaque.isPresent()) { 
			return optAttaque.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewAttaque.class)
	public Attaque create(@Valid @RequestBody Attaque attaque, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid");
		}
		
		attaque = attaqueRepo.save(attaque);
		
		return attaque;
	}
	
	@GetMapping("/pokemon/{id}")
	@JsonView(Views.ViewAttaque.class)
	public Optional<List<Attaque>> findAllAttaquesPokemon(@PathVariable Long id) {

		return attaqueRepo.findAllAttaquesAvaibleByMonPokemonId(id);

	}
}
