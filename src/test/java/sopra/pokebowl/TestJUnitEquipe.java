package sopra.pokebowl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class TestJUnitEquipe {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	public void equipeFindAllAndDelete() {
		
		IEquipeRepository equipeRepo = context.getBean(IEquipeRepository.class);
		
		Equipe e1 = new Equipe();
		Equipe e2 = new Equipe();
		
		e1 = equipeRepo.save(e1);
		e2 = equipeRepo.save(e2);
		
		List<Equipe> list = equipeRepo.findAll();
		
		Assert.assertEquals("A1 : ", 2, list.size());
		
		equipeRepo.delete(e1);
		equipeRepo.delete(e2);
		
		list = equipeRepo.findAll();
		
		Assert.assertEquals("A2 : ", 0, list.size());
		
	}
	
	@Test
	public void equipeFindById() {
		IEquipeRepository equipeRepo = context.getBean(IEquipeRepository.class);
		
		Equipe e1 = new Equipe();
		e1.setNbrPokemons(4);
		e1 = equipeRepo.save(e1);
		
		Optional<Equipe> e2 = equipeRepo.findById(e1.getId());
		
		Assert.assertEquals("A3 : ", (Integer)4, e2.get().getNbrPokemons());
		
		equipeRepo.delete(e1);
	}
	
	@Test
	public void equipeCreate() {
		IEquipeRepository equipeRepo = context.getBean(IEquipeRepository.class);
		IMonPokemonRepository monPokeRepo = context.getBean(IMonPokemonRepository.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		
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
	
		Assert.assertEquals("A4 : ", (Integer)1, e1.getNumero());
		Assert.assertEquals("A5 : ", "Equipe BG", e1.getNom());
		Assert.assertEquals("A6 : ", true, e1.getFavorite());
		Assert.assertEquals("A7 : ", uSauv.getId(), e1.getUtilisateurEquipeSauv().getId());
		Assert.assertEquals("A9 : ", p1.getId(), e1.getListPokemons().get(0).getId());
		Assert.assertEquals("A10 : ", p2.getId(), e1.getListPokemons().get(1).getId());
		Assert.assertEquals("A11 : ", p3.getId(), e1.getListPokemons().get(2).getId());
		Assert.assertEquals("A12 : ", p4.getId(), e1.getListPokemons().get(3).getId());
		
		equipeRepo.delete(e1);
		utilRepo.delete(uSauv);
		monPokeRepo.delete(p4);
		monPokeRepo.delete(p3);
		monPokeRepo.delete(p2);
		monPokeRepo.delete(p1);
		
	}
	
	@Test
	public void equipeUpdate() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IEquipeRepository equipeRepo = context.getBean(IEquipeRepository.class);
		
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
		
		Assert.assertEquals("A13 : ", (Integer)6, eFind.get().getNbrPokemons());
		Assert.assertEquals("A14 : ", false, eFind.get().getFavorite());
		Assert.assertEquals("A15 : ", "hello", eFind.get().getNom());
		Assert.assertEquals("A16 : ", (Integer)2, eFind.get().getNumero());
		
		equipeRepo.delete(e); 
		
	}

	@Test
	public void equipeFindEquipeByUtilisateurId() {
		
		IEquipeRepository equipeRepo = context.getBean(IEquipeRepository.class);
		IUtilisateurRepository utilRepo = context.getBean(IUtilisateurRepository.class);
		
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
		
		Assert.assertEquals(4, equipeU1.get().size());
		
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
