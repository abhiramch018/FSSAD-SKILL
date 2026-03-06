
package com.example.library;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class LibraryController {

    List<Book> books = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Online Library System";
    }

    @GetMapping("/count")
    public int count(){
        return 120;
    }

    @GetMapping("/price")
    public double price(){
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> books(){
        return Arrays.asList("Spring Boot", "Java Programming", "Data Structures", "Microservices");
    }

    @GetMapping("/books/{id}")
    public String bookById(@PathVariable int id){
        return "Book details for ID: " + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String title){
        return "Searching book with title: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name){
        return "Books written by author: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book){
        books.add(book);
        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks(){
        return books;
    }
}
