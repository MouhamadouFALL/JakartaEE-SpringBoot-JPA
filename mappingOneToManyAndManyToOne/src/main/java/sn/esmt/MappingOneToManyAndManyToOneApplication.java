package sn.esmt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.esmt.domaine.Departement;
import sn.esmt.domaine.Employe;
import sn.esmt.repository.DepartementRepository;
import sn.esmt.repository.EmployeRepository;

@SpringBootApplication
public class MappingOneToManyAndManyToOneApplication implements CommandLineRunner {

	@Autowired
	private EmployeRepository repoEmp;
	
	@Autowired
	private DepartementRepository repoDep;
	
	public static void main(String[] args) {
		SpringApplication.run(MappingOneToManyAndManyToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//sauver();
		afficherDepartementEmploye();
		
	}

	private void sauver() {
		
		Departement dep1 = new Departement();
		dep1.setNomDep("Technology");
		
		Departement dep2 = new Departement();
		dep2.setNomDep("Management");
		
		Employe e1 = new Employe();
		e1.setCodeEmp("20302022QW");
		e1.setNom("Ndour");
		e1.setPrenom("Boukki");
		e1.setDepartement(dep1);
		
		Employe e2 = new Employe();
		e2.setCodeEmp("20302022AS");
		e2.setNom("Sene");
		e2.setPrenom("Leukk");
		e2.setDepartement(dep1);
		
		Employe e3 = new Employe();
		e3.setCodeEmp("20302022QE");
		e3.setNom("Faye");
		e3.setPrenom("Renard");
		e3.setDepartement(dep1);
		
		List<Employe> employes = new ArrayList<Employe>();
		employes.add(e1);
		employes.add(e2);
		employes.add(e3);
		dep1.setEmployes(employes);
		
		Employe e4 = new Employe();
		e4.setCodeEmp("20302022AD");
		e4.setNom("Dione");
		e4.setPrenom("Crapaud");
		e4.setDepartement(dep2);
		
		Employe e5 = new Employe();
		e5.setCodeEmp("20302022DF");
		e5.setNom("Sow");
		e5.setPrenom("Nakk");
		e5.setDepartement(dep2);
		
		Employe e6 = new Employe();
		e6.setCodeEmp("20302022HG");
		e6.setNom("Ba");
		e6.setPrenom("Koala");
		e6.setDepartement(dep2);
		
		List<Employe> employes1 = new ArrayList<Employe>();
		employes1.add(e4);
		employes1.add(e5);
		employes1.add(e6);
		dep2.setEmployes(employes1);
		
		repoDep.save(dep1);
		repoDep.save(dep2);
		
		repoEmp.save(e1);
		repoEmp.save(e2);
		repoEmp.save(e3);
		repoEmp.save(e4);
		repoEmp.save(e5);
		repoEmp.save(e6);
		
	}
	
	private void afficherDepartementEmploye() {
		
		List<Departement> departs = repoDep.findAll();
		
		System.out.println();
		
		for (Departement d : departs) {
			
			System.out.println(" >==: ID depart : " + d.getIdDep() + " | nom depart : " + d.getNomDep() + " | employées departs : ");
			
			List<Employe> employes = d.getEmployes();
			for (Employe e : employes) {
				System.out.println("\t\t\t\t\t\t\t\t  >>> " + e.getCodeEmp() + "  " + e.getPrenom() + "  " + e.getNom());
			}
		}
		System.out.println();
	}

}
