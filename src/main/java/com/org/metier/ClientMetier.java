package com.org.metier;

import java.util.List;

import com.org.entities.Client;

public interface ClientMetier {
	public Client saveClient (Client c);
	public List<Client> listClient();
	
	

}
