package sopra.pokebowl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewUtilisateur.class)
	private Long id;
	@Version
	@JsonView(Views.ViewUtilisateur.class)
	private int version;
	@Column(name = "pseudo")
	@JsonView(Views.ViewUtilisateur.class)
	private String pseudo;
	@Column(name = "email")
	@JsonView(Views.ViewUtilisateur.class)
	private String email;
	@Column(name = "avatar")
	@JsonView(Views.ViewUtilisateur.class)
	private String avatar;
	@Column(name = "mot_de_passe")
	@JsonView(Views.ViewUtilisateur.class)
	private String motDePasse;
	@Embedded
//	@JsonView(Views.ViewUtilisateurDetail.class)
	private Statistique statistique;
	@OneToOne
	@JoinColumn(name = "derniere_equipe_id")
//	@JsonView(Views.ViewUtilisateurDetail.class)
	@JsonIgnore
	private Equipe derniereEquipe;
	@OneToMany(mappedBy = "joueur1")
//	@JsonView(Views.ViewUtilisateurDetail.class)
	@JsonIgnore
	private List<Salon> salons = new ArrayList<Salon>();
	@OneToMany(mappedBy = "utilisateurEquipeSauv")
	@JsonView(Views.ViewUtilisateurDetail.class)
	private List<Equipe> equipesSauvegardees = new ArrayList<Equipe>();
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(Long id, String pseudo, String email, String avatar, String motDePasse) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.email = email;
		this.avatar = avatar;
		this.motDePasse = motDePasse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Statistique getStatistique() {
		return statistique;
	}

	public void setStatistique(Statistique statistique) {
		this.statistique = statistique;
	}

	public Equipe getDerniereEquipe() {
		return derniereEquipe;
	}

	public void setDerniereEquipe(Equipe derniereEquipe) {
		this.derniereEquipe = derniereEquipe;
	}

	public List<Salon> getSalons() {
		return salons;
	}

	public void setSalons(List<Salon> salons) {
		this.salons = salons;
	}

	public List<Equipe> getEquipesSauvegardees() {
		return equipesSauvegardees;
	}

	public void setEquipesSauvegardees(List<Equipe> equipesSauvegardees) {
		this.equipesSauvegardees = equipesSauvegardees;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
