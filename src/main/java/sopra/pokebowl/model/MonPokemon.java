package sopra.pokebowl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="mon_pokemon")
public class MonPokemon {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name="ordre")
	@JsonView(Views.ViewCommon.class)
	private Integer ordre;
	@ManyToOne
	@JoinColumn(name="id_equipe")
	@JsonView(Views.ViewMonPokemonDetail.class)
	private Equipe equipe;
	@OneToOne
	@JoinColumn(name="id_pokemon")
	@JsonView(Views.ViewEquipeDetail.class)
	private Pokemon pokeReference;
	@OneToOne
	@JoinColumn(name="id_attaque1")
	@JsonView(Views.ViewMonPokemonDetail.class)
	private Attaque attaque1;
	@OneToOne
	@JoinColumn(name="id_attaque2")
	@JsonView(Views.ViewMonPokemonDetail.class)
	private Attaque attaque2;
	@OneToOne
	@JoinColumn(name="id_attaque3")
	@JsonView(Views.ViewMonPokemonDetail.class)
	private Attaque attaque3;
	@OneToOne
	@JoinColumn(name="id_attaque4")
	@JsonView(Views.ViewMonPokemonDetail.class)
	private Attaque attaque4;
	@OneToOne(mappedBy="monPokemon")
	@JsonView(Views.ViewMonPokemonDetail.class)
	private PokemonMatch pokeMatch;
	
	public MonPokemon() {
		super();
	}
	
	public MonPokemon(Integer ordre, Equipe equipe, Pokemon pokeReference, Attaque attaque1, Attaque attaque2,
			Attaque attaque3, Attaque attaque4, PokemonMatch pokeMatch) {
		super();
		this.ordre = ordre;
		this.equipe = equipe;
		this.pokeReference = pokeReference;
		this.attaque1 = attaque1;
		this.attaque2 = attaque2;
		this.attaque3 = attaque3;
		this.attaque4 = attaque4;
		this.pokeMatch = pokeMatch;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}



	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}



	public Pokemon getPokeReference() {
		return pokeReference;
	}



	public void setPokeReference(Pokemon pokeReference) {
		this.pokeReference = pokeReference;
	}


	public Attaque getAttaque1() {
		return attaque1;
	}



	public void setAttaque1(Attaque attaque1) {
		this.attaque1 = attaque1;
	}



	public Attaque getAttaque2() {
		return attaque2;
	}



	public void setAttaque2(Attaque attaque2) {
		this.attaque2 = attaque2;
	}



	public Attaque getAttaque3() {
		return attaque3;
	}



	public void setAttaque3(Attaque attaque3) {
		this.attaque3 = attaque3;
	}



	public Attaque getAttaque4() {
		return attaque4;
	}



	public void setAttaque4(Attaque attaque4) {
		this.attaque4 = attaque4;
	}



	public PokemonMatch getPokeMatch() {
		return pokeMatch;
	}



	public void setPokeMatch(PokemonMatch pokeMatch) {
		this.pokeMatch = pokeMatch;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	

}
