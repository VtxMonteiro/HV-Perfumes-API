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

import com.gvendas.entidades.Endereco;
import com.gvendas.servico.EnderecoServico;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/Enderecos")
public class EnderecoControlador {
	
	
	
		
		@Autowired
		private EnderecoServico enderecoServico;
		
		@GetMapping
		public List<Endereco> listarTodas(){
			
			return enderecoServico.listarTodas();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Optional<Endereco>> buscarPorId( @PathVariable Integer id){
			
			Optional<Endereco> endereco = enderecoServico.buscarPorId(id);
			
			return endereco.isPresent() ? ResponseEntity.ok(endereco): ResponseEntity.notFound().build();
			}
		
		@PostMapping
		public ResponseEntity<Endereco> salvar (@RequestBody Endereco endereco){

			return ResponseEntity.status(HttpStatus.CREATED).body(enderecoServico.salvar(endereco));
		}
		
		@PutMapping ("/{id}")
		public ResponseEntity<Endereco> atualizar (@PathVariable int id, @RequestBody Endereco endereco){
			
			return ResponseEntity.ok(enderecoServico.atualizar(id, endereco));
		}
		@DeleteMapping ("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable int id) {
			enderecoServico.deletar(id);
			
		}

}
