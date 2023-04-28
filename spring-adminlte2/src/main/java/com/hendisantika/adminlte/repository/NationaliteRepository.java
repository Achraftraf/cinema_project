package com.hendisantika.adminlte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hendisantika.adminlte.model.Nationalite;


@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite, Long> {

}
