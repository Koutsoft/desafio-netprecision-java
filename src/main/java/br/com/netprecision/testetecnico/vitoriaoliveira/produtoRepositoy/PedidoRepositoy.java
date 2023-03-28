package br.com.netprecision.testetecnico.vitoriaoliveira.produtoRepositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.Pedido;

@Repository
public interface PedidoRepositoy extends JpaRepository<Pedido, Long> {
	
	   

}
