package com.tue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tue.entity.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}
