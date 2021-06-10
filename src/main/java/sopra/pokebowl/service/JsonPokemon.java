package sopra.pokebowl.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonPokemon {
    public final List<Object> abilities;
    public final String base_experience;
    public final List<Object> forms;
    public final List<Object> game_indices;
    public final String height;
    public final List<Object> held_items;
    public final String id;
    public final String is_default;
    public final String location_area_encounters;
    public final List<Object> moves;
    public final String name;
    public final String order;
    public final List<Object> past_types;
    public final JsonNode species;
    public final JsonNode sprites;
    public final List<Object> stats;
    public final List<Object> types;
    public final String weight;

    public JsonPokemon(@JsonProperty("abilities") List<Object> abilities,
                @JsonProperty("base_experience") String base_experience,
                @JsonProperty("forms") List<Object> forms,
                @JsonProperty("game_indices") List<Object> game_indices,
                @JsonProperty("height") String height,
                @JsonProperty("held_items") List<Object> held_items,
                @JsonProperty("id") String id,
                @JsonProperty("is_default") String is_default,
    			@JsonProperty("location_area_encounters") String location_area_encounters,
    			@JsonProperty("moves") List<Object> moves, 
    			@JsonProperty("name") String name, 
				@JsonProperty("order") String order,   
				@JsonProperty("past_types") List<Object> past_types, 
				@JsonProperty("species") JsonNode species, 
				@JsonProperty("sprites") JsonNode sprites, 
				@JsonProperty("stats") List<Object> stats, 
				@JsonProperty("types") List<Object> types, 
				@JsonProperty("weight") String weight) {
        this.abilities = abilities;
        this.base_experience = base_experience;
        this.forms = forms;
        this.game_indices = game_indices;
        this.height = height;
        this.held_items = held_items;
        this.id = id;
        this.is_default = is_default;
        this.location_area_encounters  = location_area_encounters;
        this.moves = moves;
        this.name = name;
        this.order = order;
        this.past_types = past_types;
        this.species = species;
        this.sprites = sprites;
        this.stats = stats;
        this.types = types;
        this.weight = weight;
    }
}
