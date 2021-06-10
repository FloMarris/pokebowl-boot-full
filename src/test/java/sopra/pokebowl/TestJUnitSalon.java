package sopra.pokebowl;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.Salon;
import sopra.pokebowl.model.Utilisateur;
import sopra.pokebowl.repository.ISalonRepository;
import sopra.pokebowl.repository.IUtilisateurRepository;

public class TestJUnitSalon {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	public void salonCreate() {
		
		ISalonRepository salonRepo = context.getBean(ISalonRepository.class);   
		IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class); 
		 
		Utilisateur joueur1 = new Utilisateur(); 
		Utilisateur joueur2 = new Utilisateur();
		joueur1 = utilisateurRepo.save(joueur1); 
		joueur2 = utilisateurRepo.save(joueur2);    
		
		Salon salon = new Salon();
		salon.setNom("salon des bg");
		salon.setMotDePasse("32785654");
		salon.setJoueur1(joueur1);
		salon.setJoueur2(joueur2);   
		
		salon = salonRepo.save(salon);
	
		Optional<Salon> salonFind = salonRepo.findById(salon.getId());
		
		Assert.assertEquals("salon des bg", salonFind.get().getNom());
		Assert.assertEquals("32785654", salonFind.get().getMotDePasse());
		Assert.assertEquals(joueur1.getId(), salonFind.get().getJoueur1().getId());   
		Assert.assertEquals(joueur2.getId(), salonFind.get().getJoueur2().getId());
		
		salonRepo.delete(salon);
		utilisateurRepo.delete(joueur1);
		utilisateurRepo.delete(joueur2);
	}
	 
	@Test
	public void salonUpdate() {
		ISalonRepository salonRepo = context.getBean(ISalonRepository.class);
		
		Salon salon = new Salon();
		salon.setNom("salon des bg");
		salon.setMotDePasse("32785654");
		
		salon = salonRepo.save(salon);
		
		salon.setNom("salon numéro 3");
		salon.setMotDePasse("998765411");
		
		salon = salonRepo.save(salon);
		
		Optional<Salon> salonFind = salonRepo.findById(salon.getId());
		
		Assert.assertEquals("salon numéro 3", salonFind.get().getNom());
		Assert.assertEquals("998765411", salonFind.get().getMotDePasse());
		
		salonRepo.delete(salon);
	}   
	
	@Test
	public void salonFindAllAndDelete() {
		ISalonRepository salonRepo = context.getBean(ISalonRepository.class);
		
		Salon salon1 = new Salon(); 
		Salon salon2 = new Salon();
		Salon salon3 = new Salon();
		Salon salon4 = new Salon();
		
		salon1 = salonRepo.save(salon1);
		salon2 = salonRepo.save(salon2);
		salon3 = salonRepo.save(salon3);
		salon4 = salonRepo.save(salon4);
		
		List<Salon> salons = salonRepo.findAll();
		
		Assert.assertEquals(4, salons.size());
		
		salonRepo.delete(salon1);
		salonRepo.delete(salon2);
		salonRepo.delete(salon3);
		salonRepo.delete(salon4);
		
		salons = salonRepo.findAll();
		
		Assert.assertEquals(0, salons.size());
	}
	
	@Test
	public void salonFindSalonWithMDP() {
		ISalonRepository salonRepo = context.getBean(ISalonRepository.class);
		
		Salon s1 = new Salon();
		s1.setNom("salon 1");
		s1.setMotDePasse("lesoleildusud3344");
		s1 = salonRepo.save(s1);
		
		Salon s2 = new Salon();
		s2.setNom("salon 2");
		s2.setMotDePasse("56738273UVGHSGwvxf232");
		s2 = salonRepo.save(s2);
		
		Salon s3 = new Salon();
		s3.setNom("salon 3");
		s3.setMotDePasse("15031995turlututu");
		s3 = salonRepo.save(s3);
		
		Salon salonFind = salonRepo.findSalonWithMDP("56738273UVGHSGwvxf232");
		
		Assert.assertEquals(s2.getId(), salonFind.getId());
		
		salonRepo.delete(s1);
		salonRepo.delete(s2);
		salonRepo.delete(s3); 
	}
}
