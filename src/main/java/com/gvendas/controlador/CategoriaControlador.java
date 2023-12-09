package com.gvendas.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.entidades.Categoria;
import com.gvendas.servico.CategoriaServico;

@RestController

@CrossOrigin(origins = "http://localhost:5173/")

@RequestMapping("/categorias")
public class CategoriaControlador {

	
	@Autowired
	private CategoriaServico categoriaServico;
	
	@GetMapping
	public List<Categoria> listarTodas(){
		
		return categoriaServico.listarTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categoria>> buscarPorId( @PathVariable Integer id){
		
		Optional<Categoria> categoria = categoriaServico.buscarPorId(id);
		
		return categoria.isPresent() ? ResponseEntity.ok(categoria): ResponseEntity.notFound().build();
		}
	
	@PostMapping
	public ResponseEntity<Categoria> salvar (@RequestBody Categoria categoria){

		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaServico.salvar(categoria));
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Categoria> atualizar (@PathVariable int id, @RequestBody Categoria categoria){
		
		return ResponseEntity.ok(categoriaServico.atualizar(id, categoria));
	}
	@DeleteMapping ("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		categoriaServico.deletar(id);
		
	}
	}

