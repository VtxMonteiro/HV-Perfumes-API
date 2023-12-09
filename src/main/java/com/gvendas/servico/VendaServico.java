package com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.entidades.Venda;
import com.gvendas.repositorio.VendaRepositorio;


@Service
public class VendaServico {
	
	@Autowired
	private VendaRepositorio vendaRepositorio;
	
	public List<Venda> listarTodas(){
			
		return vendaRepositorio.findAll();
	}
	
	public Optional<Venda> buscarPorId(Integer id){
		
		return vendaRepositorio.findById(id);
	}
	
	public Venda salvar (Venda venda) {
		
		return vendaRepositorio.save(venda);
	}
	
	public Venda atualizar (int id, Venda venda) {
		
		Venda vendaSalvar = validarVendaExiste(id);
		BeanUtils.copyProperties(venda, vendaSalvar, "id");
		return vendaRepositorio.save(vendaSalvar);
	}

	private Venda validarVendaExiste(int id) {
		Optional<Venda> venda = buscarPorId(id);
		if(venda.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return venda.get();
	}
	
	public void deletar (int id) {
		
		vendaRepositorio.deleteById(id);
	}

}
