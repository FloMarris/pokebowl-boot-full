package sopra.pokebowl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.model.Action;
import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Role;
import sopra.pokebowl.model.Salon;
import sopra.pokebowl.model.Tour;
import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.model.UtilisateurRole;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.ISalonRepository;
import sopra.pokebowl.repository.ITourRepository;
import sopra.pokebowl.repository.ITypeClassRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

@SpringBootTest
public class TestJUnitCreateFakeData {
	
	@Autowired
	IUtilisateurRepository utilisateurRepo; 
	@Autowired
	ISalonRepository salonRepo; 
	@Autowired
	ICombatRepository combatRepo; 
	@Autowired
	ITourRepository tourRepo; 
	@Autowired
	ITypeClassRepository typeClassRepo; 
	@Autowired
	IEquipeRepository equipeRepo; 
	@Autowired
	IPokemonRepository pokemonRepo; 
	@Autowired
	IMonPokemonRepository monPokemonRepo; 
	
	@Test
	public void CreateFakeDate() {
		
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setPseudo("pokemonator");
		utilisateur1.setEmail("jean.jojo@gmail.com");
		utilisateur1.setAvatar("chemin/avatar");
		utilisateur1.setMotDePasse("lesoleilbrille33");
		utilisateur1.setEnable(true);
		
		UtilisateurRole u1Role = new UtilisateurRole();
		u1Role.setRole(Role.ADMIN);
		u1Role.setUser(utilisateur1);
		
		utilisateur1 = utilisateurRepo.save(utilisateur1);
		
		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setPseudo("jeanyves");
		utilisateur2.setEmail("alexis.dupond@hotmail.fr");
		utilisateur2.setAvatar("disqueC/image/avatar4");
		utilisateur2.setMotDePasse("unplusdeux++");
		utilisateur2.setEnable(true);
		
		utilisateur2 = utilisateurRepo.save(utilisateur2);
		
		for(TypeEnum t : TypeEnum.values()) {
			TypeClass type = new TypeClass();
			type.setType(t);
			type = typeClassRepo.save(type);
		}
		
//		Salon salon = new Salon();
//		salon.setNom("salon des bg");
//		salon.setMotDePasse("32785654");
//		
//		salon = salonRepo.save(salon);
//		
//		Salon salon2 = new Salon();
//		salon2.setNom("salon numéro 3");
//		salon2.setMotDePasse("998765411");
		
//		salon2 = salonRepo.save(salon2);
		
//		Combat combat = new Combat(); 
//		combat.setIdUtilisateurGagnant(1L);
//		
//		Combat combat2 = new Combat(); 
//		combat2.setIdUtilisateurGagnant(90L);
//		
//		Combat combat3 = new Combat(); 
//		combat3.setIdUtilisateurGagnant(23L);
//		
//		Combat combat4 = new Combat(); 
//		combat4.setIdUtilisateurGagnant(34L);
//		
//		combat = combatRepo.save(combat);
//		combat2 = combatRepo.save(combat2);
//		combat3 = combatRepo.save(combat3);
//		combat4 = combatRepo.save(combat4);
		
//		Tour tour = new Tour();
//		tour.setActionJoueur1(Action.ATTAQUER);
//		tour.setActionJoueur2(Action.CHANGER);
//		tour.setAttaquePokemon1("Abattage");
//		tour.setAttaquePokemon2("Abîme"); 
//		
//		tour = tourRepo.save(tour);
//		
//		Tour tour2 = new Tour();
//		tour2.setActionJoueur1(Action.CHANGER);
//		tour2.setActionJoueur2(Action.ATTAQUER);
//		tour2.setAttaquePokemon1("Abîme");
//		tour2.setAttaquePokemon2("Abattage"); 
//		
//		tour2 = tourRepo.save(tour2);
		
//		TypeClass t1 = new TypeClass();
//		t1.setType(TypeEnum.ACIER);
//		t1.setAvatar("/oihvoieh/ozefzhf");
//		
//		TypeClass t2 = new TypeClass();
//		t2.setType(TypeEnum.COMBAT);
//		t2.setAvatar("cjfjfjf/jfjfjfj");
//		
//		t1 = typeClassRepo.save(t1);
//		t2 = typeClassRepo.save(t2);
		
//		Equipe e1 = new Equipe();
//		e1.setNom("equipe 1");
//		e1.setFavorite(false);
//		e1.setNbrPokemons(3);
//		
//		Equipe e2 = new Equipe();
//		e2.setNom("equipe 1");
//		e2.setFavorite(false);
//		e2.setNbrPokemons(5);
//		
//		Equipe e3 = new Equipe();
//		e3.setNom("equipe 3");
//		e3.setFavorite(true);
//		e3.setNbrPokemons(6);
//		
//		Equipe e4 = new Equipe();
//		e4.setNom("equipe 4");
//		e4.setFavorite(false);
//		e4.setNbrPokemons(6);
//		
//		e1 = equipeRepo.save(e1);
//		e2 = equipeRepo.save(e2);
//		e3 = equipeRepo.save(e3);
//		e4 = equipeRepo.save(e4);
		
		
//		// EQUIPE 1
//		MonPokemon monPoke1 = new MonPokemon();
//		monPoke1.setOrdre(1);
//		monPoke1.setPokeReference(pokemonRepo.findById(183L).get());
//		monPoke1.setEquipe(equipeRepo.findById(336L).get());
//		
//		MonPokemon monPoke2 = new MonPokemon();
//		monPoke2.setOrdre(2);
//		monPoke2.setPokeReference(pokemonRepo.findById(184L).get());
//		monPoke2.setEquipe(equipeRepo.findById(336L).get());
//		
//		MonPokemon monPoke3 = new MonPokemon();
//		monPoke3.setOrdre(3);
//		monPoke3.setPokeReference(pokemonRepo.findById(185L).get());
//		monPoke3.setEquipe(equipeRepo.findById(336L).get());
//		
//		// EQUIPE 2
//		MonPokemon monPoke4 = new MonPokemon();
//		monPoke4.setOrdre(1);
//		monPoke4.setPokeReference(pokemonRepo.findById(197L).get());
//		monPoke4.setEquipe(equipeRepo.findById(337L).get());
//		
//		MonPokemon monPoke5 = new MonPokemon();
//		monPoke5.setOrdre(1);
//		monPoke5.setPokeReference(pokemonRepo.findById(198L).get());
//		monPoke5.setEquipe(equipeRepo.findById(337L).get());
//		
//		MonPokemon monPoke6 = new MonPokemon();
//		monPoke6.setOrdre(1);
//		monPoke6.setPokeReference(pokemonRepo.findById(199L).get());
//		monPoke6.setEquipe(equipeRepo.findById(337L).get());
//		
//		MonPokemon monPoke7 = new MonPokemon();
//		monPoke7.setOrdre(1);
//		monPoke7.setPokeReference(pokemonRepo.findById(200L).get());
//		monPoke7.setEquipe(equipeRepo.findById(337L).get());
//		
//		MonPokemon monPoke8 = new MonPokemon();
//		monPoke7.setOrdre(1);
//		monPoke7.setPokeReference(pokemonRepo.findById(201L).get());
//		monPoke7.setEquipe(equipeRepo.findById(337L).get());
//		
//		// EQUIPE 3
//		MonPokemon monPoke9 = new MonPokemon();
//		monPoke9.setOrdre(1);
//		monPoke9.setPokeReference(pokemonRepo.findById(210L).get());
//		monPoke9.setEquipe(equipeRepo.findById(338L).get());
//
//		MonPokemon monPoke10 = new MonPokemon();
//		monPoke10.setOrdre(1);
//		monPoke10.setPokeReference(pokemonRepo.findById(211L).get());
//		monPoke10.setEquipe(equipeRepo.findById(338L).get());
//
//		MonPokemon monPoke11 = new MonPokemon();
//		monPoke11.setOrdre(1);
//		monPoke11.setPokeReference(pokemonRepo.findById(212L).get());
//		monPoke11.setEquipe(equipeRepo.findById(338L).get());
//
//		MonPokemon monPoke12 = new MonPokemon();
//		monPoke12.setOrdre(1);
//		monPoke12.setPokeReference(pokemonRepo.findById(213L).get());
//		monPoke12.setEquipe(equipeRepo.findById(338L).get());
//
//		MonPokemon monPoke13 = new MonPokemon();
//		monPoke13.setOrdre(1);
//		monPoke13.setPokeReference(pokemonRepo.findById(214L).get());
//		monPoke13.setEquipe(equipeRepo.findById(338L).get());
//		
//		MonPokemon monPoke14 = new MonPokemon();
//		monPoke14.setOrdre(1);
//		monPoke14.setPokeReference(pokemonRepo.findById(238L).get());
//		monPoke14.setEquipe(equipeRepo.findById(338L).get());
//		
//		// EQUIPE 3
//		MonPokemon monPoke15 = new MonPokemon();
//		monPoke15.setOrdre(1);
//		monPoke15.setPokeReference(pokemonRepo.findById(183L).get());
//		monPoke15.setEquipe(equipeRepo.findById(339L).get());
//
//		MonPokemon monPoke16 = new MonPokemon();
//		monPoke16.setOrdre(1);
//		monPoke16.setPokeReference(pokemonRepo.findById(218L).get());
//		monPoke16.setEquipe(equipeRepo.findById(339L).get());
//
//		MonPokemon monPoke17 = new MonPokemon();
//		monPoke17.setOrdre(1);
//		monPoke17.setPokeReference(pokemonRepo.findById(239L).get());
//		monPoke17.setEquipe(equipeRepo.findById(339L).get());
//
//		MonPokemon monPoke18 = new MonPokemon();
//		monPoke18.setOrdre(1);
//		monPoke18.setPokeReference(pokemonRepo.findById(200L).get());
//		monPoke18.setEquipe(equipeRepo.findById(339L).get());
//
//		MonPokemon monPoke19 = new MonPokemon();
//		monPoke19.setOrdre(1);
//		monPoke19.setPokeReference(pokemonRepo.findById(290L).get());
//		monPoke19.setEquipe(equipeRepo.findById(339L).get());
//
//		MonPokemon monPoke20 = new MonPokemon();
//		monPoke20.setOrdre(1);
//		monPoke20.setPokeReference(pokemonRepo.findById(232L).get());
//		monPoke20.setEquipe(equipeRepo.findById(339L).get());
//		
//		monPoke1 = monPokemonRepo.save(monPoke1);
//		monPoke2 = monPokemonRepo.save(monPoke2);
//		monPoke3 = monPokemonRepo.save(monPoke3);
//		monPoke4 = monPokemonRepo.save(monPoke4);
//		monPoke5 = monPokemonRepo.save(monPoke5);
//		monPoke6 = monPokemonRepo.save(monPoke6);
//		monPoke7 = monPokemonRepo.save(monPoke7);
//		monPoke8 = monPokemonRepo.save(monPoke8);
//		monPoke9 = monPokemonRepo.save(monPoke9);
//		monPoke10 = monPokemonRepo.save(monPoke10);
//		monPoke11 = monPokemonRepo.save(monPoke11);
//		monPoke12 = monPokemonRepo.save(monPoke12);
//		monPoke13 = monPokemonRepo.save(monPoke13);
//		monPoke14 = monPokemonRepo.save(monPoke14);
//		monPoke15 = monPokemonRepo.save(monPoke15);
//		monPoke16 = monPokemonRepo.save(monPoke16);
//		monPoke17 = monPokemonRepo.save(monPoke17);
//		monPoke18 = monPokemonRepo.save(monPoke18);
//		monPoke19 = monPokemonRepo.save(monPoke19);
//		monPoke20 = monPokemonRepo.save(monPoke20);
	}
}
