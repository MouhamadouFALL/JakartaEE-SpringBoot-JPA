package sn.esmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.esmt.domaine.Professeur;
import sn.esmt.repository.ProfesseurRepository;
import sn.esmt.repository.ProjetRechercheRepository;
import sn.esmt.domaine.ProjetRecherche;

@SpringBootApplication
public class MappingManyToManyApplication implements CommandLineRunner{

	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private ProjetRechercheRepository projetRechercheRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MappingManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		sauver();
	}
	
	public void sauver() {
		
		Professeur prof1 = new Professeur();
		prof1.setNom("Sene");
		prof1.setPrenom("Boukki");
		Professeur prof2 = new Professeur();
		prof2.setNom("Ndour");
		prof2.setPrenom("Ngor");
		Professeur prof3 = new Professeur();
		prof3.setNom("Fall");
		prof3.setPrenom("Baye");
		Professeur prof4 = new Professeur();
		prof4.setNom("Ba");
		prof4.setPrenom("Koala");
		Professeur prof5 = new Professeur();
		prof5.setNom("Ndir");
		prof5.setPrenom("Absent");
		
		ProjetRecherche proj1 = new ProjetRecherche();
		proj1.setTheme("IA sur la sante");
		ProjetRecherche proj2 = new ProjetRecherche();
		proj2.setTheme("IOT et reseaux de transport");
		ProjetRecherche proj3 = new ProjetRecherche();
		proj3.setTheme("Agriculture et IOT");
		
		
		prof1.asiignerProjetProfesseur(proj1);
		prof2.asiignerProjetProfesseur(proj1);
		
		
		prof3.asiignerProjetProfesseur(proj2);
		prof4.asiignerProjetProfesseur(proj2);
		
		prof5.asiignerProjetProfesseur(proj3);
		//prof6.asiignerProjetProfesseur(proj3);
		
		proj1.assignerProfesseurProjet(prof1);
		proj1.assignerProfesseurProjet(prof2);
		
		proj2.assignerProfesseurProjet(prof3);
		proj2.assignerProfesseurProjet(prof4);
		
		proj3.assignerProfesseurProjet(prof5);
		
		professeurRepository.save(prof1);
		professeurRepository.save(prof2);
		professeurRepository.save(prof3);
		professeurRepository.save(prof4);
		professeurRepository.save(prof5);
		
		projetRechercheRepository.save(proj1);
		projetRechercheRepository.save(proj2);
		projetRechercheRepository.save(proj3);
		
		
		
		
	}

}
