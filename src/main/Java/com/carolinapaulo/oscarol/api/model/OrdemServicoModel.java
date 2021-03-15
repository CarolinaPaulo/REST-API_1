package com.carolinapaulo.oscarol.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.carolinapaulo.oscarol.domain.model.StatusOrdemServico;

public class OrdemServicoModel {

		private Long id;
		private String nomeClient;
		private String descricao;
		private BigDecimal preco;
		private StatusOrdemServico status;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNomeClient() {
			return nomeClient;
		}
		public void setNomeClient(String nomeClient) {
			this.nomeClient = nomeClient;
		}
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
		public StatusOrdemServico getStatus() {
			return status;
		}
		public void setStatus(StatusOrdemServico status) {
			this.status = status;
		}
		public OffsetDateTime getDataAbertura() {
			return dataAbertura;
		}
		public void setDataAbertura(OffsetDateTime dataAbertura) {
			this.dataAbertura = dataAbertura;
		}
		public OffsetDateTime getDataFinalizacao() {
			return dataFinalizacao;
		}
		public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
			this.dataFinalizacao = dataFinalizacao;
		}
		private OffsetDateTime dataAbertura;
		private OffsetDateTime dataFinalizacao;
		
		
		
}
