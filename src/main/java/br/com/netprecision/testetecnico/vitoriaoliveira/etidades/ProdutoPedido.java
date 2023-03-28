package br.com.netprecision.testetecnico.vitoriaoliveira.etidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "produto_pedido")
public class ProdutoPedido {
	@EmbeddedId
	private ProdutoPedidoId id = new ProdutoPedidoId();
	
	private int quantidade;
	

}
