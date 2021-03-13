package com.carolinapaulo.oscarol.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolinapaulo.oscarol.domain.exception.NegocioException;
import com.carolinapaulo.oscarol.domain.model.Client;
import com.carolinapaulo.oscarol.domain.repository.ClientRepository;

@Service
public class RegisterClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client save(Client client) {
		Client clientExists = clientRepository.findByEmail(client.getEmail());
		
		if(clientExists != null && !clientExists.equals(client)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
			
		}
		return clientRepository.save(client);
		
	}
	
	public void delete(Long clienteId) {
		clientRepository.deleteById(clienteId);
	}

}
