package sn.esmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import sn.esmt.domaine.*;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

	// methode de recherche préfixée par getByX ou 
	List<Employe> getByNom(String snom);
	List<Employe> getByPrenom(String sprenom);
	List<Employe> getBySalbase(int salBase);
	
	List<Employe> getByNomAndPrenom(String n, String p);
}
