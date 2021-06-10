package sopra.pokebowl;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Action;
import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.PokemonMatch;
import sopra.pokebowl.model.Tour;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IPokemonMatchRepository;
import sopra.pokebowl.repository.ITourRepository;

public class TestJUnitTour {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	public void tourCreate() {
		ITourRepository tourRepo = context.getBean(ITourRepository.class);
		ICombatRepository combatRepo = context.getBean(ICombatRepository.class);
		IPokemonMatchRepository pokemonMatchRepo = context.getBean(IPokemonMatchRepository.class);
		
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
		
		Assert.assertEquals(Action.ATTAQUER, tourFind.get().getActionJoueur1());
		Assert.assertEquals(Action.CHANGER, tourFind.get().getActionJoueur2());
		Assert.assertEquals("Abattage", tourFind.get().getAttaquePokemon1());
		Assert.assertEquals("Abîme", tourFind.get().getAttaquePokemon2());
		Assert.assertEquals(combat.getId(), tourFind.get().getCombat().getId());
		Assert.assertEquals(pokemon1.getNumero(), tourFind.get().getPokemonMatch1().getNumero());
		Assert.assertEquals(pokemon2.getNumero(), tourFind.get().getPokemonMatch2().getNumero());  
		
		tourRepo.delete(tour);
		combatRepo.delete(combat);
		pokemonMatchRepo.delete(pokemon1);
		pokemonMatchRepo.delete(pokemon2);
	}
	
	@Test
	public void tourUpdate() {
		ITourRepository tourRepo = context.getBean(ITourRepository.class);
		
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
		
		Assert.assertEquals(Action.CHANGER, tourFind.get().getActionJoueur1());
		Assert.assertEquals(Action.ATTAQUER, tourFind.get().getActionJoueur2());
		Assert.assertEquals("Abîme", tourFind.get().getAttaquePokemon1());
		Assert.assertEquals("Abattage", tourFind.get().getAttaquePokemon2());
		
		tourRepo.delete(tour);
	}
	
	@Test
	public void tourFindAllAndDelete() {
		ITourRepository tourRepo = context.getBean(ITourRepository.class);
		
		Tour tour1 = new Tour();
		Tour tour2 = new Tour();
		Tour tour3 = new Tour();
		Tour tour4 = new Tour();
		
		tour1 = tourRepo.save(tour1);
		tour2 = tourRepo.save(tour2);
		tour3 = tourRepo.save(tour3);
		tour4 = tourRepo.save(tour4);
		
		List<Tour> tours = tourRepo.findAll();
		
		Assert.assertEquals(4, tours.size());  
		tourRepo.delete(tour1);
		tourRepo.delete(tour2);
		tourRepo.delete(tour3);
		tourRepo.delete(tour4);
		
		tours = tourRepo.findAll();
		
		Assert.assertEquals(0, tours.size());
	}
}
