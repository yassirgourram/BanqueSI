package com.org.metier;



import com.org.entities.Compte;


public interface CompteMetier {
 public Compte saveCompte(Compte cp);
 public Compte getCompte(Long code);
// public List<> listComptes();
 
	/*public static Compte findUsingIterator(String code, List<Compte> comptes) {
			    Iterator<Compte> iterator = comptes.iterator();
			    while (iterator.hasNext()) {
			    	Compte compte = iterator.next();
			        if (compte.getCodeCompte().equals(code)) {
			            return compte;
			        }
			    }
			    return null;
			}*/
}
