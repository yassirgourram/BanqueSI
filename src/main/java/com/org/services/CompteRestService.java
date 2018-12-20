package com.org.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.Compte;
import com.org.metier.CompteMetier;

@RestController
public class CompteRestService {

	@Autowired
	private CompteMetier compteMetier;
	// @RequestMapping(value="/employes",method=RequestMethod.POST)
	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte cp) {
		return compteMetier.saveCompte(cp);
	}
	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable Long code) {
		return  compteMetier.getCompte(code);
	}
	
	
}