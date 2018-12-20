package com.org.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.Employe;
import com.org.metier.EmployeMetier;

@RestController
public class EmployeRestService {

	@Autowired
	private EmployeMetier employeMetier ;
	 @RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe e) {
		return employeMetier.saveEmploye(e);
	}
	 @RequestMapping(value="/employes",method=RequestMethod.GET)
	public List<Employe> listEmploye() {
		return employeMetier.listEmployes();
	}
}
