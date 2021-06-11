package sopra.pokebowl.testRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

@SpringBootTest
public class TestJUnitEquipe { 
	
	@Autowired
	IEquipeRepository equipeRepo;
	@Autowired
	IMonPokemonRepository monPokeRepo;
	@Autowired
	IUtilisateurRepository utilRepo;
	
	@Test
	public void equipeFindAllAndDelete() {
		int listSize = equipeRepo.findAll().size();
		
		Equipe e1 = new Equipe();
		Equipe e2 = new Equipe();
		
		e1 = equipeRepo.save(e1);
		e2 = equipeRepo.save(e2);
		
		List<Equipe> list = equipeRepo.findAll();
		
		assertEquals(listSize + 2, list.size());
		
		equipeRepo.delete(e1);
		equipeRepo.delete(e2);
		
		list = equipeRepo.findAll();
		
		assertEquals(listSize, list.size());
		
	}
	
	@Test
	public void equipeFindById() {		
		Equipe e1 = new Equipe();
		e1.setNbrPokemons(4);
		e1 = equipeRepo.save(e1);
		
		Optional<Equipe> e2 = equipeRepo.findById(e1.getId());
		
		assertEquals((Integer)4, e2.get().getNbrPokemons());
		
		equipeRepo.delete(e1);
	}
	
	@Test
	public void equipeCreate() {
		MonPokemon p1 = new MonPokemon();
		MonPokemon p2 = new MonPokemon();
		MonPokemon p3 = new MonPokemon();
		MonPokemon p4 = new MonPokemon();
		p1 = monPokeRepo.save(p1);
		p2 = monPokeRepo.save(p2);
		p3 = monPokeRepo.save(p3);
		p4 = monPokeRepo.save(p4);
		
		List<MonPokemon> l1 = new ArrayList<MonPokemon>();
		l1.add(p1);
		l1.add(p2);
		l1.add(p3);
		l1.add(p4);
		
		Utilisateur uSauv = new Utilisateur();
		uSauv = utilRepo.save(uSauv);
		
		Equipe e1 = new Equipe();
		e1.setFavorite(true);
		e1.setNom("Equipe BG");
		e1.setNumero(1);
		e1.setNbrPokemons(l1.size());
		e1.setListPokemons(l1);
		
		e1 = equipeRepo.save(e1);
		
		e1.setUtilisateurEquipeSauv(uSauv);
	
		assertEquals((Integer)1, e1.getNumero());
		assertEquals("Equipe BG", e1.getNom());
		assertEquals(true, e1.getFavorite());
		assertEquals(uSauv.getId(), e1.getUtilisateurEquipeSauv().getId());
		assertEquals(p1.getId(), e1.getListPokemons().get(0).getId());
		assertEquals(p2.getId(), e1.getListPokemons().get(1).getId());
		assertEquals(p3.getId(), e1.getListPokemons().get(2).getId());
		assertEquals(p4.getId(), e1.getListPokemons().get(3).getId());
		
		equipeRepo.delete(e1);
		utilRepo.delete(uSauv);
		monPokeRepo.delete(p4);
		monPokeRepo.delete(p3);
		monPokeRepo.delete(p2);
		monPokeRepo.delete(p1);
		
	}
	
	@Test
	public void equipeUpdate() {
		Equipe e = new Equipe();
		e.setNbrPokemons(4);
		e.setFavorite(true);
		e.setNom("coucou");
		e.setNumero(1);
		
		e = equipeRepo.save(e);
		
		e.setNbrPokemons(6);
		e.setFavorite(false);
		e.setNom("hello");
		e.setNumero(2);
		
		e = equipeRepo.save(e); 
		
		Optional<Equipe> eFind = equipeRepo.findById(e.getId());
		
		assertEquals((Integer)6, eFind.get().getNbrPokemons());
		assertEquals(false, eFind.get().getFavorite());
		assertEquals("hello", eFind.get().getNom());
		assertEquals((Integer)2, eFind.get().getNumero());
		
		equipeRepo.delete(e); 
		
	}

	@Test
	public void equipeFindEquipeByUtilisateurId() {	
		Equipe e1 = new Equipe();
		Equipe e2 = new Equipe();
		Equipe e3 = new Equipe();
		Equipe e4 = new Equipe();
		Equipe e5 = new Equipe();
		Equipe e6 = new Equipe();
		
		Utilisateur u1 = new Utilisateur();
		u1 = utilRepo.save(u1);
		
		Utilisateur u2 = new Utilisateur();
		u2 = utilRepo.save(u2);
		
		Utilisateur u3 = new Utilisateur();
		u3 = utilRepo.save(u3);
		
		int listSize = equipeRepo.findEquipesByUtilisateurId(u1.getId()).get().size();
		
		e1.setUtilisateurEquipeSauv(u1);
		e2.setUtilisateurEquipeSauv(u1);
		e3.setUtilisateurEquipeSauv(u1);
		e4.setUtilisateurEquipeSauv(u1);
		e5.setUtilisateurEquipeSauv(u2);
		e6.setUtilisateurEquipeSauv(u2);
		
		e1 = equipeRepo.save(e1);
		e2 = equipeRepo.save(e2);
		e3 = equipeRepo.save(e3);
		e4 = equipeRepo.save(e4);
		e5 = equipeRepo.save(e5);
		e6 = equipeRepo.save(e6);
		
		Optional<List<Equipe>> equipeU1 = equipeRepo.findEquipesByUtilisateurId(u1.getId());
		
		assertEquals(listSize + 4, equipeU1.get().size());
		
		equipeRepo.delete(e1);
		equipeRepo.delete(e2);
		equipeRepo.delete(e3);
		equipeRepo.delete(e4);
		equipeRepo.delete(e5);
		equipeRepo.delete(e6);
		
		utilRepo.delete(u1);
		utilRepo.delete(u2);
		utilRepo.delete(u3);
		
		
	}
}
