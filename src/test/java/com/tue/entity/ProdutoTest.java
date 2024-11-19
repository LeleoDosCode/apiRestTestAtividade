package com.tue.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	private Produto produto;
	
	@BeforeEach
	void setUp() {
		produto = new Produto(1L, "Beyblade", "Pião gourmet", 200);
	}
	
	@Test
	@DisplayName("Id")
	void testId() {
		produto.setId(2L);
		
		assertEquals(2L, produto.getId());
	}
	
	@Test
	@DisplayName("Construtor com args")
	void testConstructorAll() {
		
		Produto novoproduto = new Produto(3L, "Pião","Beyblade véio",100);
		
		assertAll("novoproduto",
				()-> assertEquals(3L, novoproduto.getId()),
				()-> assertEquals("Pião", novoproduto.getNome()),
				()-> assertEquals("Pião", novoproduto.getDesc()),
				()-> assertEquals("Pião", novoproduto.getPreco())
				
				);
	}

};