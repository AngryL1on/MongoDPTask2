package ru.rut.manga.init;

import ru.rut.manga.models.Book;
import ru.rut.manga.models.BookFactory;
import ru.rut.manga.models.Film;
import ru.rut.manga.services.BookService;
import ru.rut.manga.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements CommandLineRunner {
    @Autowired
    private BookService bookServices;
    @Autowired
    private FilmService filmServices;
    @Autowired
    private BookFactory bookFactory;
    @Override
    public void run(String... args) throws Exception {
        bookServices.deleteAllBooks();
        List<Book> books = bookFactory.listBuilder().books(2, 3);
        books = bookServices.saveAllBooks(books);

        Film films = new Film("2", "Thriller", "Post-Apocalyptic", "Handheld", books);
        System.out.println(filmServices.createFilm(films));
    }
}
