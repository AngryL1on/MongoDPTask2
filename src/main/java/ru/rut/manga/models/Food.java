package ru.rut.manga.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "foods")
public class Food{
    @Id
    private String id;

    @Field(name="name")
    private String name;

    @Field(name="category")
    private String category;

    @Field(name="country")
    private String country;

    public Food() {
    }

    public Food(String id, String name, String category, String country) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.country = country;
    }

    public Food(String name, String category, String country) {
        this.name = name;
        this.category = category;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
