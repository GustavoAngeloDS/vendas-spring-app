package br.com.vendas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.dtos.ProductDto;
import br.com.vendas.models.Product;
import br.com.vendas.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid ProductDto productDto){
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);		
		
		return productService.save(product);
	}
	
	@GetMapping
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") Integer productId){
		return productService.findById(productId);
	}
	
	@DeleteMapping
	public ResponseEntity<?> remove(@RequestBody Product product){		
		return productService.remove(product);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Product product){
		return productService.update(product);
	}
}
