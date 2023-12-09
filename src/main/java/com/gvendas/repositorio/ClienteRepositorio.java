package com.gvendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvendas.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>  {

}
