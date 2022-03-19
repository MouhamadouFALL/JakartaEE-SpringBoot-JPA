package sn.esmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.esmt.domaine.Citoyen;
import sn.esmt.domaine.Passeport;
import sn.esmt.repository.CitoyenRepository;
import sn.esmt.repository.PasseportRepository;

@SpringBootApplication
public class MappingOneToOneApplication implements CommandLineRunner {

	@Autowired
	private CitoyenRepository repoCitoyen;
	
	@Autowired
	private PasseportRepository repoPasseport;
	
	public static void main(String[] args) {
		SpringApplication.run(MappingOneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//sauver();
		afficherCitoyenPasseport();
		afficherPasseportPersonne();
		
	}
	
	
	public void sauver() {
		
		Citoyen c1 = new Citoyen();
		c1.setNumci("100E");
		c1.setNom("aaa1");
		c1.setPrenom("bbb1");
		
		Citoyen c2 = new Citoyen();
		c2.setNumci("200E");
		c2.setNom("aaa2");
		c2.setPrenom("bbb2");
		
		repoCitoyen.save(c1);
		repoCitoyen.save(c2);
		
		Passeport p1 = new Passeport();
		p1.setType("PD");
		
		Passeport p2 = new Passeport();
		p2.setType("PO");
		
		
		c1.setPasseport(p1);
		p1.setCitoyen(c1);
		
		c2.setPasseport(p2);
		p2.setCitoyen(c2);
		
		repoPasseport.save(p1);
		repoPasseport.save(p2);
		
	}
	
	private void afficherPasseportPersonne() {
		List<Passeport> liste  = repoPasseport.findAll();
		
		for (Passeport p : liste) {
			System.out.println(" -- Numero passeport : " + p.getNumpass() + "\n -- numero ci : " + p.getCitoyen().getNumci());
		}
	}
	
	private void afficherCitoyenPasseport() {
		List<Citoyen> liste  = repoCitoyen.findAll();
		
		for (Citoyen c : liste) {
			System.out.println(" ** Numero ci : " + c.getNumci() + "\n ** numero passeport : " + c.getPasseport().getNumpass());
		}
	}

}
