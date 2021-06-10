package sopra.pokebowl;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;
import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.repository.ITypeClassRepository;

public class TestJUnitTypeClass {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	public void typeClassFindAllAndDelete() {
		ITypeClassRepository typeClassRepo = context.getBean(ITypeClassRepository.class);
		
		TypeClass t1 = new TypeClass();
		TypeClass t2 = new TypeClass();
		
		t1 = typeClassRepo.save(t1);
		t2 = typeClassRepo.save(t2);
		
		List<TypeClass> list = typeClassRepo.findAll();
		
		Assert.assertEquals(2, list.size());
		
		typeClassRepo.delete(t1);
		typeClassRepo.delete(t2);
		
		list = typeClassRepo.findAll();
		
		Assert.assertEquals(0, list.size());
		
	}
	
	@Test
	public void typeClassFindById() {
		ITypeClassRepository typeClassRepo = context.getBean(ITypeClassRepository.class);
		
		TypeClass t1 = new TypeClass();
		t1.setType(TypeEnum.ACIER);
		t1.setAvatar("http://Acier");
		t1 = typeClassRepo.save(t1);
		
		Optional<TypeClass> t2 = typeClassRepo.findById(t1.getId());
		
		Assert.assertEquals("http://Acier", t2.get().getAvatar());
		Assert.assertEquals(TypeEnum.ACIER, t2.get().getType());
		
		typeClassRepo.delete(t1);
	}
	
	@Test
	public void typeClassCreate() {
		ITypeClassRepository typeClassRepo = context.getBean(ITypeClassRepository.class);
		
		TypeClass t1 = new TypeClass(TypeEnum.COMBAT, "http://Combat");

		t1 = typeClassRepo.save(t1);
	
		Assert.assertEquals(TypeEnum.COMBAT, t1.getType());
		Assert.assertEquals("http://Combat", t1.getAvatar());
		
		typeClassRepo.delete(t1);
	}
	
	@Test
	public void typeClassUpdate() {
		ITypeClassRepository typeClassRepo = context.getBean(ITypeClassRepository.class);
		
		TypeClass t = new TypeClass();
		t.setType(TypeEnum.DRAGON);
		t.setAvatar("http://Dragon");
		
		t = typeClassRepo.save(t);
		
		t.setAvatar("http://DragonNew");
		
		t = typeClassRepo.save(t);
		
		Optional<TypeClass> tFind = typeClassRepo.findById(t.getId());
		
		Assert.assertEquals(TypeEnum.DRAGON, tFind.get().getType());
		Assert.assertEquals("http://DragonNew", tFind.get().getAvatar());
	
		typeClassRepo.delete(t); 
	}

}
