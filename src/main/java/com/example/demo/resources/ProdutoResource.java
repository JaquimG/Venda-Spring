package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/venda")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository pr;
	
	@PostMapping
	public Produto cadastra(@RequestBody Produto produto) {
		return pr.save(produto);
	}
	
	@GetMapping
	public @ResponseBody Iterable<Produto> listar(){
		Iterable<Produto> produto = pr.findAll();
		return produto;
	}
	
	@DeleteMapping
	public String deleta(@RequestBody Produto produto) {
		pr.delete(produto);
		return "deu bom";
	}
}
