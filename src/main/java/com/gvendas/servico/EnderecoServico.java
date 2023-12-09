package com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.entidades.Endereco;
import com.gvendas.repositorio.EnderecoRepositorio;

@Service
public class EnderecoServico {
		
		@Autowired
		private EnderecoRepositorio enderecoRepositorio;
		
		public List<Endereco> listarTodas(){
				
			return enderecoRepositorio.findAll();
		}
		
		public Optional<Endereco> buscarPorId(Integer id){
			
			return enderecoRepositorio.findById(id);
		}
		
		public Endereco salvar (Endereco endereco) {
			
			return enderecoRepositorio.save(endereco);
		}
		
		public Endereco atualizar (int id, Endereco endereco) {
			
			Endereco enderecoSalvar = validarEnderecoExiste(id);
			BeanUtils.copyProperties(endereco, enderecoSalvar, "id");
			return enderecoRepositorio.save(enderecoSalvar);
		}

		private Endereco validarEnderecoExiste(int id) {
			Optional<Endereco> endereco = buscarPorId(id);
			if(endereco.isEmpty()) {
				throw new EmptyResultDataAccessException(1);
			}
			return endereco.get();
		}
		
		public void deletar (int id) {
			
			enderecoRepositorio.deleteById(id);
		}
}
