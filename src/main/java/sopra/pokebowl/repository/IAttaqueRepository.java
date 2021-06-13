package sopra.pokebowl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Attaque;

public interface IAttaqueRepository extends JpaRepository<Attaque, Long> {
	@Query("select distinct p.attaques from Pokemon p where p.id = :id")
	Optional<List<Attaque>> findAllAttaquesAvaibleByMonPokemonId(@Param("id") Long id);
}
