package ru.rut.manga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rut.manga.models.Food;
import ru.rut.manga.services.FoodService;

import java.util.Optional;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/food")
    Iterable<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @PostMapping("/food")
    Food createPresent(@RequestBody Food foods) {
        return foodService.createFood(foods);
    }


    @GetMapping("/foods/getBy")
    Optional<Food> getFood(@RequestParam String id) {
        return Optional.ofNullable(foodService.getFood(String.valueOf(id)));

    }

    @DeleteMapping("/foods/deleteBy")
    void deleteFood(@RequestParam String id) {
        foodService.deleteFood(String.valueOf(id));
    }

    @PutMapping("/foods")
    Food updatePresent(@PathVariable String id, @RequestBody Food foods) {
        return foodService.updateFood(id, foods);
    }

    @DeleteMapping("/foods")
    void deleteAll() {
        foodService.deleteAllFoods();
    }
}
