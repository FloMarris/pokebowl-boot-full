package sopra.pokebowl.testRepo;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.pokebowl.model.Equipe;
import sopra.pokebowl.model.Statistique;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.IEquipeRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

@SpringBootTest
public class TestJUnitUtilisateur {
	
	@Autowired
	IUtilisateurRepository utilisateurRepo;
	@Autowired
	IEquipeRepository equipeRepo;

	@Test
	public void utilisateurCreate() {
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
		 
		assertEquals("pokemonator", utilisateurFind.get().getPseudo());
		assertEquals("jean.jojo@gmail.com", utilisateurFind.get().getEmail());
		assertEquals("chemin/avatar", utilisateurFind.get().getAvatar());
		assertEquals("lesoleilbrille33", utilisateurFind.get().getMotDePasse());
		assertEquals("Carapuce", utilisateurFind.get().getStatistique().getPokemonPrefere());
		assertEquals((Integer)54, utilisateurFind.get().getStatistique().getNbrVictoires());
		assertEquals((Integer)34, utilisateurFind.get().getStatistique().getNbrDefaites());
		assertEquals(stats.getNbrPartiesJouees(), utilisateurFind.get().getStatistique().getNbrPartiesJouees());
		assertEquals(derniereEquipe.getId(), utilisateurFind.get().getDerniereEquipe().getId());
		
		utilisateurRepo.delete(utilisateur);
		equipeRepo.delete(derniereEquipe);
	}
	
	@Test
	public void utilisateurUpdate() {
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
		
		assertEquals("jeanyves", utilisateurFind.get().getPseudo());
		assertEquals("alexis.dupond@hotmail.fr", utilisateurFind.get().getEmail()); 
		assertEquals("disqueC/image/avatar4", utilisateurFind.get().getAvatar());
		assertEquals("unplusdeux++", utilisateurFind.get().getMotDePasse());
		
		utilisateurRepo.delete(utilisateur);
	}
	
	@Test
	public void utilisateurFindAllAndDelete() {		
		int listSize = utilisateurRepo.findAll().size();
		
		Utilisateur utilisateur1 = new Utilisateur();
		Utilisateur utilisateur2 = new Utilisateur();
		Utilisateur utilisateur3 = new Utilisateur();
		Utilisateur utilisateur4 = new Utilisateur();
		
		utilisateur1 = utilisateurRepo.save(utilisateur1);
		utilisateur2 = utilisateurRepo.save(utilisateur2);
		utilisateur3 = utilisateurRepo.save(utilisateur3);
		utilisateur4 = utilisateurRepo.save(utilisateur4);
		
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
		
		assertEquals(listSize + 4, utilisateurs.size());
		
		utilisateurRepo.delete(utilisateur1);
		utilisateurRepo.delete(utilisateur2);  
		utilisateurRepo.delete(utilisateur3); 
		utilisateurRepo.delete(utilisateur4);
		
		utilisateurs = utilisateurRepo.findAll();
		
		assertEquals(listSize, utilisateurs.size());    
	}
	
	@Test  
	public void testFindByPseudoAndMotDePasse() {
		Utilisateur u = new Utilisateur();
		u.setPseudo("PokeMan");
		u.setMotDePasse("Pokeman1");
		
		u = utilisateurRepo.save(u);
		
		Optional<Utilisateur> result = utilisateurRepo.findByPseudoAndMotDePasse("PokeMan", "Pokeman1");
		
		assertEquals("PokeMan", result.get().getPseudo());  
		assertEquals("Pokeman1", result.get().getMotDePasse());
	
		utilisateurRepo.delete(u);
	}
	
	@Test
	public void utilisateurFindPseudobyPseudo() {
		Utilisateur u = new Utilisateur();
		u.setPseudo("PokeMan");
		
		u = utilisateurRepo.save(u);
		
		Utilisateur result = utilisateurRepo.findByPseudo(u.getPseudo());
		
		assertEquals("PokeMan", result.getPseudo());  
		
		utilisateurRepo.delete(u);
	}
	
	@Test
	public void utilisateurfindEmailbyUtilisateur() {		
		Utilisateur u = new Utilisateur();
		u.setPseudo("PokeMan");
		u.setEmail("pokeman@gmail.com");
		
		u = utilisateurRepo.save(u);
		
		Utilisateur result = utilisateurRepo.findByEmail(u.getEmail());
		
		assertEquals("pokeman@gmail.com", result.getEmail());  
		
		utilisateurRepo.delete(u);
	} 
}
