package com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.entidades.Item;
import com.gvendas.repositorio.ItemRepositorio;

@Service
public class ItemServico {

	@Autowired
	private ItemRepositorio itemRepositorio;
	
	public List<Item> listarTodas(){
			
		return itemRepositorio.findAll();
	}
	
	public Optional<Item> buscarPorId(Integer id){
		
		return itemRepositorio.findById(id);
	}
	
	public Item salvar (Item item) {
		
		return itemRepositorio.save(item);
	}
	
	public Item atualizar (int id, Item item) {
		
		Item itemSalvar = validarItemExiste(id);
		BeanUtils.copyProperties(item, itemSalvar, "id");
		return itemRepositorio.save(itemSalvar);
	}

	private Item validarItemExiste(int id) {
		Optional<Item> item = buscarPorId(id);
		if(item.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return item.get();
	}
	
	public void deletar (int id) {
		
		itemRepositorio.deleteById(id);
	}
	
}
