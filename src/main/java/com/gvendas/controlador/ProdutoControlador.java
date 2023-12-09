package com.gvendas.controlador;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gvendas.entidades.Produto;
import com.gvendas.servico.ProdutoServico;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/Produtos")
public class ProdutoControlador {

	private static final String UPLOAD_DIR = "src/main/webapp/imagens/";
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@GetMapping
	public List<Produto> listarTodas(){
		
		return produtoServico.listarTodas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> buscarPorId( @PathVariable Integer id){
		
		Optional<Produto> produto = produtoServico.buscarPorId(id);
		
		return produto.isPresent() ? ResponseEntity.ok(produto): ResponseEntity.notFound().build();
		}
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Produto> salvar (@RequestParam("foto") MultipartFile foto,
            @RequestPart(value="produto") Produto produto){
		
		if (foto.isEmpty()) 
            return null;
        try {
            // Obtenha o caminho completo para o diretório de destino
            String fullPath = UPLOAD_DIR + foto.getOriginalFilename();
            Path destinationPath = Paths.get(fullPath);

            // Salve o arquivo no diretório de destino
            Files.write(destinationPath, foto.getBytes());
            produto.setImagem("/imagens/"+foto.getOriginalFilename());

            return ResponseEntity.status(HttpStatus.CREATED).body(produtoServico.salvar(produto));
        }catch (Exception e) {
			// TODO: handle exception
		}
        return null;
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Produto> atualizar (@PathVariable int id, @RequestBody Produto produto){
		
		return ResponseEntity.ok(produtoServico.atualizar(id, produto));
	}
	@DeleteMapping ("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		produtoServico.deletar(id);
		
	}
	}
