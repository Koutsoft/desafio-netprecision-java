package br.com.netprecision.testetecnico.vitoriaoliveira.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netprecision.testetecnico.vitoriaoliveira.dto.PrecoTotalDTO;
import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.Pedido;
import br.com.netprecision.testetecnico.vitoriaoliveira.service.PedidoService;

@CrossOrigin
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@GetMapping
	public List<Pedido> listarPedidos() {
		return pedidoService.listarPedidos();
	}

	@PostMapping
	public Pedido salvarPedido() {
		return pedidoService.salvarPedido();
	}

	@PutMapping("{idPedido}/{idProduto}/{quantidade}")
	public Pedido adicionarProduto(@PathVariable("idPedido") Long idPedido, @PathVariable("idProduto") Long idProduto,
			@PathVariable("quantidade") int quantidade) {
		return pedidoService.adicionarProduto(idPedido, idProduto, quantidade);
	}
	
	@PutMapping("{idPedido}/{valorPago}")
	public PrecoTotalDTO fecharPedido(@PathVariable("idPedido") Long idPedido,@PathVariable("valorPago") BigDecimal valorPago) {
		return pedidoService.fecharPedido(idPedido, valorPago);
	}
	
	@GetMapping("{id}")
	public PrecoTotalDTO calcularPedido (@PathVariable("id") Long id) {
		return pedidoService.calcularPedido(id);
	}
	
	
	@DeleteMapping("{idPedido}")
	public Pedido removerPedido(@PathVariable("idPedido") Long idPedido) {
		return pedidoService.removerPedido(idPedido);
	}
	
	
	@DeleteMapping("{idPedido}/{idProduto}/{quantidade}")
	public Pedido removerPedido(@PathVariable("idPedido") Long idPedido, @PathVariable("idProduto") Long idProduto,
			@PathVariable("quantidade") int quantidade) {
		return pedidoService.removerProduto(idPedido, idProduto, quantidade);
	}
	

//	
//	@DeleteMapping("{id}")
//	public void deletarProduto(@PathVariable("id") Long id) {
//		pedidoRepositoy.deleteById(id);
//	}
}
