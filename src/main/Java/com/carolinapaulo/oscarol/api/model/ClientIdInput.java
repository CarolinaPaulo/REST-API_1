package com.carolinapaulo.oscarol.api.model;

import javax.validation.constraints.NotNull;

public class ClientIdInput {
		
		@NotNull
		private Long id;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		
}
