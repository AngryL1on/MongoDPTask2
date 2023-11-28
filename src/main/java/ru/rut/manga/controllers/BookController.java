package ru.rut.manga.controllers;

import ru.rut.manga.models.Book;
import ru.rut.manga.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController{

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    Iterable<Book> all() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    Book newBacteria(@RequestBody Book newBook) {
        return bookService.createBook(newBook);
    }

    @PostMapping("/books/updateBy")
    Book updateBacteria(@RequestParam String id, @RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

    @GetMapping("/books/getBy")
    Optional<Book> one(@RequestParam String id) throws Throwable {
        return Optional.ofNullable(bookService.getBook(String.valueOf(id)));
    }

    @DeleteMapping("/books/deleteBy")
    void deleteBacteria(@RequestParam String id) {
        bookService.deleteBook(String.valueOf(id));
    }

    @DeleteMapping("/books")
    void deleteAll() {
        bookService.deleteAllBooks();
    }
}
