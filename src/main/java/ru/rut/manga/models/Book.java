package ru.rut.manga.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "books")
public class Book{
    @Id
    private String id;
    @Field(name="genre")
    private String genre;

    @Field(name="timePeriod")
    private String timePeriod;

    @Field(name="authorNationality")
    private String authorNationality;

    public Book(){

    }

    public Book(String id, String genre, String timePeriod, String authorNationality) {
        this.id = id;
        this.genre = genre;
        this.timePeriod = timePeriod;
        this.authorNationality = authorNationality;
    }

    public Book(String genre, String timePeriod, String authorNationality) {
        this.genre = genre;
        this.timePeriod = timePeriod;
        this.authorNationality = authorNationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getAuthorNationality() {
        return authorNationality;
    }

    public void setAuthorNationality(String authorNationality) {
        this.authorNationality = authorNationality;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", genre='" + genre + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", authorNationality='" + authorNationality + '\'' +
                '}';
    }
}
