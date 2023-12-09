package com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.gvendas.entidades.Categoria;
import com.gvendas.repositorio.CategoriaRepositorio;


@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	public List<Categoria> listarTodas(){
			
		return categoriaRepositorio.findAll();
	}
	
	public Optional<Categoria> buscarPorId(Integer id){
		
		return categoriaRepositorio.findById(id);
	}
	
	public Categoria salvar (Categoria categoria) {
		
		return categoriaRepositorio.save(categoria);
	}
	
	public Categoria atualizar (int id, Categoria categoria) {
		
		Categoria categoriaSalvar = validarCategoriaExiste(id);
		BeanUtils.copyProperties(categoria, categoriaSalvar, "id");
		return categoriaRepositorio.save(categoriaSalvar);
	}

	private Categoria validarCategoriaExiste(int id) {
		Optional<Categoria> categoria = buscarPorId(id);
		if(categoria.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoria.get();
	}
	
	public void deletar (int id) {
		
		categoriaRepositorio.deleteById(id);
	}
	
	}
	

