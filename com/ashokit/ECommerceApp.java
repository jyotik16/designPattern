package com.ashokit;

import t2.Product;

//Abstract Factory interface for creating product objects
interface ProductFactory {
 public Product createProduct();
}

//Concrete Factory for creating book products
class BookFactory implements ProductFactory {
 public Product createProduct() {
     return new Book();
 }
}

//Concrete Factory for creating electronic products
class ElectronicFactory implements ProductFactory {
 public Product createProduct() {
     return new Electronic();
 }
}

//Abstract Product interface for defining product behavior
interface Product {
 public void info();
}

//Concrete Product class for book products
class Book implements Product {
 public void info() {
     System.out.println("This is a book.");
 }
}

//Concrete Product class for electronic products
class Electronic implements Product {
 public void info() {
     System.out.println("This is an electronic product.");
 }
}

//Client code that uses the Abstract Factory to create products
public class ECommerceApp {
 public static void main(String[] args) {
     // Create a BookFactory and use it to create a Book product
     ProductFactory bookFactory = new BookFactory();
     Product book = bookFactory.createProduct();
     book.info();

     // Create an ElectronicFactory and use it to create an Electronic product
     ProductFactory electronicFactory = new ElectronicFactory();
     Product electronic = electronicFactory.createProduct();
     electronic.info();
 }
}

