package com.hendisantika.adminlte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hendisantika.adminlte.model.Genre;
import com.hendisantika.adminlte.repository.GenreRepository;

public class GenreService extends AbstractService<Genre, Long> {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    protected JpaRepository<Genre, Long> getRepository() {
        return genreRepository;
    }
}

