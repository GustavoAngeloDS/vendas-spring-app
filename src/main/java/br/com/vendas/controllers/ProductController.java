package br.com.vendas.controllers;

import java.util.List;

import javax.validation.Valid;

import br.com.vendas.responses.ErrorResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		
		return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
	}
	
	@GetMapping
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") Integer productId){
		return new ResponseEntity<>(productService.findById(productId), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> remove(@RequestBody Product product){
		String response = productService.remove(product);
		if(response.equals("")) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else
			return new ResponseEntity<>(ErrorResponse.builder().message(response).build(), HttpStatus.FORBIDDEN);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Product product){
		return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
	}

	@GetMapping("/search/{text}")
	public List<Product> findByText(@PathVariable(value="text") String text){
		return productService.findProductByText(text);
	}
}
