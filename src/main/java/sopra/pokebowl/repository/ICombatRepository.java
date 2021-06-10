package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.Combat;

public interface ICombatRepository extends JpaRepository<Combat, Long>{

}
