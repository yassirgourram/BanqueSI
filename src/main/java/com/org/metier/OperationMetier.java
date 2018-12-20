package com.org.metier;

public interface OperationMetier {
	public boolean verser (Long code, double montant, Long codeEmp);
	public boolean retirer (Long code, double montant, Long codeEmp);
	public boolean virement (Long cpte1, Long cpte2, double montant, Long codeEmp);
	public PageOperation getOperations (Long codeCompte, int page , int size);

}
