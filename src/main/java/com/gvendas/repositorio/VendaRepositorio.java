package com.gvendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gvendas.entidades.Venda;

public interface VendaRepositorio  extends JpaRepository<Venda, Integer>{

}
