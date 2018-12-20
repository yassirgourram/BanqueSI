package com.org.metier;

import java.util.List;

import com.org.entities.Groupe;

public interface GroupeMetier {
 public Groupe saveGroupe(Groupe e);
 public List<Groupe> listEmployes();
}
