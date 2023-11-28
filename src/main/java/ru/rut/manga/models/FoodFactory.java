package ru.rut.manga.models;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FoodFactory{
    private static AtomicInteger nextId = new AtomicInteger(1);
    private final Faker faker = new Faker();
    public String name() { return faker.options().option("Pizza", "Salad", "Soup", "Pasta"); }
    public String category() { return faker.options().option("Business as usual", "Dessert", "Baking"); }
    public String country() { return faker.options().option("Russia", "Italy", "France", "England", "USA"); }

    public Food make(UnaryOperator<Food>...foods) {
        final Food food = new Food(
                name(),
                category(),
                country()
        );
        Stream.of(foods).forEach(f -> f.apply(food));
        return food;
    }

    public static UnaryOperator<Food> oneUpId = s-> {
        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public FoodListDTOFactory listBuilder() {
        return new FoodListDTOFactory();
    }

    public class FoodListDTOFactory{
        public List<Food> food(int min, int max, UnaryOperator<Food>...foods) {
            return IntStream.range(0, faker.number().numberBetween(min, max))
                    .mapToObj(i-> FoodFactory.this.make(foods))
                    .collect(Collectors.toList());
        }
    }
}
