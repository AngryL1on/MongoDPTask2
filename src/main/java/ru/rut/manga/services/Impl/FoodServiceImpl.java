package ru.rut.manga.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.rut.manga.errors.ClientErrorException;
import org.springframework.stereotype.Service;
import ru.rut.manga.models.Food;
import ru.rut.manga.repositories.FoodRepository;
import ru.rut.manga.services.FoodService;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{
    private final FoodRepository presentRepo;

    @Autowired
    public FoodServiceImpl(FoodRepository presentRepo) {
        this.presentRepo = presentRepo;
    }

    @Override
    public Food createFood(Food foods) {
        presentRepo.save(foods);
        return foods;
    }

    @Override
    public List<Food> getAllFoods() {
        return presentRepo.findAll();
    }

    @Override
    public Food getFood(String id) {
        return presentRepo.findById(id)
                .orElseThrow(()->new ClientErrorException.NotFoundException("Подарок с id=[%s] не найден", id));
    }
    @Override
    public void deleteFood(String id) {
        presentRepo.deleteById(id);
    }

    @Override
    public void deleteAllFoods() {
        presentRepo.deleteAll();
    }

    @Override
    public void saveAllFoods(List<Food> foods) {
        presentRepo.saveAll(foods);
    }

    @Override
    public Food updateFood(String id, Food updatedFoods) {
        Food existingFoods = presentRepo.findById(id)
                .orElseThrow(() -> new ClientErrorException("Подарок с id=[%s] не найден " + id) {
                });
        existingFoods.setName(updatedFoods.getName());
        existingFoods.setCategory(updatedFoods.getCategory());
        existingFoods.setCountry(updatedFoods.getCountry());

        Food savedFoods = presentRepo.save(existingFoods);

        return savedFoods;
    }

}