package service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.Main;
import test.Member;
import test.Product;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tolgacaner on 26/04/16.
 */
@Service("productService")
@Transactional
public class ProductService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Product> products;

    static{
        //	members= populateDummyUsers();
        Session session = Main.getSession();
        Query query = session.createQuery("from Product ");
        products = query.list();
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
