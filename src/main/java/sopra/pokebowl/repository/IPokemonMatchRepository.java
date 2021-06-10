package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.PokemonMatch;

public interface IPokemonMatchRepository extends JpaRepository<PokemonMatch, Integer>{

}
