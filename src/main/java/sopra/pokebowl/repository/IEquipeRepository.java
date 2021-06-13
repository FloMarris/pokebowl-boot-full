package sopra.pokebowl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Equipe;

public interface IEquipeRepository extends JpaRepository<Equipe, Long> {
	
	@Query("select distinct e from Equipe e left join fetch e.listPokemons lp left join fetch lp.pokeReference p where e.utilisateurEquipeSauv.id = :idutil")
	Optional<List<Equipe>> findEquipesByUtilisateurId(@Param("idutil") Long id);
	
	@Query("select distinct e from Equipe e left join fetch e.listPokemons lp left join fetch lp.pokeReference p where e.utilisateurDerniereEquipe.id = :idutil")
	Optional<Equipe> findEquipePrecedenteByUtilisateurId(@Param("idutil") Long id);
	
	@Query("select distinct e from Equipe e left join fetch e.listPokemons lp left join fetch lp.pokeReference p where e.utilisateurEquipeEnCours.id = :idutil")
	Optional<Equipe> findEquipeEnCoursByUtilisateurId(@Param("idutil") Long id);

	@Query("select distinct e from Equipe e "
			+ "left join fetch e.listPokemons lp "
			+ "left join fetch lp.pokeReference p "
			+ "left join fetch lp.attaque1 "
			+ "left join fetch lp.attaque2 "
			+ "left join fetch lp.attaque3 "
			+ "left join fetch lp.attaque4 "
			+ "where e.id =:id ")
	Optional<Equipe> findEquipeByIdWithMonPokePokemonAndAllAttaque(@Param("id") Long id);
}
