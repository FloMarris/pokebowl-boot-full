package sopra.pokebowl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EnumType;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import sopra.pokebowl.service.AttaqueAPIRequest;
import sopra.pokebowl.service.PokemonAPIRequest;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.CategorieAttaque;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.ITypeClassRepository;

@SpringBootTest
public class TestJUnitAPI {
	public final Integer numberPokeToUse = 10;
	public final Integer numberAttaqueToUse = 10;
	public List<String> listPoke = new ArrayList<String>();
	public Map<String, TypeEnum> typesEnToEnum = new HashMap<String, TypeEnum>() {{
		put("fire", TypeEnum.FEU);
		put("grass", TypeEnum.PLANTE);
		put("water", TypeEnum.EAU);
		put("bug", TypeEnum.INSECTE);
		put("steel", TypeEnum.ACIER);
		put("normal", TypeEnum.NORMAL);
		put("rock", TypeEnum.ROCHE);
		put("ground", TypeEnum.SOL);
		put("dragon", TypeEnum.DRAGON);
		put("psychic", TypeEnum.PSY);
		put("dark", TypeEnum.TENEBRE);
		put("electric", TypeEnum.ELECTRIQUE);
		put("ghost", TypeEnum.SPECTRE);
		put("poison", TypeEnum.POISON);
		put("fighting", TypeEnum.COMBAT);
		put("ice", TypeEnum.GLACE);
		put("fairy", TypeEnum.FEE);
		put("flying", TypeEnum.VOL);
	}};
	
	
	@Autowired
	IPokemonRepository pokemonRepo;
	@Autowired
	IAttaqueRepository attaqueRepo;
	@Autowired
	ITypeClassRepository typeClassRepo;
	
	@Test
	public void createAllData() {
		createPokeDataBase();
		createAttaqueDataBase();
	}
	
	public void createPokeDataBase() {
			
		try {
			for(int i = 1; i <= numberPokeToUse; i++) {
				Map<String, String> pokemonInfo = PokemonAPIRequest.createInfoPokemon(i, null, listPoke);
				Pokemon pokemon = new Pokemon();
				pokemon.setNom(pokemonInfo.get(PokemonAPIRequest.nomPoke));
				pokemon.setHp(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.hpPoke)));
				pokemon.setAttaque(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.attaquePoke)));
				pokemon.setDefense(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.defensePoke)));
				pokemon.setAttaqueSpe(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.attaqueSpePoke)));
				pokemon.setDefenseSpe(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.defenseSpePoke)));
				pokemon.setSpeed(Integer.parseInt(pokemonInfo.get(PokemonAPIRequest.speedPoke)));
				pokemon.setPoids(Float.parseFloat(pokemonInfo.get(PokemonAPIRequest.poidsPoke)));
				pokemon.setTaille(Float.parseFloat(pokemonInfo.get(PokemonAPIRequest.taillePoke)));
				pokemon.setGeneration(1);
				pokemon.setAvatar(pokemonInfo.get(PokemonAPIRequest.avatarPoke));
				pokemon.setDescription(pokemonInfo.get(PokemonAPIRequest.descriptionPoke));
				pokemon.setType1( typeClassRepo.findByType(typesEnToEnum.get(pokemonInfo.get(PokemonAPIRequest.type1Poke))) ) ;
				if(pokemonInfo.get(PokemonAPIRequest.type2Poke) != null) {
					pokemon.setType2( typeClassRepo.findByType(typesEnToEnum.get(pokemonInfo.get(PokemonAPIRequest.type2Poke))) ) ;
				}
				
				pokemonRepo.save(pokemon);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createAttaqueDataBase() {
			
		try {
			for(int i = 1; i <= numberAttaqueToUse; i++) {
				Map<String, String> attaqueInfo = AttaqueAPIRequest.createAttaqueInfo(i, listPoke);
				if(!attaqueInfo.isEmpty()) {
					Attaque attaque = new Attaque();
					
					attaque.setNom(attaqueInfo.get(AttaqueAPIRequest.nomAttaque));
					
					if(attaqueInfo.get(AttaqueAPIRequest.categorieAttaque).equals("\"physical\"")) {
						attaque.setCategorie(CategorieAttaque.PHYSIQUE);
					} else if(attaqueInfo.get(AttaqueAPIRequest.categorieAttaque).equals("\"special\"")) {
						attaque.setCategorie(CategorieAttaque.SPECIAL);
					}
					else if(attaqueInfo.get(AttaqueAPIRequest.categorieAttaque).equals("\"status\"")) {
						attaque.setCategorie(CategorieAttaque.STATUT_ATTAQUE);
					}
					attaque.setPointDePouvoir(Integer.parseInt(attaqueInfo.get(AttaqueAPIRequest.pointDePouvoirAttaque)));
					
					if(attaqueInfo.get(AttaqueAPIRequest.puissanceAttaque) != null) {
						attaque.setPuissance(Integer.parseInt(attaqueInfo.get(AttaqueAPIRequest.puissanceAttaque)));
					}
					
					if(attaqueInfo.get(AttaqueAPIRequest.precisionAttaque) != null) {
						attaque.setPrecisionAttaque(Float.parseFloat(attaqueInfo.get(AttaqueAPIRequest.precisionAttaque)));
					}
					
					if(attaqueInfo.get(AttaqueAPIRequest.descriptionAttaque) != null) {
						attaque.setDescription(attaqueInfo.get(AttaqueAPIRequest.descriptionAttaque));
					}
					
					if(attaqueInfo.get(AttaqueAPIRequest.typeAttaque) != null) {
						attaque.setTypeAttaque(typeClassRepo.findByType(typesEnToEnum.get(attaqueInfo.get(AttaqueAPIRequest.typeAttaque))));
					}
					
					attaqueRepo.save(attaque);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
