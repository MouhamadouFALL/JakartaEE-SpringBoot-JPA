package sn.esmt.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passeports")
public class Passeport implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numpass;
	private String type;
	
	@OneToOne
	@JoinColumn(name = "numci")
	private Citoyen citoyen;
	
	// constructeur par defaut
	public Passeport() {}
	

	public Integer getNumpass() {
		return numpass;
	}

	public void setNumpass(Integer numpass) {
		this.numpass = numpass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Citoyen getCitoyen() {
		return citoyen;
	}

	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
}
