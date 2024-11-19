package com.tue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tue.entity.Produto;
import com.tue.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> getAllProduto(){
		return produtoRepository.findAll();
	}
	
	public Produto getProdutoById(Long id) {
		Optional<Produto> Produto = produtoRepository.findById(id);
		return Produto.orElse(null);
	}
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto updateProduto(Long id, Produto updateProduto) {
		Optional<Produto> existingProduto = produtoRepository.findById(id);
		if(existingProduto.isPresent()) {
			updateProduto.setId(id);
			return produtoRepository.save(updateProduto);
		}
		return null;
	}
	
	public boolean deleteProduto(Long id) {
		Optional<Produto> existingProduto = produtoRepository.findById(id);
		if(existingProduto.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
