package service.product;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.Main;
import rest.Member;
import rest.Product;

@Service("productService")
@Transactional
@Controller
public class ProductServiceImpl implements ProductService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<Product> products;

	static{
	//	products= populateDummyProducts();
		Session session = Main.getSession();
		Query query = session.createQuery("from Product").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		products = query.list();

	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product findById(long id) {
		for(Product product : products){
			if(product.getId() == id){
				return product;
			}
		}
		return null;
	}

	public Product findByName(String name) {
		for(Product product : products){
			if(product.getProductName().equalsIgnoreCase(name)){
				return product;
			}
		}
		return null;
	}

	public void saveProduct(Product product) {
		product.setId(nextId());
		products.add(product);
		Session session = Main.getSession();
		Transaction tx = session.beginTransaction();
		session.save(product);
		tx.commit();
		session.close();

	}

	public void updateProduct(Product product) {
		Product pProduct = findById(product.getId());
		int index = products.indexOf(pProduct);
		products.set(index, product);
		Session session = Main.getSession();
		Transaction tx = session.beginTransaction();
		session.update(product);
		tx.commit();
		session.close();
	}

	public void deleteProductById(long id) {
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
			Product product = iterator.next();
		    if (product.getId() == id) {
		        iterator.remove();
				Session session = Main.getSession();
				Transaction tx = session.beginTransaction();
				session.delete(product);
				tx.commit();
				session.close();
				break;
		    }
		}
	}

	public boolean isProductExist(Product product) {
		return findByName(product.getProductName())!=null;
	}

	public void deleteAllProducts(){
		products.clear();
	}

	private static int nextId() {
		return (int) counter.incrementAndGet();
	}

}
