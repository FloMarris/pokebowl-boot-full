package sopra.pokebowl.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonAttaque {
	public final String accuracy;
	public final JsonNode contest_combos;
	public final JsonNode contest_effect;
	public final JsonNode contest_type;
	public final JsonNode damage_class;
	public final String effect_chance;
	public final List<JsonNode> effect_changes;
	public final List<JsonNode> effect_entries;
	public final List<JsonNode> flavor_text_entries;
	public final JsonNode generation;
	public final String id;
	public final List<JsonNode> learned_by_pokemon;
	public final List<JsonNode> machines;
	public final JsonNode meta;
	public final String name;
	public final List<JsonNode> names;
	public final List<JsonNode> past_values;
	public final String power;
	public final String pp;
	public final String priority;
	public final List<JsonNode> stat_changes;
	public final JsonNode super_contest_effect;
	public final JsonNode target;
	public final JsonNode type;

    public JsonAttaque(
    		@JsonProperty("accuracy") String accuracy,
    		@JsonProperty("contest_combos") JsonNode contest_combos,
    		@JsonProperty("contest_effect") JsonNode contest_effect,
    		@JsonProperty("contest_type") JsonNode contest_type,
    		@JsonProperty("damage_class") JsonNode damage_class,
    		@JsonProperty("effect_chance") String effect_chance,
    		@JsonProperty("effect_changes") List<JsonNode> effect_changes,
    		@JsonProperty("effect_entries") List<JsonNode> effect_entries,
    		@JsonProperty("flavor_text_entries") List<JsonNode> flavor_text_entries,
    		@JsonProperty("generation") JsonNode generation,
    		@JsonProperty("id") String id,
    		@JsonProperty("learned_by_pokemon") List<JsonNode> learned_by_pokemon,
    		@JsonProperty("machines") List<JsonNode> machines,
    		@JsonProperty("meta") JsonNode meta,
    		@JsonProperty("name") String name,
    		@JsonProperty("names") List<JsonNode> names,
    		@JsonProperty("past_values") List<JsonNode> past_values,
    		@JsonProperty("power") String power,
    		@JsonProperty("pp") String pp,
    		@JsonProperty("priority") String priority,
    		@JsonProperty("stat_changes") List<JsonNode> stat_changes,
    		@JsonProperty("super_contest_effect") JsonNode super_contest_effect,
    		@JsonProperty("target") JsonNode target,
    		@JsonProperty("type") JsonNode type) {
        this.accuracy = accuracy;
        this.contest_combos = contest_combos;
        this.contest_effect = contest_effect;
        this.contest_type = contest_type;
        this.damage_class = damage_class;
        this.effect_chance = effect_chance;
        this.effect_changes = effect_changes;
        this.effect_entries = effect_entries;
        this.flavor_text_entries = flavor_text_entries;
        this.generation = generation;
        this.id = id;
        this.learned_by_pokemon = learned_by_pokemon;
        this.machines = machines;
        this.meta = meta;
        this.name = name;
        this.names = names;
        this.past_values = past_values;
        this.power = power;
        this.pp = pp;
        this.priority = priority;
        this.stat_changes = stat_changes;
        this.super_contest_effect = super_contest_effect;
        this.target = target;
        this.type = type;
        
    }
}
