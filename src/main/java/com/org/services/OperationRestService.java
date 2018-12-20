package com.org.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.metier.OperationMetier;
import com.org.metier.PageOperation;

@RestController
public class OperationRestService {

	
	@Autowired
	private OperationMetier operationMetier;
	@RequestMapping(value="/versement",method=RequestMethod.PUT)//put cest update
	public boolean verser(Long code, double montant, Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}
	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public boolean retirer(@RequestParam Long code,@RequestParam double montant,@RequestParam Long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}
	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam Long cpte1,@RequestParam Long cpte2,@RequestParam double montant,@RequestParam Long codeEmp) {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperations(@RequestParam Long codeCompte,@RequestParam int page,@RequestParam int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}
	
	
}