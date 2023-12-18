package ru.rut.manga.controllers;

import ru.rut.manga.models.Film;
import ru.rut.manga.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmController{

    @Autowired
    private FilmService filmService;

    @GetMapping("/films")
    List<Film> all() {
        return filmService.getAllFilms();
    }

    @PostMapping("/films")
    Film newFungi(@RequestBody Film newFilm) {
        return filmService.createFilm(newFilm);
    }

    @GetMapping("/films/getBy")
    Optional<Film> one(@RequestParam String id) {
        return Optional.ofNullable(filmService.getFilm(String.valueOf(id)));
    }

    @DeleteMapping("/films/deleteBy")
    void deleteFungi(@RequestParam String id) {
        filmService.deleteFilm(String.valueOf(id));
    }

    @DeleteMapping("/films")
    void deleteAll() {
        filmService.deleteAllFilms();
    }
}
