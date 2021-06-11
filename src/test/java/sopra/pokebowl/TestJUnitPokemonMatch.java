package sopra.pokebowl;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.PokemonMatch;
import sopra.pokebowl.model.Statut;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonMatchRepository;

@SpringBootTest
public class TestJUnitPokemonMatch {
	
	@Autowired
	IPokemonMatchRepository pokemonMatchRepo;
	@Autowired
	ICombatRepository combatRepo;
	@Autowired
	IMonPokemonRepository monPokemonRepo;
	
	@Test
	public void pokemonMatchCreate() {
		MonPokemon monPokemon = new MonPokemon();
		monPokemon = monPokemonRepo.save(monPokemon);
		
		Combat combat = new Combat();
		combat = combatRepo.save(combat);
		
		PokemonMatch pokemonMatch = new PokemonMatch();
		pokemonMatch.setHpMatch(200);
		pokemonMatch.setAttackMatch(23);
		pokemonMatch.setDefenseMatch(5);
		pokemonMatch.setSpecialAttackMatch(78);
		pokemonMatch.setSpecialDefenseMatch(34);
		pokemonMatch.setSpeedMatch(12);
		pokemonMatch.setNumAttaqueActive(1);
		pokemonMatch.setStatut(Statut.EMPOISONNE);
		pokemonMatch.setPpAttaque1(4);
		pokemonMatch.setPpAttaque2(3);
		pokemonMatch.setPpAttaque3(0);
		pokemonMatch.setPpAttaque4(12);
		pokemonMatch.setCombat(combat);
		pokemonMatch.setMonPokemon(monPokemon);
		
		pokemonMatch = pokemonMatchRepo.save(pokemonMatch);
		
		Optional<PokemonMatch> pokemonMatchFind = pokemonMatchRepo.findById(pokemonMatch.getNumero());
		
		assertEquals(200, pokemonMatchFind.get().getHpMatch());
		assertEquals(23, pokemonMatchFind.get().getAttackMatch());
		assertEquals(5, pokemonMatchFind.get().getDefenseMatch());
		assertEquals(78, pokemonMatchFind.get().getSpecialAttackMatch());
		assertEquals(34, pokemonMatchFind.get().getSpecialDefenseMatch());
		assertEquals(12, pokemonMatchFind.get().getSpeedMatch());
		assertEquals(1, pokemonMatchFind.get().getNumAttaqueActive());
		assertEquals(Statut.EMPOISONNE, pokemonMatchFind.get().getStatut());
		assertEquals(4, pokemonMatchFind.get().getPpAttaque1());
		assertEquals(3, pokemonMatchFind.get().getPpAttaque2());
		assertEquals(0, pokemonMatchFind.get().getPpAttaque3());
		assertEquals(12, pokemonMatchFind.get().getPpAttaque4());
		assertEquals(combat.getId(), pokemonMatchFind.get().getCombat().getId());
		assertEquals(monPokemon.getId(), pokemonMatchFind.get().getMonPokemon().getId());
		
		pokemonMatchRepo.delete(pokemonMatch);
		combatRepo.delete(combat);
		monPokemonRepo.delete(monPokemon);
	}
	
	@Test
	public void pokemonMatchUpdate() {		
		PokemonMatch pokemonMatch = new PokemonMatch();
		pokemonMatch.setHpMatch(200);
		pokemonMatch.setAttackMatch(23);
		pokemonMatch.setDefenseMatch(5);
		
		pokemonMatch = pokemonMatchRepo.save(pokemonMatch);
		
		pokemonMatch.setHpMatch(120);
		pokemonMatch.setAttackMatch(15);
		pokemonMatch.setDefenseMatch(32);
		
		pokemonMatch = pokemonMatchRepo.save(pokemonMatch);
		
		Optional<PokemonMatch> pokemonMatchFind = pokemonMatchRepo.findById(pokemonMatch.getNumero());
		
		assertEquals(120, pokemonMatchFind.get().getHpMatch());
		assertEquals(15, pokemonMatchFind.get().getAttackMatch());
		assertEquals(32, pokemonMatchFind.get().getDefenseMatch());
		
		pokemonMatchRepo.delete(pokemonMatch);
	}
	
	@Test
	public void pokemonMatchFindAllAndDelete() {		
		PokemonMatch pokemonMatch1 = new PokemonMatch();
		PokemonMatch pokemonMatch2 = new PokemonMatch();
		PokemonMatch pokemonMatch3 = new PokemonMatch();   
		PokemonMatch pokemonMatch4 = new PokemonMatch();
		
		pokemonMatch1 = pokemonMatchRepo.save(pokemonMatch1);
		pokemonMatch2 = pokemonMatchRepo.save(pokemonMatch2);
		pokemonMatch3 = pokemonMatchRepo.save(pokemonMatch3);
		pokemonMatch4 = pokemonMatchRepo.save(pokemonMatch4);
		
		List<PokemonMatch> pokemons = pokemonMatchRepo.findAll();
		
		assertEquals(4, pokemons.size());
		
		pokemonMatchRepo.delete(pokemonMatch1);
		pokemonMatchRepo.delete(pokemonMatch2);
		pokemonMatchRepo.delete(pokemonMatch3);
		pokemonMatchRepo.delete(pokemonMatch4);
		
		pokemons = pokemonMatchRepo.findAll();
		
		assertEquals(0, pokemons.size());
	}
}
