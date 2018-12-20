package com.org.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.CompteRepository;
import com.org.entities.Compte;

@Service
public class CompteMetierImpl implements CompteMetier {
	@Autowired
    private CompteRepository compteRepository;


	@Override
	public Compte saveCompte(Compte cp) {
		
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	
	public Compte getCompte(Long code) {
	
		//Optional<Compte> co = compteRepository.findById(code);
		//return compteRepository.findOne(code);
		Compte compte = this.compteRepository.findById(code).orElse(null);
		/*if (compte.isPresent()) {
		    return compte.get();
		} else {
		    return null;*/
		
		 return compte;
		}

	}




