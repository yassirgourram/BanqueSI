package com.org.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CE")
@XmlType(name="CE")
public class CompteEpargne extends Compte {
     
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7442367815313323820L;
	private double taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(Long codeCompte, Date dateCreation, double solde, double taux) {
		super(codeCompte, dateCreation, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	
}
