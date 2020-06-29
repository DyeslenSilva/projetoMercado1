package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.jpa.model.Cliente;
import com.spring.jpa.repo.ClienteRepo;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepo clienteRepo;
	
	@Transactional
	public Cliente saveClient(Cliente cliente) {
		Assert.notNull(cliente);
		return clienteRepo.save(cliente);
	}
	
	public List<Cliente> listAll(){
		return clienteRepo.findAll();
	}
	
	public Optional<Cliente> findOne(int id){
		//Assert.notNull(id);
		return clienteRepo.findById(id);
	}
	
	public List<Cliente> findByName(String nome) {
		//Assert.hasLength(nome);
		return null;
	}
	
	public List<Cliente> listByCity(String cidade) {
		//Assert.hasLength(cidade);
		return null;
	}
}
