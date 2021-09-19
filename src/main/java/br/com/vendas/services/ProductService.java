package br.com.vendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.vendas.models.Product;
import br.com.vendas.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ResponseEntity<?> findById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		ResponseEntity<?> response;
		
		response = product.isPresent() ? 
			new ResponseEntity<>(product.get(), HttpStatus.OK) : 
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return response;
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public ResponseEntity<?> save(Product product){
		Product newProduct = productRepository.save(product);
		return new ResponseEntity<>(newProduct, HttpStatus.OK);
	}
}
