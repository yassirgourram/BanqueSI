package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.Compte;



public interface CompteRepository extends JpaRepository<Compte, Long> {



}
