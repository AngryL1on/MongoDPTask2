package ru.rut.manga.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rut.manga.models.FoodFactory;

@Configuration
public class FoodConfiguration{
    @Bean
    public FoodFactory foodFactory() {
        return new FoodFactory();
    }
}
