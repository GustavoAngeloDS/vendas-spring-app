package br.com.vendas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.vendas.exceptions.VendasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendas.models.OrderItem;
import br.com.vendas.models.Product;
import br.com.vendas.repositories.OrderItemRepository;
import br.com.vendas.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product save(Product product){
		return productRepository.save(product);
	}
	
	public String remove(Product product) {
		if(isProductInActiveOrder(product.getId()))
			return VendasException.PRODUCT_IN_ACTIVE_ORDER;

		Optional<Product> productToRemove = productRepository.findById(product.getId());
		if(productToRemove.isPresent())
			productRepository.delete(product);

		return "";
	}
	
	public Boolean isProductInActiveOrder(Integer productId) {
		List<OrderItem> allOrders = new ArrayList<OrderItem>();
		allOrders = orderItemRepository.findAll();
		
		Boolean isProducInActiveOrder = false;
		
		for(OrderItem orderItem : allOrders) {
			if(orderItem.getProduct().getId() == productId) {
				isProducInActiveOrder = true;
			}
		}
		
		return isProducInActiveOrder;
	}
	
	public Product update(Product product) {
		Optional<Product> productToUpdate = productRepository.findById(product.getId());
		Product updatedProduct = new Product();
		
		if(productToUpdate.isPresent()) 
			updatedProduct  = productRepository.save(product);
		
		return updatedProduct;
	}

	public List<Product> findProductByText(String text){
		return productRepository.findProductByText(text);
	}
}
