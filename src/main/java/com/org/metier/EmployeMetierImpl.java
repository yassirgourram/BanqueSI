package com.org.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.dao.EmployeRepository;
import com.org.entities.Employe;

@Service
public class EmployeMetierImpl implements EmployeMetier {
	@Autowired
    private EmployeRepository employeRepository;
	@Override
	public Employe saveEmploye(Employe e) {
	
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmployes() {
		
		return employeRepository.findAll();
	}

}
