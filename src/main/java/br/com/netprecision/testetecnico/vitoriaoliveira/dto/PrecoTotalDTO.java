package br.com.netprecision.testetecnico.vitoriaoliveira.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrecoTotalDTO {
	private BigDecimal precoTotal;
	private BigDecimal valorPago;
	private BigDecimal troco;

	public PrecoTotalDTO(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
}
