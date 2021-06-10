package sopra.pokebowl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="equipe")
public class Equipe {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@Column(name="numero")
	@JsonView(Views.ViewCommon.class)
	private Integer numero;
	@Column(name="nom")
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Column(name="favorite")
	@JsonView(Views.ViewCommon.class)
	private Boolean favorite;
	@Column(name="nbr_pokemons")
	@JsonView(Views.ViewCommon.class)
	private Integer nbrPokemons;
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	@JsonView(Views.ViewEquipeDetail.class)
	private Utilisateur utilisateurEquipeSauv;
	@OneToOne(mappedBy="derniereEquipe")
	@JsonView(Views.ViewEquipeDetail.class)
	private Utilisateur utilisateurDeniereEquipe;
	@OneToMany(mappedBy="equipe")
	@JsonView(Views.ViewEquipeDetail.class)
	private List<MonPokemon> listPokemons = new ArrayList<MonPokemon>();
	
	public Equipe() {
		super();
	}
	
	
	public Equipe(Integer numero, String nom, Boolean favorite, Integer nbrPokemons, Utilisateur utilisateurEquipeSauv,
			Utilisateur utilisateurDeniereEquipe, List<MonPokemon> listPokemons) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.favorite = favorite;
		this.nbrPokemons = nbrPokemons;
		this.utilisateurEquipeSauv = utilisateurEquipeSauv;
		this.utilisateurDeniereEquipe = utilisateurDeniereEquipe;
		this.listPokemons = listPokemons;
	}


	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public Integer getNbrPokemons() {
		return nbrPokemons;
	}

	public void setNbrPokemons(Integer nbrPokemons) {
		this.nbrPokemons = nbrPokemons;
	}


	public Utilisateur getUtilisateurEquipeSauv() {
		return utilisateurEquipeSauv;
	}


	public void setUtilisateurEquipeSauv(Utilisateur utilisateurEquipeSauv) {
		this.utilisateurEquipeSauv = utilisateurEquipeSauv;
	}


	public Utilisateur getUtilisateurDeniereEquipe() {
		return utilisateurDeniereEquipe;
	}


	public void setUtilisateurDeniereEquipe(Utilisateur utilisateurDeniereEquipe) {
		this.utilisateurDeniereEquipe = utilisateurDeniereEquipe;
	}


	public List<MonPokemon> getListPokemons() {
		return listPokemons;
	}


	public void setListPokemons(List<MonPokemon> listPokemons) {
		this.listPokemons = listPokemons;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
