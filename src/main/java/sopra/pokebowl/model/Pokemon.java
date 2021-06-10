package sopra.pokebowl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Pokemon")
public class Pokemon {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@Column(name="nom")
	@JsonView(Views.ViewCommon.class)
	private String nom;
	
	@Column(name="hp")
	@JsonView(Views.ViewCommon.class)
	private Integer hp;
	
	@Column(name="attaque")
	@JsonView(Views.ViewCommon.class)
	private Integer attaque;
	
	@Column(name="defense")
	@JsonView(Views.ViewCommon.class)
	private Integer defense;
	
	@Column(name="attaque_spe")
	@JsonView(Views.ViewCommon.class)
	private Integer attaqueSpe;
	
	@Column(name="defense_spe")
	@JsonView(Views.ViewCommon.class)
	private Integer defenseSpe;
	
	@Column(name="speed")
	@JsonView(Views.ViewCommon.class)
	private Integer speed;
	
	@Column(name="taille")
	@JsonView(Views.ViewCommon.class)
	private Float taille;
	
	@Column(name="poids")
	@JsonView(Views.ViewCommon.class)
	private Float poids;
	
	@Column(name="generation")
	@JsonView(Views.ViewCommon.class)
	private Integer generation;
	
	@Column(name="avatar")
	@JsonView(Views.ViewCommon.class)
	private String avatar;
	
	@Column(name="description", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String description;
	
	@ManyToMany
	@JoinTable(name = "attaque_pokemon", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "attaque_id"))
	@JsonView(Views.ViewPokemonDetail.class)
	private List<Attaque> attaques = new ArrayList<Attaque>();
	
	@OneToOne
	@JoinColumn(name = "type1")
	@JsonView(Views.ViewPokemonDetail.class)
	private TypeClass type1;
	
	@OneToOne
	@JoinColumn(name = "type2")
	@JsonView(Views.ViewPokemonDetail.class)
	private TypeClass type2;
	
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pokemon(String nom, Integer hp, Integer attaque, Integer defense, Integer attaqueSpe,
			Integer defenseSpe, Integer speed, Float taille, Float poids, Integer generation, String avatar,
			String description) {
		super();
		this.nom = nom;
		this.hp = hp;
		this.attaque = attaque;
		this.defense = defense;
		this.attaqueSpe = attaqueSpe;
		this.defenseSpe = defenseSpe;
		this.speed = speed;
		this.taille = taille;
		this.poids = poids;
		this.generation = generation;
		this.avatar = avatar;
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



	public Integer getHp() {
		return hp;
	}



	public void setHp(Integer hp) {
		this.hp = hp;
	}



	public Integer getAttaque() {
		return attaque;
	}



	public void setAttaque(Integer attaque) {
		this.attaque = attaque;
	}



	public Integer getDefense() {
		return defense;
	}



	public void setDefense(Integer defense) {
		this.defense = defense;
	}



	public Integer getAttaqueSpe() {
		return attaqueSpe;
	}



	public void setAttaqueSpe(Integer attaqueSpe) {
		this.attaqueSpe = attaqueSpe;
	}



	public Integer getDefenseSpe() {
		return defenseSpe;
	}



	public void setDefenseSpe(Integer defenseSpe) {
		this.defenseSpe = defenseSpe;
	}



	public Integer getSpeed() {
		return speed;
	}



	public void setSpeed(Integer speed) {
		this.speed = speed;
	}



	public Float getTaille() {
		return taille;
	}



	public void setTaille(Float taille) {
		this.taille = taille;
	}



	public Float getPoids() {
		return poids;
	}



	public void setPoids(Float poids) {
		this.poids = poids;
	}



	public Integer getGeneration() {
		return generation;
	}



	public void setGeneration(Integer generation) {
		this.generation = generation;
	}



	public String getAvatar() {
		return avatar;
	}



	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Attaque> getAttaques() {
		return attaques;
	}



	public void setAttaques(List<Attaque> attaques) {
		this.attaques = attaques;
	}



	public TypeClass getType1() {
		return type1;
	}



	public void setType1(TypeClass type1) {
		this.type1 = type1;
	}



	public TypeClass getType2() {
		return type2;
	}



	public void setType2(TypeClass type2) {
		this.type2 = type2;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
