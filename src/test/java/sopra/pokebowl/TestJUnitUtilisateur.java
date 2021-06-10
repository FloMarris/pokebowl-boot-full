package sopra.pokebowl;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.Statistique;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IMonPokemonRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class TestJUnitUtilisateur {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	public void utilisateurCreate() {
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
		IEquipeRepository equipeRepo = context.getBean(IEquipeRepository.class);
		 
		Statistique stats = new Statistique();
		stats.setPokemonPrefere("Carapuce");
		stats.setNbrVictoires(54);
		stats.setNbrDefaites(34);
		stats.setNbrPartiesJouees(stats.getNbrDefaites() + stats.getNbrVictoires());
		
		Equipe derniereEquipe = new Equipe();
		derniereEquipe.setNom("dernière équipe");    
		derniereEquipe.setFavorite(false);
		derniereEquipe.setNbrPokemons(5); 
	
		derniereEquipe = equipeRepo.save(derniereEquipe);
		 
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo("pokemonator");
		utilisateur.setEmail("jean.jojo@gmail.com"); 
		utilisateur.setAvatar("chemin/avatar");
		utilisateur.setMotDePasse("lesoleilbrille33");
		utilisateur.setStatistique(stats); 
		utilisateur.setDerniereEquipe(derniereEquipe);
		
		utilisateur = utilisateurRepo.save(utilisateur); 
		
		Optional<Utilisateur> utilisateurFind = utilisateurRepo.findById(utilisateur.getId());
		 
		Assert.assertEquals("pokemonator", utilisateurFind.get().getPseudo());
		Assert.assertEquals("jean.jojo@gmail.com", utilisateurFind.get().getEmail());
		Assert.assertEquals("chemin/avatar", utilisateurFind.get().getAvatar());
		Assert.assertEquals("lesoleilbrille33", utilisateurFind.get().getMotDePasse());
		Assert.assertEquals("Carapuce", utilisateurFind.get().getStatistique().getPokemonPrefere());
		Assert.assertEquals((Integer)54, utilisateurFind.get().getStatistique().getNbrVictoires());
		Assert.assertEquals((Integer)34, utilisateurFind.get().getStatistique().getNbrDefaites());
		Assert.assertEquals(stats.getNbrPartiesJouees(), utilisateurFind.get().getStatistique().getNbrPartiesJouees());
		Assert.assertEquals(derniereEquipe.getId(), utilisateurFind.get().getDerniereEquipe().getId());
		
		utilisateurRepo.delete(utilisateur);
		equipeRepo.delete(derniereEquipe);
	}
	
	@Test
	public void utilisateurUpdate() {
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo("pokemonator");
		utilisateur.setEmail("jean.jojo@gmail.com");
		utilisateur.setAvatar("chemin/avatar");
		utilisateur.setMotDePasse("lesoleilbrille33");
		
		utilisateur = utilisateurRepo.save(utilisateur);
		
		utilisateur.setPseudo("jeanyves");
		utilisateur.setEmail("alexis.dupond@hotmail.fr");
		utilisateur.setAvatar("disqueC/image/avatar4");
		utilisateur.setMotDePasse("unplusdeux++");
		
		utilisateur = utilisateurRepo.save(utilisateur);
		
		Optional<Utilisateur> utilisateurFind = utilisateurRepo.findById(utilisateur.getId());
		
		Assert.assertEquals("jeanyves", utilisateurFind.get().getPseudo());
		Assert.assertEquals("alexis.dupond@hotmail.fr", utilisateurFind.get().getEmail()); 
		Assert.assertEquals("disqueC/image/avatar4", utilisateurFind.get().getAvatar());
		Assert.assertEquals("unplusdeux++", utilisateurFind.get().getMotDePasse());
		
		utilisateurRepo.delete(utilisateur);
	}
	
	@Test
	public void utilisateurFindAllAndDelete() {
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
		
		Utilisateur utilisateur1 = new Utilisateur();
		Utilisateur utilisateur2 = new Utilisateur();
		Utilisateur utilisateur3 = new Utilisateur();
		Utilisateur utilisateur4 = new Utilisateur();
		
		utilisateur1 = utilisateurRepo.save(utilisateur1);
		utilisateur2 = utilisateurRepo.save(utilisateur2);
		utilisateur3 = utilisateurRepo.save(utilisateur3);
		utilisateur4 = utilisateurRepo.save(utilisateur4);
		
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
		
		Assert.assertEquals(4, utilisateurs.size());
		
		utilisateurRepo.delete(utilisateur1);
		utilisateurRepo.delete(utilisateur2);  
		utilisateurRepo.delete(utilisateur3); 
		utilisateurRepo.delete(utilisateur4);
		
		utilisateurs = utilisateurRepo.findAll();
		
		Assert.assertEquals(0, utilisateurs.size());    
	}
	
	@Test  
	public void testFindByPseudoAndMotDePasse() {
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
		
		Utilisateur u = new Utilisateur();
		u.setPseudo("PokeMan");
		u.setMotDePasse("Pokeman1");
		
		u = utilisateurRepo.save(u);
		
		Optional<Utilisateur> result = utilisateurRepo.findByPseudoAndMotDePasse("PokeMan", "Pokeman1");
		
		Assert.assertEquals("PokeMan", result.get().getPseudo());  
		Assert.assertEquals("Pokeman1", result.get().getMotDePasse());
	
		
		utilisateurRepo.delete(u);
	}
	
	@Test
	public void utilisateurFindPseudobyPseudo() {
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
		
		Utilisateur u = new Utilisateur();
		u.setPseudo("PokeMan");
		
		u = utilisateurRepo.save(u);
		
		Utilisateur result = utilisateurRepo.findByPseudo(u.getPseudo());
		
		Assert.assertEquals("PokeMan", result.getPseudo());  
		
		utilisateurRepo.delete(u);
	}
	
	@Test
	public void utilisateurfindEmailbyUtilisateur() {
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
		
		Utilisateur u = new Utilisateur();
		u.setPseudo("PokeMan");
		u.setEmail("pokeman@gmail.com");
		
		u = utilisateurRepo.save(u);
		
		Utilisateur result = utilisateurRepo.findByEmail(u.getEmail());
		
		Assert.assertEquals("pokeman@gmail.com", result.getEmail());  
		
		utilisateurRepo.delete(u);
	} 
}
