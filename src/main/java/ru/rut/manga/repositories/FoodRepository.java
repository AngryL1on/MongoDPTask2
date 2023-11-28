package ru.rut.manga.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.rut.manga.models.Food;

public interface FoodRepository extends MongoRepository<Food, String> {
}
