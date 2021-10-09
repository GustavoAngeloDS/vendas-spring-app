package br.com.vendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendas.models.Product;
import br.com.vendas.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product save(Product product){
		return productRepository.save(product);
	}
	
	public void remove(Product product) {
		Optional<Product> productToRemove = productRepository.findById(product.getId());
		
		if(productToRemove.isPresent())
			productRepository.delete(product);
	}
	
	public Product update(Product product) {
		Optional<Product> productToUpdate = productRepository.findById(product.getId());
		Product updatedProduct = new Product();
		
		if(productToUpdate.isPresent()) 
			updatedProduct  = productRepository.save(product);
		
		return updatedProduct;
	}
}
