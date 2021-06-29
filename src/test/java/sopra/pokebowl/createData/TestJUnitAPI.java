package sopra.pokebowl.createData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import sopra.pokebowl.service.AttaqueAPIRequest;
import sopra.pokebowl.service.PokemonAPIRequest;
import sopra.pokebowl.model.Attaque;
import sopra.pokebowl.model.CategorieAttaque;
import sopra.pokebowl.model.Pokemon;
import sopra.pokebowl.model.TypeClass;
import sopra.pokebowl.model.TypeEnum;
import sopra.pokebowl.repository.IAttaqueRepository;
import sopra.pokebowl.repository.IPokemonRepository;
import sopra.pokebowl.repository.ITypeClassRepository;

@SpringBootTest
public class TestJUnitAPI {
	public final Integer numberPokeToUse = 151;
	public final Integer numberAttaqueToUse = 165;
	public Map<String, String> listPoke = new HashMap<String, String>();
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
	public String[] avatarType = new String[] {
			"https://www.pokepedia.fr/images/f/fc/Miniature_Type_Feu_EB.png",
			"https://www.pokepedia.fr/images/3/35/Miniature_Type_Plante_EB.png",
			"https://www.pokepedia.fr/images/4/4c/Miniature_Type_Eau_EB.png",
			"https://www.pokepedia.fr/images/e/ee/Miniature_Type_Insecte_EB.png",
			"https://www.pokepedia.fr/images/b/b9/Miniature_Type_Acier_EB.png",
			"https://www.pokepedia.fr/images/2/2e/Miniature_Type_Normal_EB.png",
			"https://www.pokepedia.fr/images/d/d3/Miniature_Type_Roche_EB.png",
			"https://www.pokepedia.fr/images/d/d6/Miniature_Type_Sol_EB.png",
			"https://www.pokepedia.fr/images/2/23/Miniature_Type_Dragon_EB.png",
			"https://www.pokepedia.fr/images/d/da/Miniature_Type_Psy_EB.png",
			"https://www.pokepedia.fr/images/f/f4/Miniature_Type_T%C3%A9n%C3%A8bres_EB.png",
			"https://www.pokepedia.fr/images/6/6c/Miniature_Type_%C3%89lectrik_EB.png",
			"https://www.pokepedia.fr/images/e/e5/Miniature_Type_Spectre_EB.png",
			"https://www.pokepedia.fr/images/2/28/Miniature_Type_Poison_EB.png",
			"https://www.pokepedia.fr/images/1/1c/Miniature_Type_Combat_EB.png",
			"https://www.pokepedia.fr/images/7/7e/Miniature_Type_Glace_EB.png",
			"https://www.pokepedia.fr/images/3/3e/Miniature_Type_F%C3%A9e_EB.png",
			"https://www.pokepedia.fr/images/6/62/Miniature_Type_Vol_EB.png"
	};
	
	
	@Autowired
	IPokemonRepository pokemonRepo;
	@Autowired
	IAttaqueRepository attaqueRepo;
	@Autowired
	ITypeClassRepository typeClassRepo;
	
	@Test
	public void createAllData() {
//		for(TypeEnum t : TypeEnum.values()) {
//			TypeClass type = new TypeClass();
//			type.setType(t);
//			type.setAvatar("");
//			type = typeClassRepo.save(type);
//		}
		for(int i=0; i<18; i++) {
			TypeClass type = typeClassRepo.findById(Long.valueOf(i+1)).get();
			type.setAvatar(avatarType[i]);
			type = typeClassRepo.save(type);
		}
//		createPokeDataBase();
//		createAttaqueDataBase(); 
	}
	
	public void createPokeDataBase() {
			
		try {
			for(int i = 1; i <= numberPokeToUse; i++) {
				Map<String, String> pokemonInfo = PokemonAPIRequest.createInfoPokemon(i, null, listPoke);
				Pokemon pokemon = new Pokemon();
				pokemon.setId(Long.parseLong(pokemonInfo.get(PokemonAPIRequest.id)));
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
					
					attaque.setId(Long.parseLong(attaqueInfo.get(AttaqueAPIRequest.id)));
					
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
					
					String pokemonsAttaque = attaqueInfo.get(AttaqueAPIRequest.pokemonAttaque);
					List<String> convertedPokemonsAttaque = Arrays.asList(pokemonsAttaque.split(",",-1));
					
					for(String s : convertedPokemonsAttaque) {
						if(listPoke.containsKey(s)) {
							Pokemon pokemon = pokemonRepo.findPokemonByNom(listPoke.get(s));
							
							pokemon.getAttaques().add(attaque);
							pokemon = pokemonRepo.save(pokemon);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
