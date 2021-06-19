package sopra.pokebowl.testMVC;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.CategorieAttaque;
import sopra.pokebowl.repository.IAttaqueRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TestMVCAttaque {

	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private IAttaqueRepository attaqueRepo;
	 
	@Test
	@WithUserDetails("pokemonator")
	public void attaqueGet() throws Exception {
		mockMvc.perform(get("/attaque")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	} 
	
	@Test
	@WithUserDetails("pokemonator")
	public void attaqueGetById() throws Exception {
		List<Attaque> attaques = attaqueRepo.findAll();
		
		if(attaques.size() != 0) {
			Long id = attaques.get(0).getId();
			mockMvc.perform(get("/attaque/" + id)).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} 
	}
	
	@Test
	@WithUserDetails("pokemonator")
	public void attaquePost() throws Exception {
		Attaque attaque = new Attaque(1111L, "attaque 1", CategorieAttaque.PHYSIQUE, 12, 34, 0.9f, "grosse attaque");
	
		ObjectMapper mapper = new ObjectMapper();
		String jsonAttaque = mapper.writeValueAsString(attaque);
		
		mockMvc.perform(post("/attaque").contentType(MediaType.APPLICATION_JSON).content(jsonAttaque))
		.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(notNullValue())))
		.andExpect(jsonPath("$.version").value(0)).andExpect(jsonPath("$.description").value("grosse attaque"));
	}
}
