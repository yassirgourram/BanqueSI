package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entities.Client;

public interface ClientRepository extends JpaRepository <Client, Long> {

}
