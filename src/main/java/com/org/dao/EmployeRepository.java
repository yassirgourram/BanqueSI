package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.Employe;
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
