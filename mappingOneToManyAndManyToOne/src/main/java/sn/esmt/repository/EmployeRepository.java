package sn.esmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.domaine.Employe;

public interface EmployeRepository extends JpaRepository<Employe, String> {

}
