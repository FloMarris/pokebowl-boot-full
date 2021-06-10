package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.Tour;

public interface ITourRepository extends JpaRepository<Tour, Long>{

}
