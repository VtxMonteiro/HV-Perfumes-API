package com.gvendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gvendas.entidades.Item;

public interface ItemRepositorio extends JpaRepository<Item, Integer>{

}
