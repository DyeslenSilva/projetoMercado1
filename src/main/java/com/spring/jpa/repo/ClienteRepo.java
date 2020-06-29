package com.spring.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.model.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
