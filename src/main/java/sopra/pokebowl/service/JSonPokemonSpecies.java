package sopra.pokebowl.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class JSonPokemonSpecies {
    public final String id;
    public final String name;
    public final String order;
    public final String gender_rate;
    public final String capture_rate;
    public final String base_happiness;
    public final String is_baby;
    public final String is_legendary;
    public final String is_mythical;
    public final String hatch_counter;
    public final String has_gender_differences;
    public final String forms_switchable;
    public final JsonNode growth_rate;
    public final List<JsonNode> pokedex_numbers;
    public final List<JsonNode> egg_groups;
    public final JsonNode color;
    public final JsonNode shape;
    public final JsonNode evolves_from_species;
    public final JsonNode evolution_chain;
    public final JsonNode habitat;
    public final JsonNode generation;
    public final List<JsonNode> names;
    public final List<JsonNode> pal_park_encounters;
    public final List<JsonNode> flavor_text_entries;
    public final List<JsonNode> form_descriptions;
    public final List<JsonNode> genera;
    public final List<JsonNode> varieties;
    
    public JSonPokemonSpecies(@JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("order") String order,
            @JsonProperty("gender_rate") String gender_rate,
            @JsonProperty("capture_rate") String capture_rate,
            @JsonProperty("base_happiness") String base_happiness,
            @JsonProperty("is_baby") String is_baby,
            @JsonProperty("is_legendary") String is_legendary,
			@JsonProperty("is_mythical") String is_mythical,
			@JsonProperty("hatch_counter") String hatch_counter, 
			@JsonProperty("has_gender_differences") String has_gender_differences, 
			@JsonProperty("forms_switchable") String forms_switchable,   
			@JsonProperty("growth_rate") JsonNode growth_rate, 
			@JsonProperty("pokedex_numbers") List<JsonNode> pokedex_numbers, 
			@JsonProperty("egg_groups") List<JsonNode> egg_groups, 
			@JsonProperty("color") JsonNode color, 
			@JsonProperty("shape") JsonNode shape, 
			@JsonProperty("evolves_from_species") JsonNode evolves_from_species,
			@JsonProperty("evolution_chain") JsonNode evolution_chain,
			@JsonProperty("habitat") JsonNode habitat,
			@JsonProperty("generation") JsonNode generation,
			@JsonProperty("names") List<JsonNode> names,
			@JsonProperty("pal_park_encounters") List<JsonNode> pal_park_encounters,
			@JsonProperty("flavor_text_entries") List<JsonNode> flavor_text_entries,
			@JsonProperty("form_descriptions") List<JsonNode> form_descriptions,
			@JsonProperty("genera") List<JsonNode> genera,
			@JsonProperty("varieties") List<JsonNode> varieties) {
    this.id = id;
    this.name = name;
    this.order = order;
    this.gender_rate = gender_rate;
    this.capture_rate = capture_rate;
    this.base_happiness = base_happiness;
    this.is_baby = is_baby;
    this.is_legendary = is_legendary;
    this.is_mythical  = is_mythical;
    this.hatch_counter = hatch_counter;
    this.has_gender_differences = has_gender_differences;
    this.forms_switchable = forms_switchable;
    this.growth_rate = growth_rate;
    this.pokedex_numbers = pokedex_numbers;
    this.egg_groups = egg_groups;
    this.color = color;
    this.shape = shape;
    this.evolves_from_species = evolves_from_species;
    this.evolution_chain = evolution_chain;
    this.habitat = habitat;
    this.generation = generation;
    this.names = names;
    this.pal_park_encounters = pal_park_encounters;
    this.flavor_text_entries = flavor_text_entries;
    this.form_descriptions = form_descriptions;
    this.genera = genera;
    this.varieties = varieties;
}

}
