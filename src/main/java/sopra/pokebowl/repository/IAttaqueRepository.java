package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.Attaque;

public interface IAttaqueRepository extends JpaRepository<Attaque, Long> {

}
