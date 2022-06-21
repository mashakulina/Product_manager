package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Book book1 = new Book(1, "Harry Potter", "J.K. Rowling", 800);
    Smartphone smartphone1 = new Smartphone(2, "Iphone 13", "Apple", 150_000);
    Book book2 = new Book(3, "A Game of Thrones", "George R.R.Martin", 1500);
    Smartphone smartphone2 = new Smartphone(4, "Redmi Note 11S", "Xiaomi", 8000);
    ProductRepository repository = new ProductRepository();

    @Test
    public void saveProducts() {
        repository.save(book1);
        repository.save(smartphone1);
        repository.save(book2);
        repository.save(smartphone2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, smartphone1, book2, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repository.save(book1);
        repository.save(smartphone1);
        repository.save(book2);
        repository.save(smartphone2);

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, smartphone2};
    }

    @Test
    public void removeBynNonEexistentId() {
        repository.save(book1);
        repository.save(smartphone1);
        repository.save(book2);
        repository.save(smartphone2);

        repository.removeById(5);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, smartphone1, book2, smartphone2};
    }
}