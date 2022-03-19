package sn.esmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.domaine.Citoyen;

public interface CitoyenRepository extends JpaRepository<Citoyen, String> {

}
