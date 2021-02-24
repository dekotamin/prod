package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.ProductRepository;

public class ProductManager {
    private Product[] products = new Product[0];

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        ProductRepository repository = null;
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(products,0, tmp, 0, products.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}