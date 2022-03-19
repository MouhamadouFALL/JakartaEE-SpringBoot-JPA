package sn.esmt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import sn.esmt.domaine.Citoyen;
import sn.esmt.domaine.Passeport;
import sn.esmt.repository.CitoyenRepository;
import sn.esmt.repository.PasseportRepository;

@SpringBootTest
class MappingOneToOneApplicationTests implements CommandLineRunner{

	@Autowired
	private CitoyenRepository repoCitoyen;
	
	@Autowired
	private PasseportRepository repoPass;
	
	
	@Test
	void contextLoads() {
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//sauver();
		
	}
	
	
	private void sauver() {
		
		Citoyen c1 = new Citoyen();
		c1.setNumci("100E");
		c1.setNom("aaa1");
		c1.setPrenom("bbb1");
		
		Citoyen c2 = new Citoyen();
		c2.setNumci("200E");
		c2.setNom("aaa2");
		c2.setPrenom("bbb2");
		
		Passeport p1 = new Passeport();
		p1.setType("PD");
		
		Passeport p2 = new Passeport();
		p2.setType("PO");
		
		//Asssocier p1 à c1
		c1.setPasseport(p1);
		p1.setCitoyen(c1);
		
		//Asssocier p2 à c2
		c2.setPasseport(p2);
		p2.setCitoyen(c2);
		
		repoCitoyen.save(c1);
		repoCitoyen.save(c2);
		
		repoPass.save(p1);
		repoPass.save(p2);
	}

}
