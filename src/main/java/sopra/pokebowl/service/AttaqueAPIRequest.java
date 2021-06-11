package sopra.pokebowl.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AttaqueAPIRequest {
	public static final String nomAttaque = "nomAttaque";
	public static final String categorieAttaque = "categorieAttaque";
	public static final String pointDePouvoirAttaque = "pointDePouvoirAttaque";
	public static final String puissanceAttaque = "puissanceAttaque";
	public static final String precisionAttaque = "precisionAttaque";
	public static final String descriptionAttaque = "descriptionAttaque";
	public static final String typeAttaque = "typeAttaque";
	public static final String pokemonAttaque = "pokemonAttaque";
	
	@SuppressWarnings("unlikely-arg-type")
	public static Map<String, String> createAttaqueInfo(Integer i, Map<String, String> listPoke) throws IOException {
		Map<String, String> attaqueInfo = new HashMap<String, String>();
		
		String path = "https://pokeapi.co/api/v2/move/" + i;

		// Create a neat value object to hold the URL
		URL url = new URL(path);

		// Open a connection(?) on the URL(??) and cast the response(???)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");

		// This line makes the request
		InputStream responseStream = connection.getInputStream();

		// Manually converting the response body InputStream to APOD using Jackson
		ObjectMapper mapper = new ObjectMapper();
		JsonAttaque attaque = mapper.readValue(responseStream, JsonAttaque.class);

		// TODO
		// récupérer que les attaques avec un power > 0
		if (String.valueOf(attaque.generation.get("name")).equals("\"generation-i\"")) {

			// Get id
			attaqueInfo.put("id", attaque.id);

			// Get name
			for(JsonNode j : attaque.names) {
				if(String.valueOf(j.get("language").get("name")).equals("\"fr\"")) {
					StringBuilder name = new StringBuilder(String.valueOf(j.get("name")));
					name.deleteCharAt(0);
					name.deleteCharAt(name.length() - 1);
					attaqueInfo.put(nomAttaque, name.toString());
					break;
				}
			}
			
			// Get Damage Class (catégorie attaque)
			attaqueInfo.put(categorieAttaque, String.valueOf(attaque.damage_class.get("name")));

			// Get PP
			attaqueInfo.put(pointDePouvoirAttaque, attaque.pp);

			// Get Power
			attaqueInfo.put(puissanceAttaque, attaque.power);

			// Get Accuracy
			attaqueInfo.put(precisionAttaque, attaque.accuracy);

			// récupérer le type
			attaqueInfo.put(typeAttaque, String.valueOf(attaque.type.get("name")));

			// Get Pokemons who can used Move			
			StringBuilder pokemonMove = new StringBuilder();
			for (int j = 0; j < attaque.learned_by_pokemon.size(); j++) {
				JsonNode pokemon = attaque.learned_by_pokemon.get(j);
				
				StringBuilder pokemonName = new StringBuilder(String.valueOf(pokemon.get("name")));
				pokemonName.deleteCharAt(0);
				pokemonName.deleteCharAt(pokemonName.length() - 1);
				
				if (listPoke.containsKey(pokemonName.toString())) {
					pokemonMove.append(pokemonName.toString() + ",");
				}
			}

			attaqueInfo.put(pokemonAttaque, String.valueOf(pokemonMove));
			
			//Get Description
			for(JsonNode j : attaque.flavor_text_entries) {
				if(String.valueOf(j.get("language").get("name")).equals("\"fr\"")) {
					StringBuilder description = new StringBuilder((String.valueOf(j.get("flavor_text"))).replace("\\n", " "));
					description.deleteCharAt(0);
					description.deleteCharAt(description.length() - 1);
					attaqueInfo.put(descriptionAttaque, description.toString());
					break;
				}
				
			}
		}

		return attaqueInfo;
	}
}
