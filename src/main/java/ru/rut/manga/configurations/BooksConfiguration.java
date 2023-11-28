package ru.rut.manga.configurations;

import ru.rut.manga.models.BookFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BooksConfiguration{
    @Bean
    public BookFactory bookFactory() {
        return new BookFactory();
    }
}
