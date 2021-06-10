package sopra.pokebowl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.MonPokemon;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.TypeEnum;

public interface IPokemonRepository extends JpaRepository<Pokemon, Long> {
	
//	@Query("select p.avatar from Pokemon p where p.nom = :nom")
//	String findAvatarWithNom(@Param("nom") String nom);
	
	@Query("select p from Utilisateur u join u.derniereEquipe.listPokemons p where u.id = :id")
	List<MonPokemon> findPokemonsEquipePrecedenteUtilisateur(@Param("id") Long id);
	
	@Query("select p from Pokemon p WHERE p.type1.type = :type1 AND p.type2.type = :type2")
	List<Pokemon> findAllPokemonByType(@Param("type1") TypeEnum type1, @Param("type2") TypeEnum type2);
	
	@Query("select p from Pokemon p WHERE p.nom LIKE CONCAT(:recherche,'%')")
	List<Pokemon> findAllPokemonByString(@Param("recherche") String recherche);
	
	@Query("select a from Attaque a inner join a.pokemons pa where pa.id = :idpoke")
	List<Attaque> findAllAttaquesPokemonById(@Param("idpoke")Long id);
	

}
