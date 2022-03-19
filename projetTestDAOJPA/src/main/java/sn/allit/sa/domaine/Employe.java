package sn.allit.sa.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employes")
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fisrtName;
	private String lastName;
	private String country;
	private Integer salBase;
	
	
	public Employe() {}

	public Employe(String fisrtName, String lastName, String country, Integer salBase) {
		super();
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.country = country;
		this.salBase = salBase;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getSalBase() {
		return salBase;
	}

	public void setSalBase(Integer salBase) {
		this.salBase = salBase;
	}
	
	
	
	
}
