package com.gvendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvendas.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}