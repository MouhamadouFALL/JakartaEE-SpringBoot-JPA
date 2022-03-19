package sn.esmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.domaine.Passeport;

public interface PasseportRepository extends JpaRepository<Passeport, Integer> {

}
