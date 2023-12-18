package ru.rut.manga.services;

import ru.rut.manga.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService{
    Book createBook(Book book);

    Optional<Book> findById(String id);

    Book getBook(String id);

    List<Book> getAllBooks();

    Book updateBook(String id, Book book);

    void deleteBook(String id);

    void deleteAllBooks();

    List<Book> saveAllBooks(List<Book> books);


    List<Book> findCustomQuery(String genre, String timePeriod);
}
