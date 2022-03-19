package sn.esmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import sn.esmt.domaine.Employe;
import sn.esmt.repository.EmployeRepository;

@SpringBootApplication
public class ProjetJpaRepositoryApplication implements CommandLineRunner{
	
	@Autowired
	private EmployeRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ProjetJpaRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//viewAll();
		//sauver();
		//paginer();
		//paginerParam();
		//nomEtPrenomIdentiques();
		nomIdentiques();
	}
	
	private void sauver() {
		
		Employe e = new Employe("jules", "Ndour", 3000);
		Employe e1 = new Employe("Leukk", "Sene", 3500);
		
		Employe e2 = new Employe("Renard", "Dieng", 4000);
	
		Employe e3 = new Employe("crapaud", "Diagne", 300);
		
		
		repo.save(e1);
		repo.save(e2);
		repo.save(e3);
		repo.save(e);
		
	}
	
	private void viewAll() {
		
		List<Employe> liste = repo.findAll();
		
		for (Employe e : liste) {
			System.out.println("*** " + e.getId() + "  " + e.getNom() + "  " + e.getPrenom());
		}
	}
	
	private void triCroissantNom() {
		List<Employe> liste = repo.findAll(Sort.by("nom"));
		
		for (Employe e : liste) {
			System.out.println("*** " + e.getId() + "  " + e.getNom() + "  " + e.getPrenom() + "  " + e.getSalbase());
		}
	}
	
	private void triDecroissantNom() {
		List<Employe> liste = (List<Employe>) repo.findAll(Sort.by("nom").descending());
		
		for (Employe e : liste) {
			System.out.println("*** " + e.getId() + "  " + e.getNom() + "  " + e.getPrenom());
		}
	}
	
	private void triDeroissantSalaire() {
		List<Employe> liste = (List<Employe>) repo.findAll(Sort.by("salbase").descending());
		
		for (Employe e : liste) {
			System.out.println("*** " + e.getId() + "  " + e.getNom() + "  " + e.getPrenom() + "  " + e.getSalbase());
		}
	}
	
	private void paginer() {
		
		// Page est une liste
		Page<Employe> page = repo.findAll(PageRequest.of(0, 2));
		System.out.println(" Nombre d'egts : " + page.getTotalElements());
		System.out.println(" Nombre de page total : " + page.getTotalPages());
		
		for (Employe e : page.getContent()) {
			System.out.println(" id :" + e.getId() + " salaire :  " + e.getSalbase());
		}
	}
	
	private void paginerParam() {
		Page<Employe> page = repo.findAll(PageRequest.of(0, 2));
		int nbr_pages = page.getTotalPages();
		
		for (int i=0; i < nbr_pages; i++) {
			System.out.println(" _______Page" + i + "_____________");
			Page<Employe> page2 = repo.findAll(PageRequest.of(i, 2));
			for (Employe e : page2.getContent()) {
				System.out.println(" id :" + e.getId() + " salaire :  " + e.getSalbase());
			}
			System.out.println("**************************************************************");
		}
	}

	private void nomIdentiques() {
		List<Employe> listeNom = repo.getByNom("Diagne");
		
		for (Employe e : listeNom) {
			System.out.println(" id :" + e.getId() + " Nom : "+ e.getNom() + " salaire :  " + e.getSalbase());
		}
	}
	
	private void nomEtPrenomIdentiques() {
		List<Employe> listeNom = repo.getByNomAndPrenom("Diagne", "crapaud");
		
		for (Employe e : listeNom) {
			System.out.println(" id :" + e.getId() + " Nom : "+ e.getNom() + "  Prenom : " + e.getPrenom() + " salaire :  " + e.getSalbase());
		}
	}
}
