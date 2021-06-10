package sopra.pokebowl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Attaque")
public class Attaque {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewAttaque.class)
	private Long id;
	@Version
	@JsonView(Views.ViewAttaque.class)
	private int version;
	@Column(name="nom")
	@JsonView(Views.ViewAttaque.class)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name="categorie", length=20)
	@JsonView(Views.ViewAttaque.class)
	private CategorieAttaque categorie;
	@Column(name="pointDePouvoir")
	@JsonView(Views.ViewAttaque.class)
	private Integer pointDePouvoir;
	@Column(name="puissance")
	@JsonView(Views.ViewAttaque.class)
	private Integer puissance;
	@Column(name="precision_attaque")
	@JsonView(Views.ViewAttaque.class)
	private Float precisionAttaque;
	@Column(name="description", length = 255)
	@JsonView(Views.ViewAttaque.class)
	private String description;
	@ManyToMany(mappedBy = "attaques")
	private List<Pokemon> pokemons = new ArrayList<Pokemon>();
	@OneToOne
	@JoinColumn(name = "type_attaque")
	@JsonView(Views.ViewAttaqueDetail.class)
	private TypeClass typeAttaque;
	
	
	public Attaque() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Attaque(String nom, CategorieAttaque categorie, Integer pointDePouvoir, Integer puissance,
			Float precision, String description) {
		super();
		this.nom = nom;
		this.categorie = categorie;
		this.pointDePouvoir = pointDePouvoir;
		this.puissance = puissance;
		this.precisionAttaque = precision;
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public CategorieAttaque getCategorie() {
		return categorie;
	}


	public void setCategorie(CategorieAttaque categorie) {
		this.categorie = categorie;
	}


	public Integer getPointDePouvoir() {
		return pointDePouvoir;
	}


	public void setPointDePouvoir(Integer pointDePouvoir) {
		this.pointDePouvoir = pointDePouvoir;
	}


	public Integer getPuissance() {
		return puissance;
	}


	public void setPuissance(Integer puissance) {
		this.puissance = puissance;
	}


	public Float getPrecisionAttaque() {
		return precisionAttaque;
	}


	public void setPrecisionAttaque(Float precision) {
		this.precisionAttaque = precision;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Pokemon> getPokemons() {
		return pokemons;
	}


	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}


	public TypeClass getTypeAttaque() {
		return typeAttaque;
	}


	public void setTypeAttaque(TypeClass typeAttaque) {
		this.typeAttaque = typeAttaque;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
