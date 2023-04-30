package com.hendisantika.adminlte.repository;
//FilmRepository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hendisantika.adminlte.model.Film;
//Film Repository
@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

}



