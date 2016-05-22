package service.product;

import java.util.List;
import rest.Member;
import rest.Product;


public interface ProductService {
	
	Product findById(long id);

	Product findByName(String name);
	
	void saveProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProductById(long id);

	List<Product> getAllProducts();
	
	void deleteAllProducts();
	
	public boolean isProductExist(Product member);
	
}
