package com.org.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.dao.GroupeRepository;
import com.org.entities.Groupe;

@Service
public class GroupeMetierImpl implements GroupeMetier {
	@Autowired
    private GroupeRepository groupeRepository;
	@Override
	public Groupe saveGroupe(Groupe e) {
		
		return groupeRepository.save(e);
	}

	@Override
	public List<Groupe> listEmployes() {
		
		return groupeRepository.findAll();
	}

}
