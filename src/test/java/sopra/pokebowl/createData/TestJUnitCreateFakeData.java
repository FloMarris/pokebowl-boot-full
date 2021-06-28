package sopra.pokebowl.createData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.pokebowl.model.Action;
import sopra.pokebowl.model.Combat;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.PokemonMatch;
import sopra.pokebowl.model.Role;
import sopra.pokebowl.model.Salon;
import sopra.pokebowl.model.Statistique;
import sopra.pokebowl.model.Tour;
import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.model.UtilisateurRole;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.ICombatRepository;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonMatchRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.ISalonRepository;
import sopra.pokebowl.repository.ITourRepository;
import sopra.pokebowl.repository.ITypeClassRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;
import sopra.pokebowl.repository.IUtilisateurRoleRepository;

@SpringBootTest
public class TestJUnitCreateFakeData { 
	
	@Autowired
	IUtilisateurRepository utilisateurRepo; 
	@Autowired
	IUtilisateurRoleRepository utilisateurRoleRepo;
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
	@Autowired
	IAttaqueRepository attaqueRepo;
	@Autowired
	IPokemonMatchRepository pokemonMatchRepo;
	
	@Test
	public void CreateFakeDate() {
		
		// CREATE USERS
//		Statistique statistique1 = new Statistique("bulbizarre", 5, 18, 23); 
//		
//		Utilisateur utilisateur1 = new Utilisateur();
//		utilisateur1.setPseudo("pokemonator");
//		utilisateur1.setEmail("jean.yves@gmail.com");
//		utilisateur1.setAvatar("resources/images/avatar1.png");
//		utilisateur1.setMotDePasse("lesoleilbrille33");
//		utilisateur1.setStatistique(statistique1);
//		utilisateur1.setEnable(true);
//		utilisateur1 = utilisateurRepo.save(utilisateur1);
//		
//		UtilisateurRole u1Role = new UtilisateurRole(utilisateur1, Role.ADMIN);
//		u1Role = utilisateurRoleRepo.save(u1Role);
//		
//		Statistique statistique2 = new Statistique("salamèche", 12, 10, 22);
//		
//		Utilisateur utilisateur2 = new Utilisateur();
//		utilisateur2.setPseudo("francis");
//		utilisateur2.setEmail("francis.lalane@gmail.com");
//		utilisateur2.setAvatar("resources/images/avatar2.png");
//		utilisateur2.setMotDePasse("33hfjskIO");
//		utilisateur2.setStatistique(statistique2);
//		utilisateur2 = utilisateurRepo.save(utilisateur2);
//		
//		UtilisateurRole u2Role = new UtilisateurRole(utilisateur2, Role.USER);
//		u2Role = utilisateurRoleRepo.save(u2Role);
//		
//		Statistique statistique3 = new Statistique("chenipan", 23, 10, 33);
//		
//		Utilisateur utilisateur3 = new Utilisateur();
//		utilisateur3.setPseudo("jeanjean");
//		utilisateur3.setEmail("jean.valjean@hotmail.fr");
//		utilisateur3.setAvatar("resources/images/avatar3.png");
//		utilisateur3.setMotDePasse("lalalala");
//		utilisateur3.setStatistique(statistique3);
//		utilisateur3 = utilisateurRepo.save(utilisateur3);
//		
//		UtilisateurRole u3Role = new UtilisateurRole(utilisateur3, Role.USER);
//		u3Role = utilisateurRoleRepo.save(u3Role);
//		
//		Statistique statistique4 = new Statistique("papilusion", 34, 3, 37);
//		
//		Utilisateur utilisateur4 = new Utilisateur();
//		utilisateur4.setPseudo("mauricette");
//		utilisateur4.setEmail("mauricette.momo@hotmail.com");
//		utilisateur4.setAvatar("resources/images/avatar4.png");
//		utilisateur4.setMotDePasse("motdepasse");
//		utilisateur4.setStatistique(statistique4);
//		utilisateur4 = utilisateurRepo.save(utilisateur4);
//		
//		UtilisateurRole u4Role = new UtilisateurRole(utilisateur4, Role.GUEST);
//		u4Role = utilisateurRoleRepo.save(u4Role);
//		
//		// CREATE SALON
//		Salon salon1 = new Salon("salon 1", "sal1");
//		salon1 = salonRepo.save(salon1);
//		
//		Salon salon2 = new Salon("salon 2", "sal2");
//		salon2 = salonRepo.save(salon2);
//		
//		// CREATE COMBAT
//		Combat combat1 = new Combat(utilisateur1.getId());
//		combat1 = combatRepo.save(combat1);
//		Combat combat2 = new Combat(utilisateur2.getId());
//		combat2 = combatRepo.save(combat2);
//		Combat combat3 = new Combat(utilisateur1.getId());
//		combat3 = combatRepo.save(combat3); 
//
//		// CREATE TOUR
//		Tour tour1 =  new Tour(Action.ATTAQUER, Action.ATTAQUER, "attaque1", "attaque2");
//		tour1 = tourRepo.save(tour1);
//		Tour tour2 =  new Tour(Action.ATTAQUER, Action.CHANGER, "attaque2", "NULL");
//		tour2 = tourRepo.save(tour2);
//		Tour tour3 =  new Tour(Action.CHANGER, Action.ATTAQUER, "NULL", "attaque2");
//		tour3 = tourRepo.save(tour3);
//		Tour tour4 =  new Tour(Action.CHANGER, Action.CHANGER, "NULL", "NULL");
//		tour4 = tourRepo.save(tour4);
//		
//		// CREATE EQUIPE
//		Equipe e1User1 = new Equipe("equipe1 Pokemonator", false, 3);
//		e1User1 = equipeRepo.save(e1User1);
//		Equipe e2User1 = new Equipe("equipe2 Pokemonator", false, 3);
//		e2User1 = equipeRepo.save(e2User1);
//		Equipe e3User1 = new Equipe("equipe3 Pokemonator", true, 4);
//		e3User1 = equipeRepo.save(e3User1);
//		
//		Equipe e1User2 = new Equipe("equipe1 Francis", false, 3);
//		e1User2 = equipeRepo.save(e1User2);
//		Equipe e2User2 = new Equipe("equipe2 Francis", true, 3);
//		e2User2 = equipeRepo.save(e2User2);
		
		
		MonPokemon p1 = new MonPokemon();
		p1.setPokeReference(pokemonRepo.findById(1L).get());
		p1.setAttaque1(attaqueRepo.findById(12L).get());
		p1.setAttaque2(attaqueRepo.findById(14L).get());
		p1.setAttaque3(attaqueRepo.findById(13L).get());
		p1.setAttaque4(attaqueRepo.findById(18L).get());
		p1 = monPokemonRepo.save(p1);
		
		MonPokemon p2 = new MonPokemon();
		p2.setPokeReference(pokemonRepo.findById(12L).get());
		p2.setAttaque1(attaqueRepo.findById(19L).get());
		p2.setAttaque2(attaqueRepo.findById(20L).get());
		p2.setAttaque3(attaqueRepo.findById(21L).get());
		p2.setAttaque4(attaqueRepo.findById(22L).get());
		p2 = monPokemonRepo.save(p2);
		
		MonPokemon p5 = new MonPokemon();
		p5.setPokeReference(pokemonRepo.findById(23L).get());
		p5.setAttaque1(attaqueRepo.findById(16L).get());
		p5.setAttaque2(attaqueRepo.findById(77L).get());
		p5.setAttaque3(attaqueRepo.findById(4L).get());
		p5.setAttaque4(attaqueRepo.findById(2L).get());
		p5 = monPokemonRepo.save(p5);
		
		MonPokemon p6 = new MonPokemon();
		p6.setPokeReference(pokemonRepo.findById(34L).get());
		p6.setAttaque1(attaqueRepo.findById(89L).get());
		p6.setAttaque2(attaqueRepo.findById(26L).get());
		p6.setAttaque3(attaqueRepo.findById(41L).get());
		p6.setAttaque4(attaqueRepo.findById(52L).get());
		p6 = monPokemonRepo.save(p6);
		
		MonPokemon p3 = new MonPokemon();
		p3.setPokeReference(pokemonRepo.findById(123L).get());
		p3.setAttaque1(attaqueRepo.findById(49L).get());
		p3.setAttaque2(attaqueRepo.findById(10L).get());
		p3.setAttaque3(attaqueRepo.findById(26L).get());
		p3.setAttaque4(attaqueRepo.findById(24L).get());
		p3 = monPokemonRepo.save(p3);
		
		MonPokemon p4 = new MonPokemon();
		p4.setPokeReference(pokemonRepo.findById(90L).get());
		p4.setAttaque1(attaqueRepo.findById(49L).get());
		p4.setAttaque2(attaqueRepo.findById(50L).get());
		p4.setAttaque3(attaqueRepo.findById(26L).get());
		p4.setAttaque4(attaqueRepo.findById(23L).get());
		p4 = monPokemonRepo.save(p4);
		
		// CREATE MONPOKEMON
//		MonPokemon poke1Equipe1User1 = new MonPokemon(1, e1User1, pokemonRepo.findById(1L).get(), attaqueRepo.findById(12L).get(), 
//				attaqueRepo.findById(1L).get(), attaqueRepo.findById(54L).get(), attaqueRepo.findById(90L).get());
//		poke1Equipe1User1 = monPokemonRepo.save(poke1Equipe1User1);
//		MonPokemon poke2Equipe1User1 = new MonPokemon(1, e1User1, pokemonRepo.findById(34L).get(), attaqueRepo.findById(13L).get(), 
//				attaqueRepo.findById(83L).get(), attaqueRepo.findById(59L).get(), attaqueRepo.findById(58L).get());
//		poke2Equipe1User1 = monPokemonRepo.save(poke2Equipe1User1);
//		MonPokemon poke3Equipe1User1 = new MonPokemon(1, e1User1, pokemonRepo.findById(56L).get(), attaqueRepo.findById(52L).get(), 
//				attaqueRepo.findById(90L).get(), attaqueRepo.findById(74L).get(), attaqueRepo.findById(80L).get());
//		poke3Equipe1User1 = monPokemonRepo.save(poke3Equipe1User1);
//		
//		MonPokemon poke1Equipe1User2 = new MonPokemon(1, e1User2, pokemonRepo.findById(23L).get(), attaqueRepo.findById(52L).get(), 
//				attaqueRepo.findById(53L).get(), attaqueRepo.findById(54L).get(), attaqueRepo.findById(55L).get());
//		poke1Equipe1User2 = monPokemonRepo.save(poke1Equipe1User2);
//		MonPokemon poke2Equipe1User2 = new MonPokemon(1, e1User2, pokemonRepo.findById(69L).get(), attaqueRepo.findById(50L).get(), 
//				attaqueRepo.findById(10L).get(), attaqueRepo.findById(74L).get(), attaqueRepo.findById(19L).get());
//		poke2Equipe1User2 = monPokemonRepo.save(poke2Equipe1User2);
//		MonPokemon poke3Equipe1User2 = new MonPokemon(1, e1User2, pokemonRepo.findById(90L).get(), attaqueRepo.findById(12L).get(), 
//				attaqueRepo.findById(21L).get(), attaqueRepo.findById(22L).get(), attaqueRepo.findById(23L).get());
//		poke3Equipe1User2 = monPokemonRepo.save(poke3Equipe1User2);
		
		// CREATE POKEMON MATCH
//		PokemonMatch poke1MatchUser1 = new PokemonMatch();
//		poke1MatchUser1.setMonPokemon(poke1Equipe1User1);
//		poke1MatchUser1 = pokemonMatchRepo.save(poke1MatchUser1);
//		
//		PokemonMatch poke2MatchUser1 = new PokemonMatch();
//		poke2MatchUser1.setMonPokemon(poke2Equipe1User1);
//		poke2MatchUser1 = pokemonMatchRepo.save(poke2MatchUser1); 
//		
//		PokemonMatch poke3MatchUser1 = new PokemonMatch();
//		poke3MatchUser1.setMonPokemon(poke3Equipe1User1);
//		poke3MatchUser1 = pokemonMatchRepo.save(poke3MatchUser1);
//		
//		PokemonMatch poke1MatchUser2 = new PokemonMatch();
//		poke1MatchUser2.setMonPokemon(poke1Equipe1User1);
//		poke1MatchUser2 = pokemonMatchRepo.save(poke1MatchUser2);
//		
//		PokemonMatch poke2MatchUser2 = new PokemonMatch();
//		poke2MatchUser2.setMonPokemon(poke2Equipe1User2);
//		poke2MatchUser2 = pokemonMatchRepo.save(poke2MatchUser2);
//		
//		PokemonMatch poke3MatchUser2 = new PokemonMatch();
//		poke3MatchUser2.setMonPokemon(poke3Equipe1User2);
//		poke3MatchUser2 = pokemonMatchRepo.save(poke3MatchUser2);
		
//		// LINK EQUIPE USER
//		utilisateur1.setEquipeEnCours(e1User1);
//		e2User1.setUtilisateurEquipeSauv(utilisateur1);
//		e3User1.setUtilisateurEquipeSauv(utilisateur1);
//		e2User1 = equipeRepo.save(e2User1);
//		e3User1 = equipeRepo.save(e3User1);
//		
//		utilisateur2.setEquipeEnCours(e1User2);
//		utilisateur2.setDerniereEquipe(e2User2);
//		utilisateur2 = utilisateurRepo.save(utilisateur2); 
//		
//		// LINK USER SALON
//		salon1.setJoueur1(utilisateur1);
//		salon1.setJoueur2(utilisateur2);
//		salon1 = salonRepo.save(salon1);
//		
//		salon2.setJoueur1(utilisateur3);
//		salon2.setJoueur2(utilisateur4);
//		salon2 = salonRepo.save(salon2);
//		
//		// LINK SALON COMBAT
//		combat1.setSalon(salon1);
//		combat1 = combatRepo.save(combat1);
//		
//		combat2.setSalon(salon1);
//		combat2 = combatRepo.save(combat2);
//		
//		combat3.setSalon(salon1);
//		combat3 = combatRepo.save(combat3);
//		
//		// LINK EQUIPE COMBAT
//		combat1.setEquipe1(e1User1);
//		combat1.setEquipe2(e1User2);
//		combat1 = combatRepo.save(combat1);
//		
//		// LINK COMBAT POKEMON MATCH
//		poke1MatchUser1.setCombat(combat1);
//		poke1MatchUser1 = pokemonMatchRepo.save(poke1MatchUser1);
//		poke2MatchUser1.setCombat(combat1);
//		poke2MatchUser1 = pokemonMatchRepo.save(poke2MatchUser1);
//		poke3MatchUser1.setCombat(combat1);
//		poke3MatchUser1 = pokemonMatchRepo.save(poke3MatchUser1);
//		
//		poke1MatchUser2.setCombat(combat1);
//		poke1MatchUser2 = pokemonMatchRepo.save(poke1MatchUser2);
//		poke2MatchUser2.setCombat(combat1);
//		poke2MatchUser2 = pokemonMatchRepo.save(poke2MatchUser2);
//		poke3MatchUser2.setCombat(combat1);
//		poke3MatchUser2 = pokemonMatchRepo.save(poke3MatchUser2);
//		
//		
//		// LINK TOUR COMBAT
//		tour1.setCombat(combat1);
//		tour1 = tourRepo.save(tour1);
//		
//		tour2.setCombat(combat1);
//		tour2 = tourRepo.save(tour2);
//		
//		tour3.setCombat(combat1);
//		tour3 = tourRepo.save(tour3);
//		
//		tour4.setCombat(combat1);
//		tour4 = tourRepo.save(tour4);
//		
//		// LINK TOUR POKEMON MATCH
//		tour1.setPokemonMatch1(poke1MatchUser1);
//		tour1.setPokemonMatch2(poke1MatchUser2);
//		
//		tour1 = tourRepo.save(tour1);
		
		
		
		
		
//		Utilisateur utilisateur1 = new Utilisateur();
//		utilisateur1.setPseudo("pokemonator");  
//		utilisateur1.setEmail("jean.jojo@gmail.com");
//		utilisateur1.setAvatar("chemin/avatar");
//		utilisateur1.setMotDePasse("lesoleilbrille33");
//		
//		UtilisateurRole u1Role = new UtilisateurRole();
//		u1Role.setRole(Role.ADMIN);
//		u1Role.setUser(utilisateur1);
//		
//		utilisateur1 = utilisateurRepo.save(utilisateur1);
//		
//		Utilisateur utilisateur2 = new Utilisateur();
//		utilisateur2.setPseudo("jeanyves");
//		utilisateur2.setEmail("alexis.dupond@hotmail.fr");
//		utilisateur2.setAvatar("disqueC/image/avatar4");
//		utilisateur2.setMotDePasse("unplusdeux++");
//		
//		utilisateur2 = utilisateurRepo.save(utilisateur2);
		
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
