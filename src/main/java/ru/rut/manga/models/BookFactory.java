package ru.rut.manga.models;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BookFactory{
    private static AtomicInteger nextId = new AtomicInteger(1);
    private final Faker faker = new Faker();
    public String genre() { return faker.options().option("Fiction", "Thriller", "Mystery", "Fantasy"); }
    public String timePeriod() { return faker.options().option("Contemporary", "World War II", "Post-Apocalyptic"); }
    public String authorNationality() { return faker.options().option("Russia", "Italy", "France", "England", "USA", "Japanese"); }

    public Book make(UnaryOperator<Book>...books) {
        final Book result = new Book(
                genre(),
                timePeriod(),
                authorNationality()
        );
        Stream.of(books).forEach(v -> v.apply(result));
        return result;
    }

    public static UnaryOperator<Book> oneUpId = s -> {
        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public BooksListDTOFactory listBuilder() {
        return new
            BooksListDTOFactory();
    }

    public class BooksListDTOFactory {
        public List<Book> books(int min, int max, UnaryOperator<Book>...bacterias) {
            return IntStream.range(0, faker.number().numberBetween(min, max))
                    .mapToObj(i-> BookFactory.this.make(bacterias))
                    .collect(Collectors.toList());
        }
    }
}
