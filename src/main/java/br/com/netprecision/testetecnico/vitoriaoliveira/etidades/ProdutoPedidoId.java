package br.com.netprecision.testetecnico.vitoriaoliveira.etidades;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
public class ProdutoPedidoId implements Serializable {

	@ManyToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;
	
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;

}