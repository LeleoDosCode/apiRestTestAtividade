package com.tue.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tue.entity.Produto;

@DataJpaTest
class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@DisplayName("Tenstando Save")
	@Test
	void testSalvarRepositry() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "2d","15", 2);
		
		//when / act
		Produto saveProduto = produtoRepository.save(produto1);
		
		//Then / Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
		
	}
	
	@DisplayName("Tenstando Save")
	@Test
	void testGetAllRepository() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "2d","15", 2);
		Produto produto2 = new Produto(null, "2d","15", 2);
		
		//when / act
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);
		
		List<Produto> produtoList = produtoRepository.findAll();
		
		//Then / Assert
		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testGetById() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "2d","15", 2);
				
		//when / act
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveProduto);
		assertEquals(produto1.getId(),saveProduto.getId());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testUpdateProduto() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "2d","15", 2);
				
		//when / act
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("2D");
		produto1.setDesc("15");
		produto1.setPreco(5);
		
		Produto updateProduto = produtoRepository.save(saveProduto);
		//Then / Assert
		assertNotNull(updateProduto);
		assertEquals("2D", updateProduto.getNome());
		assertEquals("15", updateProduto.getDesc());
		assertEquals(5, updateProduto.getPreco());
		
	}
	@DisplayName("By ID")
	@Test
	void testDeleteProduto() {
		
		//given / Arrange
		Produto produto1 = new Produto(null, "2d","15", 2);
				
		//when / act
		produtoRepository.save(produto1);
		
		produtoRepository.deleteById(produto1.getId());
		
		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());
		//Then / Assert
		assertNotNull(produtoOptional);

	}
	
	
	
	

}