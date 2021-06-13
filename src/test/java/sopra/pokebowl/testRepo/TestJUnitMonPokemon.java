package sopra.pokebowl.testRepo;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonRepository;

@SpringBootTest
public class TestJUnitMonPokemon {
	
	@Autowired
	IEquipeRepository equipeRepo;  
	@Autowired
	IMonPokemonRepository monPokeRepo;
	@Autowired
	IAttaqueRepository attaqueRepo;
	@Autowired
	IPokemonRepository pokeRepo;
	
	@Test
	public void monPokeFindAllAndDelete() {		
		int listSize = monPokeRepo.findAll().size();
		
		MonPokemon p1 = new MonPokemon();
		MonPokemon p2 = new MonPokemon(); 
		
		p1 = monPokeRepo.save(p1);
		p2 = monPokeRepo.save(p2);
		
		List<MonPokemon> list = monPokeRepo.findAll();
		
		assertEquals(listSize + 2, list.size());
		
		monPokeRepo.delete(p1);
		monPokeRepo.delete(p2);
		
		list = monPokeRepo.findAll();
		
		assertEquals(listSize, list.size());
		
	}
	
	@Test
	public void monPokeFindById() {
		MonPokemon p1 = new MonPokemon();
		p1.setOrdre(2);
		p1 = monPokeRepo.save(p1);
		
		Optional<MonPokemon> p2 = monPokeRepo.findById(p1.getId());
		
		assertEquals((Integer)2, p2.get().getOrdre());
		
		monPokeRepo.delete(p1);
	}
	
	@Test
	public void monPokeCreate() {
		MonPokemon p1 = new MonPokemon();
		p1.setOrdre(1);
		
		Equipe e = new Equipe();
		e = equipeRepo.save(e);
		p1.setEquipe(e);
		
		Attaque a1 = new Attaque();
		a1 = attaqueRepo.save(a1);
		Attaque a2 = new Attaque();
		a2 = attaqueRepo.save(a2);
		Attaque a3 = new Attaque();
		a3 = attaqueRepo.save(a3);
		Attaque a4 = new Attaque();
		a4 = attaqueRepo.save(a4);
		
		p1.setAttaque1(a1);
		p1.setAttaque2(a2);
		p1.setAttaque3(a3);
		p1.setAttaque4(a4);
		
		Pokemon p = new Pokemon();
		p = pokeRepo.save(p);
		p1.setPokeReference(p);
		
		p1 = monPokeRepo.save(p1);
	
		assertEquals((Integer)1, p1.getOrdre());
		assertEquals(e.getId(), p1.getEquipe().getId());
		assertEquals(a1.getId(), p1.getAttaque1().getId());
		assertEquals(a2.getId(), p1.getAttaque2().getId());
		assertEquals(a3.getId(), p1.getAttaque3().getId());
		assertEquals(a4.getId(), p1.getAttaque4().getId());
		assertEquals(p.getId(), p1.getPokeReference().getId());
		
		monPokeRepo.delete(p1);
		pokeRepo.delete(p);
		attaqueRepo.delete(a4);
		attaqueRepo.delete(a3);
		attaqueRepo.delete(a2);
		attaqueRepo.delete(a1);
		equipeRepo.delete(e);
	}
	
	@Test
	public void monPokeUpdate() {		
		MonPokemon p = new MonPokemon();
		p.setOrdre(2);
		p = monPokeRepo.save(p);
		
		p.setOrdre(5);
		p = monPokeRepo.save(p);
		
		Optional<MonPokemon> pFind = monPokeRepo.findById(p.getId());
		
		assertEquals((Integer)5, pFind.get().getOrdre());
	
		monPokeRepo.delete(p); 
	}
	
}
