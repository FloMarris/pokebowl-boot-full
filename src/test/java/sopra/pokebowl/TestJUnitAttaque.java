package sopra.pokebowl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.CategorieAttaque;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.ITypeClassRepository;

public class TestJUnitAttaque {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	public void attaqueFindAllAndDelete() {
		IAttaqueRepository attaqueRepo = context.getBean(IAttaqueRepository.class);
		
		Attaque a1 = new Attaque();
		Attaque a2 = new Attaque();
		
		a1 = attaqueRepo.save(a1);
		a2 = attaqueRepo.save(a2);
		
		List<Attaque> list = attaqueRepo.findAll();
		
		Assert.assertEquals(2, list.size());
		
		attaqueRepo.delete(a1);
		attaqueRepo.delete(a2);
		
		list = attaqueRepo.findAll();
		
		Assert.assertEquals(0, list.size());
		
		
	}
	
	@Test
	public void attaqueCreate() {
		IAttaqueRepository attaqueRepo = context.getBean(IAttaqueRepository.class);
		ITypeClassRepository typeClassRepo = context.getBean(ITypeClassRepository.class);
		IPokemonRepository pokemonRepo = context.getBean(IPokemonRepository.class);
		
		String nom = "Charge";
		CategorieAttaque categorie = CategorieAttaque.PHYSIQUE;
		Integer pointDePouvoir = 35;
		Integer puissance = 40;
		Float precisionAttaque = 100f;
		String description = "Le lanceur charge l'ennemi et le percute de tout son poids.";
			
		Attaque a1 = new Attaque(nom, categorie, pointDePouvoir, puissance, precisionAttaque, description);
		
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		Pokemon p1 = new Pokemon();
		Pokemon p2 = new Pokemon();
		Pokemon p3 = new Pokemon();
		Pokemon p4 = new Pokemon();
		
		pokemons.add(p1);
		p1 = pokemonRepo.save(p1);
		pokemons.add(p2);
		p2 = pokemonRepo.save(p2);
		pokemons.add(p3);
		p3 = pokemonRepo.save(p3);
		pokemons.add(p4);
		p4 = pokemonRepo.save(p4);
		
		a1.setPokemons(pokemons);
		
		TypeClass type1 = new TypeClass(TypeEnum.NORMAL, null);
		
		type1 = typeClassRepo.save(type1);
		
		a1.setTypeAttaque(type1);
		
		a1 = attaqueRepo.save(a1);

	
		//Assert.assertEquals((Integer)5, p1.getId());
		Assert.assertEquals("Charge", a1.getNom());
		Assert.assertEquals(CategorieAttaque.PHYSIQUE, a1.getCategorie());
		Assert.assertEquals((Integer)35, a1.getPointDePouvoir());
		Assert.assertEquals((Integer)40, a1.getPuissance());
		Assert.assertEquals((Float)100f, a1.getPrecisionAttaque());
		Assert.assertEquals("Le lanceur charge l'ennemi et le percute de tout son poids.", a1.getDescription());
		Assert.assertEquals(4, a1.getPokemons().size());
		Assert.assertEquals(TypeEnum.NORMAL, a1.getTypeAttaque().getType());
		
		attaqueRepo.delete(a1);
		pokemonRepo.delete(p4);
		pokemonRepo.delete(p3);
		pokemonRepo.delete(p2);
		pokemonRepo.delete(p1);
		typeClassRepo.delete(type1);
		
	}
	
	@Test
	public void attaqueUpdate() {
		IAttaqueRepository attaqueRepo = context.getBean(IAttaqueRepository.class);
		
		String nom = "Charge";
		CategorieAttaque categorie = CategorieAttaque.PHYSIQUE;
		Integer pointDePouvoir = 35;
		Integer puissance = 40;
		Float precisionAttaque = 100f;
		String description = "Le lanceur charge l'ennemi et le percute de tout son poids.";
			
		Attaque a = new Attaque(nom, categorie, pointDePouvoir, puissance, precisionAttaque, description);
		
		a = attaqueRepo.save(a);
		
		a.setPointDePouvoir(34);
		a = attaqueRepo.save(a);
		
		Optional<Attaque> pFind = attaqueRepo.findById(a.getId());
		
		Assert.assertEquals((Integer)34, pFind.get().getPointDePouvoir());
	
		attaqueRepo.delete(a);
		
	}
}
