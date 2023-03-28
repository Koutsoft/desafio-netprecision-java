package br.com.netprecision.testetecnico.vitoriaoliveira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.netprecision.testetecnico.vitoriaoliveira.etidades.Produto;
import br.com.netprecision.testetecnico.vitoriaoliveira.produtoRepositoy.ProdutoRepository;
@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto listarProdutoPorID(Long id) {
		return produtoRepository.findById(id).get();
	}

	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}
}
