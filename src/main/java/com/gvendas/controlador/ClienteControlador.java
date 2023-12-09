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

import com.gvendas.entidades.Cliente;
import com.gvendas.servico.ClienteServico;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/Clientes")
public class ClienteControlador {
	
	@Autowired
	private ClienteServico clienteServico;
	
	@GetMapping
	public List<Cliente> listarTodas(){
		
		return clienteServico.listarTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> buscarPorId( @PathVariable Integer id){
		
		Optional<Cliente> produto = clienteServico.buscarPorId(id);
		
		return produto.isPresent() ? ResponseEntity.ok(produto): ResponseEntity.notFound().build();
		}
	
	@PostMapping
	public ResponseEntity<Cliente> salvar (@RequestBody Cliente cliente){

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteServico.salvar(cliente));
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Cliente> atualizar (@PathVariable int id, @RequestBody Cliente cliente){
		
		return ResponseEntity.ok(clienteServico.atualizar(id, cliente));
	}
	@DeleteMapping ("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		clienteServico.deletar(id);
		
	}

}
