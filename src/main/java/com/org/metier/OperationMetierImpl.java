package com.org.metier;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.CompteRepository;
import com.org.dao.EmployeRepository;
import com.org.dao.OperationRepository;
import com.org.entities.Compte;
import com.org.entities.Employe;
import com.org.entities.Operation;
import com.org.entities.Retrait;
import com.org.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier  {

	@Autowired
    private OperationRepository operationRepository;
	@Autowired
    private CompteRepository compteRepository;
	@Autowired
    private EmployeRepository employeRepository;
	@Override
	@Transactional// rollback encas de problem
	public boolean verser(Long code, double montant, Long codeEmp) {
		
	/*	Optional<Compte> cp = this.compteRepository.findById(code);
		if (cp.isPresent()) {
		    return compte.get();
		} else {
		    return null;
		}*/
		Compte cp= compteRepository.findById(code).orElse(null);
		if (cp.equals(null)) {System.out.println("\n\n\n\n\n\n\n\n_nulll \n\n\n\n\n\n\n");}
		Employe e= employeRepository.findById(codeEmp).orElse(null);
		Operation o= new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+ montant);
		return true;
	}

	@Override
	@Transactional// rollback encas de problem
	public boolean retirer(Long code, double montant, Long codeEmp) {

		Compte cp= compteRepository.findById(code).orElse(null);
		if (cp.getSolde()<montant) throw new RuntimeException("solde insuffisant");
		Employe e= employeRepository.findById(codeEmp).orElse(null);
		Operation o= new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
		
		return true;
	}

	@Transactional// rollback encas de problem
	public boolean virement(Long cpte1, Long cpte2, double montant, Long codeEmp) {
		
		retirer(cpte1 ,montant, codeEmp);
		verser(cpte2, montant, codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperations(Long codeCompte, int page, int size) {
		//page list
		Page<Operation> ops = operationRepository.getOperations(codeCompte, PageRequest.of(page, size));
		/*Compte cp = compteRepository.findById(codeCompte).orElse(null);
		Page<Operation> op2 = operationRepository.findByCompte(codeCompte, pegeable)*/
		
		PageOperation pOp = new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalPages(ops.getTotalPages());
		pOp.setTotalOperations((int) ops.getTotalElements());
		//ops to pop
		return pOp;
	}

}
