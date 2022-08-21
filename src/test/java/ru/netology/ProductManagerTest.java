package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;



public class ProductManagerTest {

    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1, "Book1", 100, "Author1");
    Book book2 = new Book(2, "Book2", 200, "Author2");
    Book book3 = new Book(3, "Book3", 300, "Author3");
    Smartphone smartphone1 = new Smartphone(1,"Smartphone1",1000, "Manufacturer1");
    Smartphone smartphone2 = new Smartphone(2,"Smartphone2",2000, "Manufacturer2");
    Smartphone smartphone3 = new Smartphone(3,"Smartphone3",3000, "Manufacturer3");




    @Test
    public void searchByTheWordBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);


        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Book");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTheWordBook3() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);


        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Book3");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTheWordSketchbook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);


        Product[] expected = {};
        Product[] actual = manager.searchBy("sketchbook");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTheWordSmartphone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.searchBy("Smartphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTheWordSmartphone2() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("Smartphone2");

        assertArrayEquals(expected, actual);
    }


    @Test
    public void searchByTheWordPhone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] expected = {};
        Product[] actual = manager.searchBy("Phone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTheWordManufacturer1() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] expected = {};
        Product[] actual = manager.searchBy("Manufacturer1");

        assertArrayEquals(expected, actual);
    }
}
