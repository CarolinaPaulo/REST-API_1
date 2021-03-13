package com.carolinapaulo.oscarol.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carolinapaulo.oscarol.domain.model.Client;
import com.carolinapaulo.oscarol.domain.repository.ClientRepository;
import com.carolinapaulo.oscarol.domain.service.RegisterClientService;

@RestController
@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	private ClientRepository ClientRepository;
	
	@Autowired
	private RegisterClientService registerClient;
	
	@GetMapping
	public List<Client> listar() {
		return ClientRepository.findAll();
		//return ClientRepository.findByNome();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Client> buscar(@PathVariable Long clienteId) {
		Optional<Client> client = ClientRepository.findById(clienteId);
		
		if(client.isPresent()) {
			return ResponseEntity.ok(client.get());
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client addClient(@Valid @RequestBody Client client) {
		return registerClient.save(client);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Client> update(@Valid @PathVariable Long clienteId,
		@RequestBody Client client){
		
		if(!ClientRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(clienteId);
		client = registerClient.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remove(@PathVariable Long clienteId){
		if(!ClientRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		registerClient.delete(clienteId);
		return ResponseEntity.noContent().build();
	}
}
