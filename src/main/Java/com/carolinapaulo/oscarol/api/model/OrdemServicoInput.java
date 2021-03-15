package com.carolinapaulo.oscarol.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemServicoInput {
		
		@NotBlank
		private String descricao;
		
		@NotNull
		private BigDecimal preco;
		
		@Valid
		@NotNull
		private ClientIdInput client;
		
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public BigDecimal getPreco() {
			return preco;
		}
		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}
		public ClientIdInput getClient() {
			return client;
		}
		public void setClient(ClientIdInput client) {
			this.client = client;
		}
		
		
		
}
