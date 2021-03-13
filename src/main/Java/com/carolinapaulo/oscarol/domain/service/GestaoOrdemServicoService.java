package com.carolinapaulo.oscarol.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carolinapaulo.oscarol.domain.model.OrdemServico;
import com.carolinapaulo.oscarol.domain.model.StatusOrdemServico;
import com.carolinapaulo.oscarol.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public OrdemServico create(OrdemServico ordemServico){
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
		
}
}
