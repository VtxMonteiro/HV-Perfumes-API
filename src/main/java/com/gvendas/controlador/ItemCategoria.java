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

import com.gvendas.entidades.Item;
import com.gvendas.servico.ItemServico;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/Items")
public class ItemCategoria {
	
	@Autowired
	private ItemServico itemServico;
	
	@GetMapping
	public List<Item> listarTodas(){
		
		return itemServico.listarTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Item>> buscarPorId( @PathVariable Integer id){
		
		Optional<Item> item = itemServico.buscarPorId(id);
		
		return item.isPresent() ? ResponseEntity.ok(item): ResponseEntity.notFound().build();
		}
	
	@PostMapping
	public ResponseEntity<Item> salvar (@RequestBody Item item){

		return ResponseEntity.status(HttpStatus.CREATED).body(itemServico.salvar(item));
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Item> atualizar (@PathVariable int id, @RequestBody Item item){
		
		return ResponseEntity.ok(itemServico.atualizar(id, item));
	}
	@DeleteMapping ("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		itemServico.deletar(id);
		
	}

}
