package com.hendisantika.adminlte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hendisantika.adminlte.model.Nationalite;
import com.hendisantika.adminlte.repository.NationaliteRepository;

@Service
public class NationaliteService extends AbstractService<Nationalite, Long>{

	
	@Autowired
	protected NationaliteRepository nationaliteRepository;
	
    @Override
    protected JpaRepository<Nationalite, Long> getRepository() {
        return nationaliteRepository;
}
}
