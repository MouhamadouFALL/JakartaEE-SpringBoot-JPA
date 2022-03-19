package sn.allit.sa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.allit.sa.dao.Accesdb;
import sn.allit.sa.domaine.Employe;

@SpringBootApplication
public class ProjetTestDaojpaApplication implements CommandLineRunner {

	@Autowired
	private Accesdb db;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetTestDaojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//sauver();
		//modifier(5);
		//supprimerUn(2);
		viewAll();
	}
	
	
	private void sauver() {
		Employe e = new Employe("Boukki", "Ndour", "Fatick", 3000);
		db.sauverEmploye(e);
		Employe e1 = new Employe("Leukk", "Sene", "Fatick", 3500);
		db.sauverEmploye(e1);
		Employe e2 = new Employe("Renard", "Dieng", "Pakhaye", 4000);
		db.sauverEmploye(e2);
		Employe e3 = new Employe("crapaud", "Diagne", "Diomkhel", 300);
		db.sauverEmploye(e3);
	}
	
	private void modifier(int id) {
		Employe e = db.rechercherEmloye(id);
		e.setSalBase(4500);
		db.modifierEmploye(e);
	}
	
	private void supprimerUn(int id) {
		db.supprimerEmploye(id);
	}
	
	private void viewAll() {
		
		List<Employe> employes = db.afficherEmploye();
		
		
		for (Employe e : employes) {
			System.out.println(" "+ e.getLastName() + "  " + e.getFisrtName() + "  " + e.getCountry());
		}
	}

}
