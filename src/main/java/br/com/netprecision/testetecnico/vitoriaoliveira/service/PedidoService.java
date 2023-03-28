package br.com.netprecision.testetecnico.vitoriaoliveira.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.netprecision.testetecnico.vitoriaoliveira.dto.PrecoTotalDTO;
import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.Pedido;
import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.Produto;
import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.ProdutoPedido;
import br.com.netprecision.testetecnico.vitoriaoliveira.produtoRepositoy.PedidoRepositoy;
import br.com.netprecision.testetecnico.vitoriaoliveira.produtoRepositoy.ProdutoPedidoRepositoy;

@Service
public class PedidoService {

	@Autowired
	PedidoRepositoy pedidoRepositoy;
	@Autowired
	ProdutoService produtoService;
	@Autowired
	ProdutoPedidoRepositoy produtoPedidoRepositoy;

	public List<Pedido> listarPedidos() {
		return pedidoRepositoy.findAll();
	}

	public Pedido buscarPedidoPorId(Long idPedido) {
		return pedidoRepositoy.findById(idPedido).get();
	}

	public Pedido salvarPedido() {
		return pedidoRepositoy.save(new Pedido());
	}

	public Pedido adicionarProduto(Long idPedido, Long idProduto, int quantidade) {
		Pedido pedido = pedidoRepositoy.findById(idPedido).get();
		Produto listarProdutoPorID = produtoService.listarProdutoPorID(idProduto);
		ProdutoPedido produtoPedido = new ProdutoPedido();
		produtoPedido.setQuantidade(quantidade);
		produtoPedido.getId().setPedido(pedido);
		produtoPedido.getId().setProduto(listarProdutoPorID);

		produtoPedidoRepositoy.save(produtoPedido);
		return pedidoRepositoy.findById(idPedido).get();
	}

	public PrecoTotalDTO calcularPedido(Long idPedido) {
		BigDecimal total = BigDecimal.ZERO;
		Pedido pedido = pedidoRepositoy.findById(idPedido).get();
		for (ProdutoPedido produtoPedido : pedido.getProdutos()) {
			BigDecimal preco = produtoPedido.getId().getProduto().getPreco();
			int quantidade = produtoPedido.getQuantidade();
			BigDecimal multiply = preco.multiply(BigDecimal.valueOf(quantidade));
			total = total.add(multiply);
		}
		return new PrecoTotalDTO(total);
	}

	public PrecoTotalDTO fecharPedido(Long idPedido, BigDecimal valorPago) {
		PrecoTotalDTO precoTotalDTO = calcularPedido(idPedido);
		precoTotalDTO.setValorPago(valorPago);
		BigDecimal valorTotal = precoTotalDTO.getPrecoTotal();
		BigDecimal subtract = precoTotalDTO.getValorPago().subtract(valorTotal);
		if (subtract.compareTo(BigDecimal.ZERO) < 0) {
			throw new RuntimeException("Valor do troco é menor que o valor pago");
		}
		precoTotalDTO.setTroco(subtract);
		return precoTotalDTO;
	}

	public Pedido removerPedido(Long idPedido) {
		Optional<Pedido> removerPedido = pedidoRepositoy.findById(idPedido);
		if (removerPedido.isPresent()) {
			Pedido pedido = removerPedido.get();
			pedidoRepositoy.deleteById(idPedido);
			return pedido;
		}
		return null;
	}

	public Pedido removerProduto(Long idPedido, Long idProduto, int quantidade) {
		Pedido pedido = pedidoRepositoy.findById(idPedido).get();
		for (ProdutoPedido produtoPedido : pedido.getProdutos()) {
			if (produtoPedido.getId().getProduto().getIdProduto().equals(idProduto)) {
				int novaQuantidade = produtoPedido.getQuantidade() - quantidade;
				if (novaQuantidade <= 0) {
					pedido.getProdutos().remove(produtoPedido);
				} else {
					produtoPedido.setQuantidade(novaQuantidade);
				}
				break;
			}
		}
		pedidoRepositoy.save(pedido);
		return pedido;
	}

}
