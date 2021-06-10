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
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "salon")
public class Salon {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewSalon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewSalon.class)
	private int version;
	@Column(name = "nom")
	@JsonView(Views.ViewSalon.class)
	private String nom;
	@Column(name = "mot_de_passe")
	@JsonView(Views.ViewSalon.class)
	private String motDePasse;
	@ManyToOne
	@JoinColumn(name = "joueur1_id")
	@JsonView(Views.ViewSalonDetail.class)
	private Utilisateur joueur1;
	@ManyToOne
	@JoinColumn(name = "joueur2_id")
	@JsonView(Views.ViewSalonDetail.class)
	private Utilisateur joueur2;
	@OneToMany(mappedBy = "salon")
	@JsonView(Views.ViewSalonDetail.class)
	private List<Combat> combats = new ArrayList<Combat>();
	
	public Salon() {
		super();
	}
	
	public Salon(Long id, String nom, String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.motDePasse = motDePasse;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Utilisateur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Utilisateur joueur1) {
		this.joueur1 = joueur1;
	}

	public Utilisateur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Utilisateur joueur2) {
		this.joueur2 = joueur2;
	}

	public List<Combat> getCombats() {
		return combats;
	}

	public void setCombats(List<Combat> combats) {
		this.combats = combats;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
