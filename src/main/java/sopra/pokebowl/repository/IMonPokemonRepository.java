package sopra.pokebowl.repository;

import sopra.pokebowl.model.MonPokemon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMonPokemonRepository extends JpaRepository<MonPokemon, Long> {
	
	@Query("select distinct m from MonPokemon m "
			+ "left join fetch m.pokeReference "
			+ "left join fetch m.attaque4 "
			+ "left join fetch m.attaque3 "
			+ "left join fetch m.attaque2 "
			+ "left join fetch m.attaque1 "
			+ "where m.equipe.id = :id")
	Optional<List<MonPokemon>> findMonPokemonWithPokemonWithEquipeId(@Param("id") Long id);
}
