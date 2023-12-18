package ru.rut.manga.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import ru.rut.manga.errors.ClientErrorException;
import ru.rut.manga.models.Book;
import ru.rut.manga.repositories.BookRepository;
import ru.rut.manga.services.BookService;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public BookServiceImpl(BookRepository bookRepo, MongoTemplate mongoTemplate) {
        this.bookRepo = bookRepo;
        this.mongoTemplate = mongoTemplate;
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
                        ClientErrorException.NotFoundException("Книга с id=[%s] не найдена", id));
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

    @Override
    public List<GenreAggregationResult> findCustomQuery(String genre, String timePeriod) {
        MatchOperation matchStage = match(Criteria.where("genre").is(genre).and("timePeriod").is(timePeriod));

        GroupOperation groupByGenre = group("genre")
                .count().as("count");

        Aggregation aggregation = newAggregation(matchStage, groupByGenre);

        AggregationResults<GenreAggregationResult> result =
                mongoTemplate.aggregate(aggregation, "yourCollectionName", GenreAggregationResult.class);

        return result.getMappedResults();
    }
}
