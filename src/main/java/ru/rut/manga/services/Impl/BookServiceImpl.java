package ru.rut.manga.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.rut.manga.errors.ClientErrorException;
import ru.rut.manga.models.Book;
import ru.rut.manga.repositories.BookRepository;
import ru.rut.manga.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;

    @Autowired
    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book createBook(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public Book updateBook(String id, Book book) {
        Optional<Book> b =  bookRepo.findById(id);
        b.get().setGenre(book.getGenre());
        b.get().setTimePeriod(book.getTimePeriod());
        b.get().setAuthorNationality(book.getAuthorNationality());
        return bookRepo.save(b.get());
    }

    @Override
    public Optional<Book> findById(String id) {
        return bookRepo.findById(id);
    }

    @Override
    public Book getBook(String id) {
        return bookRepo.findById(id)
                .orElseThrow(()->new
                        ClientErrorException.NotFoundException("Бактерия с id=[%s] не найдена", id));
    }

    @Override
    public void deleteBook(String id) {
        bookRepo.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepo.deleteAll();
    }

    @Override
    public List<Book> saveAllBooks(List<Book> books) {
        return bookRepo.saveAll(books);
    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
