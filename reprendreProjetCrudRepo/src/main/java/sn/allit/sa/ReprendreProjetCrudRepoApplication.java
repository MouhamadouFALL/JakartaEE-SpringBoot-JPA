package sn.allit.sa;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.allit.sa.domaine.Employe;
import sn.allit.sa.repository.EmployeRepository;

@SpringBootApplication
public class ReprendreProjetCrudRepoApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ReprendreProjetCrudRepoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//sauve();
		//modifier(4);
		//supprimer(8);
		//rechercher(6);
		//compte();
		viewAll();
	}
	
	public void sauve() {
		
		Employe e = new Employe("Bouh", "Diallo", 3000);
		Employe e1 = new Employe("Jules", "Ba", 3500);
		Employe e2 = new Employe("Renard", "Ka", 4000);
		Employe e3 = new Employe("Mbeute", "Ndour", 3500);
		
		repo.save(e);
		repo.save(e1);
		repo.save(e2);
		repo.save(e3);
		
		System.out.println("Saved have been successfully !");
	}
	
	public void modifier(int id) {
		Employe e = null;
		Optional<Employe> optinal = repo.findById(id);
		if (optinal.isPresent()) {
			e = optinal.get();
			e.setSalbase(5000);
			repo.save(e);
			System.out.println(" Employe " + e.getId() + " has been update");
		}
		else {
			System.out.println(" Employe " + id + " est inexistant!");
		}
	}
	
	public void supprimer(int id) {
		
		if (repo.existsById(id)) {
			repo.deleteById(id);
			System.out.println(" Delete successfully");
		}
		else {
			System.out.println(" Employe " + id + " est inexistant!");
		}
	}

	public void rechercher(int id) {
		
		Employe e = null;
		Optional<Employe> optional = repo.findById(id);
		
		if (optional.isPresent()) {
			e = optional.get();
			System.out.println(" Employe recherche : " + e.getNom() + "  " + e.getPrenom());
		}
		else {
			System.out.println(" employe inexixstant");
		}
	}
	
	public void compte() {
		long taille = repo.count();
		System.out.println(" le nombre employe : " + taille);
	}

	public void viewAll() {
		
		Iterable<Employe> employes = repo.findAll();
		//ArrayList<Employe> employes = (ArrayList<Employe>) repo.findAll();
		
		System.out.println("");
		System.out.println(" *********************************** Liste des employes *******************************");
		for (Employe e : employes) {
			System.out.println("*** " + e.getNom() + "  " + e.getPrenom() + "  " + e.getSalbase());
		}
	}
	
}
