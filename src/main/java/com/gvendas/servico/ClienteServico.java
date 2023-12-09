package com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.entidades.Cliente;
import com.gvendas.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public List<Cliente> listarTodas(){
			
		return clienteRepositorio.findAll();
	}
	
	public Optional<Cliente> buscarPorId(Integer id){
		
		return clienteRepositorio.findById(id);
	}
	
	public Cliente salvar (Cliente cliente) {
		
		return clienteRepositorio.save(cliente);
	}
	
	public Cliente atualizar (int id, Cliente cliente) {
		
		Cliente clienteSalvar = validarClienteExiste(id);
		BeanUtils.copyProperties(cliente, clienteSalvar, "id");
		return clienteRepositorio.save(clienteSalvar);
	}

	private Cliente validarClienteExiste(int id) {
		Optional<Cliente> cliente = buscarPorId(id);
		if(cliente.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cliente.get();
	}
	
	public void deletar (int id) {
		
		clienteRepositorio.deleteById(id);
	}
	
		
}
