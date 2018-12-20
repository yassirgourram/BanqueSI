package com.org.metier;

import java.util.List;

import com.org.entities.Employe;

public interface EmployeMetier {
 public Employe saveEmploye(Employe e);
 public List<Employe> listEmployes();
}
