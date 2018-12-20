package com.org.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{// cherc her c'est quoi la serialization 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5752985177244294489L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	private String nomClient;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)// fetch lazy === il va charger juste les informations compte et client et il va fonctionné en mode paréseu// charger en cas de besoin // eager charger avec tout les compte client et peut etre qui ne sont pas utilisable // par dafault c'est lazy
	private Collection <Compte> comptes;
	public Client() {
		super();
	}
	public Client(Long codeClient, String nomClient, Collection<Compte> comptes) {
		super();
		this.codeClient = codeClient;
		this.nomClient = nomClient;
		this.comptes = comptes;
	}
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	

}
