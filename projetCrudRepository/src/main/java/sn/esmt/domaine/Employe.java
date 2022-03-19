package sn.esmt.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employes")
public class Employe implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private int salbase;
	
	
	public Employe() { }
	public Employe(String nom, String prenom, Integer salbase) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salbase = salbase;
	}
	
	
	public Integer getId() {
		return id;
	}
	/*public void setId(Integr id) {
		this.id = id;
	}*/
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
	public Integer getSalbase() {
		return salbase;
	}
	public void setSalbase(Integer salbase) {
		this.salbase = salbase;
	}
	
	
	
}
