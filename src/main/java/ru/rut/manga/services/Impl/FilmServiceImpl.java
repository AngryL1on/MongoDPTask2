package ru.rut.manga.services.Impl;

import ru.rut.manga.errors.ClientErrorException;
import ru.rut.manga.models.Film;
import ru.rut.manga.repositories.BookRepository;
import ru.rut.manga.repositories.FilmRepository;
import ru.rut.manga.services.BookService;
import ru.rut.manga.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService{

    private final FilmRepository filmRepo;
    private final BookService bookService;
    private final BookRepository bookRepo;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepo, BookService bookService, BookRepository bookRepo) {
        this.filmRepo = filmRepo;
        this.bookService = bookService;
        this.bookRepo = bookRepo;
    }

    @Override
    public Film createFilm(Film film) {
        filmRepo.save(film);
        return film;
    }


    @Override
    public Optional<Film> findById(String id) {
        return filmRepo.findById(id);
    }

    @Override
    public Film getFilm(String id) {
        return filmRepo.findById(id)
            .orElseThrow(()->new
                    ClientErrorException.NotFoundException("Книга с id=[%s] не найдена", id));
    }

    @Override
    public void deleteFilm(String id) {
        Film film = getFilm(id);
        System.out.println(film.getBooks());
        for(var b: film.getBooks()){
            bookService.deleteBook(b.getId());
//            bacteriaRepo.delete(b);
//            bacteriaRepo.deleteById(b.getId());
        }
        filmRepo.deleteById(id);
    }

    @Override
    public void deleteAllFilms() {
        filmRepo.deleteAll();
    }

    @Override
    public void saveAllFilms(List<Film> films) {
        filmRepo.saveAll(films);
    }

    @Override
    public Page<Film> getFilms(Pageable pageable) {
        Page<Film> films = filmRepo.findAll(pageable);
        return films;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }
}
