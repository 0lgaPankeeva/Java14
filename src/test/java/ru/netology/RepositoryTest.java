package ru.netology;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepositoryTest {
    Repository repository = new Repository();


    Book book1 = new Book(1, "Book1", 100, "Author1");
    Book book2 = new Book(2, "Book2", 200, "Author2");
    Book book3 = new Book(3, "Book3", 300, "Author3");
    Smartphone smartphone1 = new Smartphone(1, "Smartphone1", 1000, "Manufacturer1");
    Smartphone smartphone2 = new Smartphone(2, "Smartphone2", 2000, "Manufacturer2");
    Smartphone smartphone3 = new Smartphone(3, "Smartphone3", 3000, "Manufacturer3");


    @Test
    public void removeById() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);

        repository.removeById(3);

        Product[] expected = {book1, book2};
        Product[] actual = repository.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundException() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(4);
        });
    }

    @Test
    public void notFoundException1() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(7);
        });
    }


    @Test
    public void findAll() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void add() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);


        Product[] expected = {book1, book2, book3};
        Product[] actual = repository.getProducts();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void addSmartphone() {
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.getProducts();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void removeByIdSmartphone() {
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);
        repository.removeById(3);

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = repository.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdSmartphone1() {
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);
        repository.removeById(1);

        Product[] expected = {smartphone2, smartphone3};
        Product[] actual = repository.getProducts();

        assertArrayEquals(expected, actual);
    }
}
