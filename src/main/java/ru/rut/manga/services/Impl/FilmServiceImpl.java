package ru.rut.manga.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.rut.manga.errors.ClientErrorException;
import ru.rut.manga.models.Film;
import ru.rut.manga.repositories.BookRepository;
import ru.rut.manga.repositories.FilmRepository;
import ru.rut.manga.services.BookService;
import ru.rut.manga.services.FilmService;

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
                    ClientErrorException.NotFoundException("Фильм с id=[%s] не найдена", id));
    }

    @Override
    public void deleteFilm(String id) {
        Film film = getFilm(id);
        // Проверка на null, чтобы избежать NullPointerException
            for (var book : film.getBooks()) {
                bookRepo.delete(book);
                bookRepo.deleteById(book.getId());
            }
        filmRepo.deleteById(id);
    }

    @Override
    public void deleteAllFilms() {
        getAllFilms().stream().map(Film::getId).forEach(this::deleteFilm);
        filmRepo.deleteAll();
    }

    @Override
    public void saveAllFilms(List<Film> films) {
        filmRepo.saveAll(films);
    }

    @Override
    public Page<Film> getFilms(Pageable pageable) {
        return filmRepo.findAll(pageable);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }
}
