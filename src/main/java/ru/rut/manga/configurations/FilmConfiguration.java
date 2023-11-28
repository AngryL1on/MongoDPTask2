package ru.rut.manga.configurations;

import ru.rut.manga.models.FilmFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilmConfiguration{
    @Bean
    public FilmFactory filmFactory() {
        return new FilmFactory();
    }
}