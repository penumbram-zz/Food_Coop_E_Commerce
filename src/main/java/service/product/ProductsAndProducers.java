package service.product;

import rest.Producer;
import rest.Product;

import java.util.List;

/**
 * Created by tolgacaner on 22/05/16.
 */
public class ProductsAndProducers {
    public List<Product> products;
    public List<Producer> producers;

    public ProductsAndProducers(List<Product> products, List<Producer> producers) {
        this.products = products;
        this.producers = producers;
    }
}
