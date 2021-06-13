package sopra.pokebowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;

public interface ITypeClassRepository extends JpaRepository<TypeClass, Long>{
	
	public TypeClass findByType(TypeEnum type);

}
