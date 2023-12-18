package ru.rut.manga.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.rut.manga.models.Film;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
}
