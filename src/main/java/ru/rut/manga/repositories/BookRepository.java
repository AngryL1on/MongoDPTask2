package ru.rut.manga.repositories;

import ru.rut.manga.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
//    // READ
//    Optional<Book> findById(String id);
//    List<Book> findAll();
//    List<Book> findByGenre(String genre);
//    List<Book> findByTimePeriod(String timePeriod);
//    List<Book> findByAuthorNationality(String authorNationality);
//
//    // Custom Query
//    // Search for a book by genre and time period
//    @Query("{ 'genre' : ?0, 'timePeriod' : ?1 }")
//    List<Book> findCustomQuery(String genre, String timePeriod);
}
