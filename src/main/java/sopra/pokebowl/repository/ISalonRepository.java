package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.pokebowl.model.Salon;

public interface ISalonRepository extends JpaRepository<Salon, Long> {
	@Query("select s from Salon s where s.motDePasse = :mdp")
	Salon findSalonWithMDP(@Param("mdp") String mdp);
}
