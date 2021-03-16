package com.carolinapaulo.oscarol.api.model;

import javax.validation.constraints.NotBlank;

public class CommentsInput {

	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
