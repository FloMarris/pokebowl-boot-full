package sopra.pokebowl.testMVC;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import sopra.pokebowl.repository.IAttaqueRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TestMVCAttaque {

//	@Autowired 
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private IAttaqueRepository attaqueRepo;
//	
//	@Test
//	@WithUserDetails("admin")
//	public void attaqueGet() throws Exception {
//		mockMvc.perform(get("/attaque")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
//	}
//	
//	@Test
//	@WithUserDetails("admin")
//	public void attaquePost() throws Exception {
//		Attaque attaque = 
//	}
}
