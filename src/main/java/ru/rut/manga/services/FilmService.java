package ru.rut.manga.services;

import ru.rut.manga.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FilmService{
    Film createFilm(Film film);

    Optional<Film> findById(String id);

    Film getFilm(String id);

    Page<Film> getFilms(Pageable pageable);

    List<Film> getAllFilms();

    void deleteFilm(String id);

    void deleteAllFilms();

    void saveAllFilms(List<Film> films);
}
