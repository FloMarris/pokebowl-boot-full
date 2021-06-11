package sopra.pokebowl.testRepo;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.pokebowl.model.Action;
import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.PokemonMatch;
import sopra.pokebowl.model.Tour;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IPokemonMatchRepository;
import sopra.pokebowl.repository.ITourRepository;

@SpringBootTest
public class TestJUnitTour {
	
	@Autowired
	ITourRepository tourRepo;
	@Autowired
	ICombatRepository combatRepo;
	@Autowired 
	IPokemonMatchRepository pokemonMatchRepo;
	
	@Test
	public void tourCreate() {
		Combat combat = new Combat();
		combat = combatRepo.save(combat); 
		
		PokemonMatch pokemon1 = new PokemonMatch();
		PokemonMatch pokemon2 = new PokemonMatch();
		pokemon1 = pokemonMatchRepo.save(pokemon1);  
		pokemon2 = pokemonMatchRepo.save(pokemon2);  
		
		Tour tour = new Tour();
		tour.setActionJoueur1(Action.ATTAQUER);
		tour.setActionJoueur2(Action.CHANGER);
		tour.setAttaquePokemon1("Abattage");
		tour.setAttaquePokemon2("Abîme"); 
		tour.setCombat(combat);
		tour.setPokemonMatch1(pokemon1);
		tour.setPokemonMatch2(pokemon2);  
		
		tour = tourRepo.save(tour);
		
		Optional<Tour> tourFind = tourRepo.findById(tour.getId());
		
		assertEquals(Action.ATTAQUER, tourFind.get().getActionJoueur1());
		assertEquals(Action.CHANGER, tourFind.get().getActionJoueur2());
		assertEquals("Abattage", tourFind.get().getAttaquePokemon1());
		assertEquals("Abîme", tourFind.get().getAttaquePokemon2());
		assertEquals(combat.getId(), tourFind.get().getCombat().getId());
		assertEquals(pokemon1.getNumero(), tourFind.get().getPokemonMatch1().getNumero());
		assertEquals(pokemon2.getNumero(), tourFind.get().getPokemonMatch2().getNumero());  
		
		tourRepo.delete(tour);
		combatRepo.delete(combat);
		pokemonMatchRepo.delete(pokemon1);
		pokemonMatchRepo.delete(pokemon2);
	}
	
	@Test
	public void tourUpdate() {		
		Tour tour = new Tour();
		tour.setActionJoueur1(Action.ATTAQUER);
		tour.setActionJoueur2(Action.CHANGER);
		tour.setAttaquePokemon1("Abattage");
		tour.setAttaquePokemon2("Abîme"); 
		
		tour = tourRepo.save(tour);
		
		tour.setActionJoueur1(Action.CHANGER);
		tour.setActionJoueur2(Action.ATTAQUER);
		tour.setAttaquePokemon1("Abîme");
		tour.setAttaquePokemon2("Abattage"); 
		
		tour = tourRepo.save(tour);
		
		Optional<Tour> tourFind = tourRepo.findById(tour.getId());
		
		assertEquals(Action.CHANGER, tourFind.get().getActionJoueur1());
		assertEquals(Action.ATTAQUER, tourFind.get().getActionJoueur2());
		assertEquals("Abîme", tourFind.get().getAttaquePokemon1());
		assertEquals("Abattage", tourFind.get().getAttaquePokemon2());
		
		tourRepo.delete(tour);
	}
	
	@Test
	public void tourFindAllAndDelete() {
		int listSize = tourRepo.findAll().size();
		
		Tour tour1 = new Tour();
		Tour tour2 = new Tour();
		Tour tour3 = new Tour();
		Tour tour4 = new Tour();
		
		tour1 = tourRepo.save(tour1);
		tour2 = tourRepo.save(tour2);
		tour3 = tourRepo.save(tour3);
		tour4 = tourRepo.save(tour4);
		
		List<Tour> tours = tourRepo.findAll();
		
		assertEquals(listSize + 4, tours.size());  
		tourRepo.delete(tour1);
		tourRepo.delete(tour2);
		tourRepo.delete(tour3);
		tourRepo.delete(tour4);
		
		tours = tourRepo.findAll();
		
		assertEquals(listSize, tours.size());
	}
}
