package br.com.netprecision.testetecnico.vitoriaoliveira.produtoRepositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
