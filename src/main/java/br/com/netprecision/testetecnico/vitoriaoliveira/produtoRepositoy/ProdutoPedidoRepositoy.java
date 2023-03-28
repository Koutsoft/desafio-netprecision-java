package br.com.netprecision.testetecnico.vitoriaoliveira.produtoRepositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.ProdutoPedido;
import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.ProdutoPedidoId;

@Repository
public interface ProdutoPedidoRepositoy extends JpaRepository<ProdutoPedido, ProdutoPedidoId> {

}
