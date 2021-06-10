package sopra.pokebowl;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.PokemonMatch;
import sopra.pokebowl.model.Statut;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonMatchRepository;

public class TestJUnitPokemonMatch {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	public void pokemonMatchCreate() {
		IPokemonMatchRepository pokemonMatchRepo = context.getBean(IPokemonMatchRepository.class);
		ICombatRepository combatRepo = context.getBean(ICombatRepository.class);
		IMonPokemonRepository monPokemonRepo = context.getBean(IMonPokemonRepository.class);
		
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
		
		Assert.assertEquals(200, pokemonMatchFind.get().getHpMatch());
		Assert.assertEquals(23, pokemonMatchFind.get().getAttackMatch());
		Assert.assertEquals(5, pokemonMatchFind.get().getDefenseMatch());
		Assert.assertEquals(78, pokemonMatchFind.get().getSpecialAttackMatch());
		Assert.assertEquals(34, pokemonMatchFind.get().getSpecialDefenseMatch());
		Assert.assertEquals(12, pokemonMatchFind.get().getSpeedMatch());
		Assert.assertEquals(1, pokemonMatchFind.get().getNumAttaqueActive());
		Assert.assertEquals(Statut.EMPOISONNE, pokemonMatchFind.get().getStatut());
		Assert.assertEquals(4, pokemonMatchFind.get().getPpAttaque1());
		Assert.assertEquals(3, pokemonMatchFind.get().getPpAttaque2());
		Assert.assertEquals(0, pokemonMatchFind.get().getPpAttaque3());
		Assert.assertEquals(12, pokemonMatchFind.get().getPpAttaque4());
		Assert.assertEquals(combat.getId(), pokemonMatchFind.get().getCombat().getId());
		Assert.assertEquals(monPokemon.getId(), pokemonMatchFind.get().getMonPokemon().getId());
		
		pokemonMatchRepo.delete(pokemonMatch);
		combatRepo.delete(combat);
		monPokemonRepo.delete(monPokemon);
	}
	
	@Test
	public void pokemonMatchUpdate() {
		IPokemonMatchRepository pokemonMatchRepo = context.getBean(IPokemonMatchRepository.class);
		
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
		
		Assert.assertEquals(120, pokemonMatchFind.get().getHpMatch());
		Assert.assertEquals(15, pokemonMatchFind.get().getAttackMatch());
		Assert.assertEquals(32, pokemonMatchFind.get().getDefenseMatch());
		
		pokemonMatchRepo.delete(pokemonMatch);
	}
	
	@Test
	public void pokemonMatchFindAllAndDelete() {
		IPokemonMatchRepository pokemonMatchRepo = context.getBean(IPokemonMatchRepository.class);
		
		PokemonMatch pokemonMatch1 = new PokemonMatch();
		PokemonMatch pokemonMatch2 = new PokemonMatch();
		PokemonMatch pokemonMatch3 = new PokemonMatch();   
		PokemonMatch pokemonMatch4 = new PokemonMatch();
		
		pokemonMatch1 = pokemonMatchRepo.save(pokemonMatch1);
		pokemonMatch2 = pokemonMatchRepo.save(pokemonMatch2);
		pokemonMatch3 = pokemonMatchRepo.save(pokemonMatch3);
		pokemonMatch4 = pokemonMatchRepo.save(pokemonMatch4);
		
		List<PokemonMatch> pokemons = pokemonMatchRepo.findAll();
		
		Assert.assertEquals(4, pokemons.size());
		
		pokemonMatchRepo.delete(pokemonMatch1);
		pokemonMatchRepo.delete(pokemonMatch2);
		pokemonMatchRepo.delete(pokemonMatch3);
		pokemonMatchRepo.delete(pokemonMatch4);
		
		pokemons = pokemonMatchRepo.findAll();
		
		Assert.assertEquals(0, pokemons.size());
	}
}
