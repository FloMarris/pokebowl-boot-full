package sopra.pokebowl.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonAPIRequest {
	public static final String nomPoke = "nomPoke";
	public static final String nomPokeEN = "nomPokeEN";
	public static final String hpPoke = "hpPoke";
	public static final String attaquePoke = "attaquePoke";
	public static final String defensePoke = "defensePoke";
	public static final String attaqueSpePoke = "attaqueSpePoke";
	public static final String defenseSpePoke = "defenseSpePoke";
	public static final String speedPoke = "speedPoke";
	public static final String poidsPoke = "poidsPoke";
	public static final String taillePoke = "taillePoke";
	public static final String generationPoke = "generationPoke";
	public static final String avatarPoke = "avatarPoke";
	public static final String descriptionPoke = "descriptionPoke";
	public static final String type1Poke = "type1Poke";
	public static final String type2Poke = "type2Poke";
	public static final String id = "id";
	
	public static Map<String, String> createInfoPokemon(int i, String name, Map<String, String> listPoke) throws IOException {
		Map<String, String> pokeInfo = new HashMap<String, String>();

		// Get Pokemon by name or id
		String path;
		if (i != -1) {
			path = "https://pokeapi.co/api/v2/pokemon/" + i;
		} else {
			path = "https://pokeapi.co/api/v2/pokemon/" + name;
		}
		
		String path2;
		if(i != -1) {
			path2 = "https://pokeapi.co/api/v2/pokemon-species/" + i;
		} else {
			path2 = "https://pokeapi.co/api/v2/pokemon-species/" + name;
		}

		// Create a neat value object to hold the URavatL
		URL url = new URL(path);
		URL url2 = new URL(path2);

		// Open a connection(?) on the URL(??) and cast the response(???)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");
		connection2.setRequestProperty("accept", "application/json");

		// This line makes the request
		InputStream responseStream = connection.getInputStream();
		InputStream responseStream2 = connection2.getInputStream();

		// Manually converting the response body InputStream to APOD using Jackson
		ObjectMapper mapper = new ObjectMapper();
		ObjectMapper mapper2 = new ObjectMapper();
		JsonPokemon pokemon = mapper.readValue(responseStream, JsonPokemon.class);
		JSonPokemonSpecies pokemon2 = mapper2.readValue(responseStream2, JSonPokemonSpecies.class);

		// Get Pokemon Id
		pokeInfo.put(id, String.valueOf(pokemon.id));
		
		
		
		// Get Pokemon name (fr)
		for(JsonNode j : pokemon2.names) {
			if((String.valueOf(j.get("language").get("name"))).equals("\"fr\"")) {
				StringBuilder nameBuilder = new StringBuilder(String.valueOf(j.get("name")));
				nameBuilder.deleteCharAt(0);
				nameBuilder.deleteCharAt(nameBuilder.length() - 1);
				pokeInfo.put(nomPoke, nameBuilder.toString());
				
				// Get Pokemon name (en) --> pour faire les liens attaques et pokemons
				listPoke.put(pokemon.name, nameBuilder.toString());
				
				break;
			}
		}
		
		// Get Pokemon stats
		String[] stats = {hpPoke, attaquePoke, defensePoke, attaqueSpePoke, defenseSpePoke, speedPoke};
		for (int j = 0; j < pokemon.stats.size(); j++) {
			JsonNode stat = pokemon.stats.get(j);
			pokeInfo.put(stats[j], String.valueOf(stat.get("base_stat")));
		}

		// Get Pokemon weight
		Float pokemonWeight = Float.parseFloat(pokemon.weight) / 10.0f;
		pokeInfo.put(poidsPoke, String.valueOf(pokemonWeight));

		// Get Pokemon height
		Float pokemonHeight = Float.parseFloat(pokemon.height) / 10.0f;
		pokeInfo.put(taillePoke, String.valueOf(pokemonHeight));

		// Get Pokemon types
		String[] typesString = {type1Poke, type2Poke};
		int count = 0;
		for (int j = 0; j <= pokemon.types.size() - 1; j++) {
			JsonNode types = pokemon.types.get(j);
			JsonNode type = types.get("type");
			pokeInfo.put(typesString[j], String.valueOf(type.get("name")).replace("\"", ""));
			count++;
		}

		if (count != 2) {
			pokeInfo.put(typesString[1], null);
		}

		// Get Pokemon avatar
		pokeInfo.put(avatarPoke, (String.valueOf(pokemon.sprites.get("front_default"))).replace("\"", ""));
		
		
		//Get Poekmon description
		for(int j=pokemon2.flavor_text_entries.size()-1; j>=0; j--) {
			if(String.valueOf(pokemon2.flavor_text_entries.get(j).get("language").get("name")).equals("\"fr\"")) {
				pokeInfo.put(descriptionPoke, (String.valueOf(pokemon2.flavor_text_entries.get(j).get("flavor_text")).replace("\\n", " ")).replace("\"", ""));
				break;
			}
		}
		
		return pokeInfo;
	}
}
