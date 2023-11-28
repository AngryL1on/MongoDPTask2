package ru.rut.manga.models;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilmFactory{
    private static AtomicInteger nextId = new AtomicInteger(1);

    private final Faker faker = new Faker();
    public String genre() { return faker.options().option("Action", "Comedy", "Drama", "Fantasy", "Documentary"); }
    public String timePeriod() { return faker.options().option("Contemporary", "World War II", "Roaring Twenties", "Future"); }
    public String cinematographyStyle() { return faker.options().option("Film Noir", "Handheld", "Steady and Classic", "Documentary Style"); }

    public Film make(UnaryOperator<Film>...films) {
        final Film result = new Film(
                genre(),
                timePeriod(),
                cinematographyStyle()
        );
        Stream.of(films).forEach(v->v.apply(result));
        return result;
    }

    public static UnaryOperator<Film> oneUpId = s-> {
        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public BooksListDTOFactory listBuilder() {
        return new
            BooksListDTOFactory();
    }

    public class BooksListDTOFactory {
        public List<Film> films(int min, int max, UnaryOperator<Film>...fungis) {

            return IntStream.range(0, faker.number().numberBetween(min, max))
                .mapToObj(i-> FilmFactory.this.make(fungis))
                .collect(Collectors.toList());
        }
    }
}