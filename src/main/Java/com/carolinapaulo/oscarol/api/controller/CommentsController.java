package com.carolinapaulo.oscarol.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carolinapaulo.oscarol.api.model.CommentsInput;
import com.carolinapaulo.oscarol.api.model.CommentsModel;
import com.carolinapaulo.oscarol.domain.exception.EntidadeNaoEncontradaException;
import com.carolinapaulo.oscarol.domain.model.Comments;
import com.carolinapaulo.oscarol.domain.model.OrdemServico;
import com.carolinapaulo.oscarol.domain.repository.OrdemServicoRepository;
import com.carolinapaulo.oscarol.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comments")
public class CommentsController {
		
		@Autowired
		private GestaoOrdemServicoService gestaoOrdemServico;
		
		@Autowired
		private ModelMapper modelMapper;
		
		@Autowired
		private OrdemServicoRepository ordemServicoRepository;
		
		@GetMapping
		public List<CommentsModel> list(@PathVariable Long ordemServicoId){
			OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
					.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
			
			return toCollectionModel(ordemServico.getComments());
		}
	
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public CommentsModel add(@PathVariable Long ordemServicoId, @Valid @ RequestBody CommentsInput commentsInput ) {
			Comments comments = gestaoOrdemServico.addcomment(ordemServicoId, commentsInput.getDescricao());
			
			return toModel(comments);
		}

		private CommentsModel toModel(Comments comments) {
			return modelMapper.map(comments, CommentsModel.class);
		}

		private List<CommentsModel> toCollectionModel(List<Comments> comments) {
			return comments.stream()
			.map(comment -> toModel(comment))
			.collect(Collectors.toList());
}

}
