package sn.allit.sa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.allit.sa.domaine.Employe;

@Repository
public class Accesdb {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void sauverEmploye(Employe e) {
		em.persist(e);
		System.out.println("Employe enregistre");
	}
	
	@Transactional
	public void modifierEmploye(Employe e) {
		em.merge(e);
		System.out.println("Employe enregistre");
	}
	
	@Transactional
	public Employe rechercherEmloye(int id) {
		Employe e = null;
		e = em.find(Employe.class, id);
		return e;
	}
	
	@Transactional
	public void supprimerEmploye(int id) {
		
		Employe e = rechercherEmloye(id);
		if (e!=null) {
			em.remove(e);
			System.out.println("Deleled Successfully");
		}
	}

	@Transactional
	public List<Employe> afficherEmploye() {
		
		List<Employe> liste = null;
		Query q = em.createQuery("select x from Employe x");
		liste = (List<Employe>) q.getResultList();
		return liste;
	}
}
