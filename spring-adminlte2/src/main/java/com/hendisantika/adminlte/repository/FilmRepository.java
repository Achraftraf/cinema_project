package com.hendisantika.adminlte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hendisantika.adminlte.model.Film;
//FilmRepository
@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

}



