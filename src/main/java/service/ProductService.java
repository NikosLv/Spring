package service;

import java.util.List;

import entity.Product;

public interface ProductService {
	
	void saveProduct(Product product);
	
	List<Product> findAllProducts();
	
	Product findProductById(int id);
	
	void deleteProductById(int id); 
	
	//void editProductById(int id);
		


}
