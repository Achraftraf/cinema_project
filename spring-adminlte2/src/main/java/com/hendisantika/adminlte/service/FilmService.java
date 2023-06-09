package com.hendisantika.adminlte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hendisantika.adminlte.model.Film;
import com.hendisantika.adminlte.repository.FilmRepository;

@Service
public class FilmService extends AbstractService<Film, Long> {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    protected JpaRepository<Film, Long> getRepository() {
        return filmRepository;
        
    }	
	
}
