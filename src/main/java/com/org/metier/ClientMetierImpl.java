package com.org.metier;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.dao.ClientRepository;
import com.org.entities.Client;

@Service
public class ClientMetierImpl implements ClientMetier {
  @Autowired
  private ClientRepository clientRepository;
	@Override
	public Client saveClient(Client c) {
	
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		
		return clientRepository.findAll();
	}

}
