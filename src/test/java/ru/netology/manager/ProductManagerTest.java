package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "Brave New World", 500,"Aldous Huxley");
    Product product2 = new Book(2,"The Gadfly", 300, "Ethel Lilian Voynich");
    Product product3 = new Smartphone(3,"Honor", 5000, "Huawei");
    Product product4 = new Smartphone(4, "Sony", 3000, "Sony");

    @BeforeEach
    void setUp() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] expected = {new Book(1, "Brave New World", 500,"Aldous Huxley")};
        Product[] actual = manager.searchBy("Aldous Huxley");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthor() {
        Product[] expected = {new Book(2,"The Gadfly", 300, "Ethel Lilian Voynich")};
        Product[] actual = manager.searchBy("Ethel Lilian Voynich");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = {new Smartphone(3,"Honor", 5000, "Huawei")};
        Product[] actual = manager.searchBy("Honor");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = {new Smartphone(4, "Sony", 3000, "Sony")};
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(expected, actual);
    }

    @Test
    void  shouldFindAll() {
        repository.findAll();
        Product[] expected = new Product[]{product1,product2, product3, product4};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
