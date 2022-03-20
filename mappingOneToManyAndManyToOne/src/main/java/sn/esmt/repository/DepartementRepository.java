package sn.esmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.domaine.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
