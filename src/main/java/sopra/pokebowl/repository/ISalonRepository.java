package sopra.pokebowl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Salon;
import sopra.pokebowl.model.Utilisateur;

public interface ISalonRepository extends JpaRepository<Salon, Long> {
	@Query("select s from Salon s where s.motDePasse = :mdp")
	Salon findSalonWithMDP(@Param("mdp") String mdp);
	
	@Query("select distinct s from Salon s "
			+ "left join fetch s.joueur1 j1 "
			+ "left join fetch j1.equipeEnCours e "
			+ "left join fetch e.listPokemons mp "
			+ "left join fetch mp.pokeReference "
			+ "where s.id = :id"  )
	public Optional<Salon> findSalonByIdWithJoueur1EquipeEnCoursMonPokemonAndPokemon(@Param("id") Long id);
	
	@Query("select distinct s from Salon s "
			+ "left join fetch s.joueur2 j2 "
			+ "left join fetch j2.equipeEnCours e "
			+ "left join fetch e.listPokemons mp "
			+ "left join fetch mp.pokeReference "
			+ "where s.id = :id"  )
	public Optional<Salon> findSalonByIdWithJoueur2EquipeEnCoursMonPokemonAndPokemon(@Param("id") Long id);
	
}
