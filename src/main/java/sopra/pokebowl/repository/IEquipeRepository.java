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
}
