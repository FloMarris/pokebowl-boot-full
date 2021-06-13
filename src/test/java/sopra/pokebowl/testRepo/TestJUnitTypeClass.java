package sopra.pokebowl.testRepo;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.repository.ITypeClassRepository;

@SpringBootTest
public class TestJUnitTypeClass {
	
	@Autowired
	ITypeClassRepository typeClassRepo;
	
	@Test
	public void typeClassFindAllAndDelete() {
		int listSize = typeClassRepo.findAll().size(); 
		
		TypeClass t1 = new TypeClass(); 
		TypeClass t2 = new TypeClass();
		
		t1 = typeClassRepo.save(t1);
		t2 = typeClassRepo.save(t2);
		 
		List<TypeClass> list = typeClassRepo.findAll();
		
		assertEquals(listSize + 2, list.size());
		
		typeClassRepo.delete(t1);
		typeClassRepo.delete(t2);
		
		list = typeClassRepo.findAll();
		
		assertEquals(listSize, list.size());
		
	}
	
	@Test
	public void typeClassFindById() {		
		TypeClass t1 = new TypeClass();
		t1.setType(TypeEnum.ACIER);
		t1.setAvatar("http://Acier");
		t1 = typeClassRepo.save(t1);
		
		Optional<TypeClass> t2 = typeClassRepo.findById(t1.getId());
		
		assertEquals("http://Acier", t2.get().getAvatar());
		assertEquals(TypeEnum.ACIER, t2.get().getType());
		
		typeClassRepo.delete(t1);
	}
	
	@Test
	public void typeClassCreate() {		
		TypeClass t1 = new TypeClass(TypeEnum.COMBAT, "http://Combat");

		t1 = typeClassRepo.save(t1);
	
		assertEquals(TypeEnum.COMBAT, t1.getType());
		assertEquals("http://Combat", t1.getAvatar());
		
		typeClassRepo.delete(t1);
	}
	
	@Test
	public void typeClassUpdate() {		
		TypeClass t = new TypeClass();
		t.setType(TypeEnum.DRAGON);
		t.setAvatar("http://Dragon");
		
		t = typeClassRepo.save(t);
		
		t.setAvatar("http://DragonNew");
		
		t = typeClassRepo.save(t);
		
		Optional<TypeClass> tFind = typeClassRepo.findById(t.getId());
		
		assertEquals(TypeEnum.DRAGON, tFind.get().getType());
		assertEquals("http://DragonNew", tFind.get().getAvatar());
	
		typeClassRepo.delete(t); 
	}

}
