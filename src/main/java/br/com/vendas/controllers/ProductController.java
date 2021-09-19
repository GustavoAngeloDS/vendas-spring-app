package br.com.vendas.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
