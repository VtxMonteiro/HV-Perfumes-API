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

import com.gvendas.entidades.Venda;
import com.gvendas.servico.VendaServico;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/Vendas")
public class VendaControlador {

	@Autowired
	private VendaServico vendaServico;
	
	@GetMapping
	public List<Venda> listarTodas(){
		
		return vendaServico.listarTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Venda>> buscarPorId( @PathVariable Integer id){
		
		Optional<Venda> produto = vendaServico.buscarPorId(id);
		
		return produto.isPresent() ? ResponseEntity.ok(produto): ResponseEntity.notFound().build();
		}
	
	@PostMapping
	public ResponseEntity<Venda> salvar (@RequestBody Venda venda){

		return ResponseEntity.status(HttpStatus.CREATED).body(vendaServico.salvar(venda));
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Venda> atualizar (@PathVariable int id, @RequestBody Venda venda){
		
		return ResponseEntity.ok(vendaServico.atualizar(id, venda));
	}
	@DeleteMapping ("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		vendaServico.deletar(id);
		
	}
}
