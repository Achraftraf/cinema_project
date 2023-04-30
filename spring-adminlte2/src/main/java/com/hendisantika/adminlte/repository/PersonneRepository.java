package com.hendisantika.adminlte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendisantika.adminlte.model.Personne;




@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
