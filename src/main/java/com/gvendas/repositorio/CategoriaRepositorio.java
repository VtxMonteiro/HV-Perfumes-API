package com.gvendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvendas.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

}
