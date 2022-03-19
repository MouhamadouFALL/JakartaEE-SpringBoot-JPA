package sn.esmt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.esmt.domaine.Employe;
import sn.esmt.repository.EmployeRepository;

@SpringBootApplication
public class ProjetCrudRepositoryApplication implements CommandLineRunner {

	@Autowired
	private EmployeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetCrudRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//sauver();
		//checkId();
		//rechercherId(6);
		//modifier();
		//supprimer();
		//compte();
		viewAll();
		
	}
	
	private void sauver() {
		
		Employe emp1 = new Employe("Sene", "Leukk", 3000);
		Employe emp2 = new Employe("Ndour", "Boukki", 1500);
		Employe emp3 = new Employe("Diop", "Renard", 2500);
		Employe emp4 = new Employe("Diagne", "Rat", 3500);
		Employe emp5 = new Employe("Sow", "crapaud", 4000);
		
		repo.save(emp1);
		repo.save(emp2);
		repo.save(emp3);
		repo.save(emp4);
		repo.save(emp5);
		
	}
	
	private void checkId() {
		System.out.println(" ID existe : " + repo.existsById(9));
	}
	
	private void rechercherId(int id) {
		
		Employe emp = null;
		Optional<Employe> optional = repo.findById(id);
		
		if (optional.isPresent()) {
			emp = optional.get();
			System.out.println("Employe modifié : " + emp.getNom() + "  " + emp.getPrenom());
		}
		else {
			System.out.println("ID inexistant ");
		}
	}
	
	private void modifier() {
		Employe emp = null;
		
		Optional<Employe> optional = repo.findById(2);
		
		if (optional.isPresent()) {
			
			emp = optional.get();
			emp.setSalbase(4500);
			repo.save(emp);
			System.out.println("Employe recherché : " + emp.getNom() + "  " + emp.getPrenom() + " " + emp.getSalbase());
		}
		else {
			System.out.println("ID inexistant ");
		}
	}
	
	private void supprimer() {
		if (repo.existsById(1))
		{
			repo.deleteById(1);
			System.out.println(" Deleted successfully ");
		}
		else {
			System.out.println("ID inexistant ");
		}
	}
	
	private void compte() {
		long taille = repo.count();
		System.out.println(" Le nombre employe  : " + taille);
	}
	
	private void viewAll() {
		Iterable<Employe> liste = repo.findAll();
		for (Employe e : liste) {
			System.out.println("++ " + e.getId() + " "+ e.getNom() + "  " + e.getPrenom() + " " + e.getSalbase());
		}
	}

}
