package sn.esmt.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departements")
public class Departement implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDep;
	private String nomDep;
	
	@OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employe> employes;

	public Departement() {}

	public Integer getIdDep() {
		return idDep;
	}

	public void setIdDep(Integer idDep) {
		this.idDep = idDep;
	}

	public String getNomDep() {
		return nomDep;
	}

	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

}
