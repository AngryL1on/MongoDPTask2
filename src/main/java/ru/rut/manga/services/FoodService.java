package ru.rut.manga.services;

import ru.rut.manga.models.Food;

import java.util.List;

public interface FoodService{
    Food createFood(Food foods);

    Food getFood(String id);

    void deleteFood(String id);

    void deleteAllFoods();

    void saveAllFoods(List<Food> foods);

    List<Food> getAllFoods();

    Food updateFood(String id, Food updatedFoods);
}