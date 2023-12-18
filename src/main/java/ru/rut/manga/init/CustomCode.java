package ru.rut.manga.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rut.manga.services.BookService;
import ru.rut.manga.services.FilmService;
import ru.rut.manga.services.FoodService;

@Component
public class CustomCode implements CommandLineRunner {
    @Autowired
    private BookService bookService;
    @Autowired
    private FilmService filmService;
    private final FoodService foodService;

    @Autowired
    public CustomCode(FilmService filmsService, BookService booksService, FoodService foodService) {
        this.filmService = filmService;
        this.bookService = bookService;
        this.foodService = foodService;
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Book> storedBook = bookService.getAllBooks();
////        List<Book> t = bookService.findCiliaBetween(0, 1);
////        foodService.deleteAllFoods();
//        for (Book b : storedBook) {
//            System.out.println(b);
////            System.out.print(" - ");
//        }
////        System.out.println();
////        for (Book b : t) {
////            System.out.println(b);
//////            System.out.print(" - ");
////        }
////        System.out.println(foodService.getAllFoods());
//        bookService.deleteAllBooks();
    }
}
