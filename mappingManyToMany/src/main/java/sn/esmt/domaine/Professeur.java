package sn.esmt.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "professeurs")
public class Professeur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idprof;
	private String nom;
	private String prenom;
	
	@ManyToMany(mappedBy = "professeurs", cascade = CascadeType.ALL)
	private List<ProjetRecherche> listeProj;

	public Professeur() {
		listeProj = new ArrayList<ProjetRecherche>();
	}
	
	
	public void asiignerProjetProfesseur(ProjetRecherche projet) {
		listeProj.add(projet);
	}


	public Integer getIdProfs() {
		return idprof;
	}


	public void setIdProfs(Integer idProfs) {
		this.idprof = idProfs;
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


	public List<ProjetRecherche> getListeProj() {
		return listeProj;
	}


	public void setListeProj(List<ProjetRecherche> listeProj) {
		this.listeProj = listeProj;
	}
	
	
	
}
