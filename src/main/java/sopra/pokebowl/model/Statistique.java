package sopra.pokebowl.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Statistique {
	
	@Column(name="pokemon_prefere")
	private String pokemonPrefere;
	@Column(name="nbr_victoires")
	private Integer nbrVictoires;
	@Column(name="nbr_defaites")
	private Integer nbrDefaites;
	@Column(name="nbr_parties_jouees")
	private Integer nbrPartiesJouees;
	
	public Statistique() {
		super();
	}
	
	public Statistique(String pokemonPrefere, Integer nbrVictoires, Integer nbrDefaites,
			Integer nbrPartiesJouees) {
		super();
		this.pokemonPrefere = pokemonPrefere;
		this.nbrVictoires = nbrVictoires;
		this.nbrDefaites = nbrDefaites;
		this.nbrPartiesJouees = nbrPartiesJouees;
	}
	
	public String getPokemonPrefere() {
		return pokemonPrefere;
	}

	public void setPokemonPrefere(String pokemonPrefere) {
		this.pokemonPrefere = pokemonPrefere;
	}

	public Integer getNbrVictoires() {
		return nbrVictoires;
	}

	public void setNbrVictoires(Integer nbrVictoires) {
		this.nbrVictoires = nbrVictoires;
	}

	public Integer getNbrDefaites() {
		return nbrDefaites;
	}

	public void setNbrDefaites(Integer nbrDefaites) {
		this.nbrDefaites = nbrDefaites;
	}

	public Integer getNbrPartiesJouees() {
		return nbrPartiesJouees;
	}

	public void setNbrPartiesJouees(Integer nbrPartiesJouees) {
		this.nbrPartiesJouees = nbrPartiesJouees;
	}
	
	

}
