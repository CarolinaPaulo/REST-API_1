package com.carolinapaulo.oscarol.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolinapaulo.oscarol.domain.exception.NegocioException;
import com.carolinapaulo.oscarol.domain.model.Client;
import com.carolinapaulo.oscarol.domain.model.OrdemServico;
import com.carolinapaulo.oscarol.domain.model.StatusOrdemServico;
import com.carolinapaulo.oscarol.domain.repository.ClientRepository;
import com.carolinapaulo.oscarol.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public OrdemServico create(OrdemServico ordemServico){
		Client client = clientRepository.findById(ordemServico.getClient().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setClient(client);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
		
}
}
