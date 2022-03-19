package sn.esmt.domaine;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="citoyens")
public class Citoyen implements Serializable {

	@Id
	@Column(length = 50)
	private String numci;
	private String nom;
	private String prenom;
	
	@OneToOne(mappedBy = "citoyen", cascade = CascadeType.ALL)
	private Passeport passeport;

	public Citoyen() {}

	public String getNumci() {
		return numci;
	}

	public void setNumci(String numci) {
		this.numci = numci;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Passeport getPasseport() {
		return passeport;
	}

	public void setPasseport(Passeport passeport) {
		this.passeport = passeport;
	}
	
	
	
	
	
}
