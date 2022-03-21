package sn.esmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.domaine.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

}
