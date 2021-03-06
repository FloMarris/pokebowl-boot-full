package sopra.pokebowl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Salon;
import sopra.pokebowl.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
		
	public Optional<Utilisateur> findByPseudoAndMotDePasse(String pseudo, String motDePasse);
	
	public Utilisateur findByPseudo(String pseudo);
	
	public Utilisateur findByEmail(String email); 
	
	@Query("select distinct u from Utilisateur u left join fetch u.equipesSauvegardees where u.id = :id ")
	public Optional<Utilisateur> findUtilisateurByIdWithEquipesSauvegardees(@Param("id") Long id);
	
	@Query("select distinct u from Utilisateur u left join fetch u.roles where u.pseudo = :pseudo")
	Optional<Utilisateur> findByIdWithRoles(@Param("pseudo") String pseudo);
}
