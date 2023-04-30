package com.hendisantika.adminlte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hendisantika.adminlte.model.Personne;
import com.hendisantika.adminlte.repository.PersonneRepository;


@Service
public class PersonneService extends AbstractService<Personne, Long> {

	   @Autowired
	    private PersonneRepository personneRepository;

	    @Override
	    protected JpaRepository<Personne, Long> getRepository() {
	        return personneRepository;
	    }
}
