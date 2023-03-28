package br.com.netprecision.testetecnico.vitoriaoliveira.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.Produto;
import br.com.netprecision.testetecnico.vitoriaoliveira.service.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	@PostMapping
	public Produto salvarProduto(@RequestBody @Valid Produto produto) {
		return produtoService.salvarProduto(produto);
	}
	
	@GetMapping("{id}")
	public Produto listarProdutoPorID(@PathVariable("id") Long id) {
		return produtoService.listarProdutoPorID(id);
	}
	
	@DeleteMapping("{id}")
	public void deletarProduto(@PathVariable("id") Long id) {
		produtoService.deletarProduto(id);
	}
}
