package com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.entidades.Produto;
import com.gvendas.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	public List<Produto> listarTodas(){
			
		return produtoRepositorio.findAll();
	}
	
	public Optional<Produto> buscarPorId(Integer id){
		
		return produtoRepositorio.findById(id);
	}
	
	public Produto salvar (Produto produto) {
		
		return produtoRepositorio.save(produto);
	}
	
	public Produto atualizar (int id, Produto produto) {
		
		Produto produtoSalvar = validarProdutoExiste(id);
		BeanUtils.copyProperties(produto, produtoSalvar, "id");
		return produtoRepositorio.save(produtoSalvar);
	}

	private Produto validarProdutoExiste(int id) {
		Optional<Produto> produto = buscarPorId(id);
		if(produto.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return produto.get();
	}
	
	public void deletar (int id) {
		
		produtoRepositorio.deleteById(id);
	}
	
		
}
