package ru.rut.manga.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "films")
public class Film{
    @Id
    private String id;
    @Field(name="genre")
    private String genre;

    @Field(name="timePeriod")
    private String timePeriod;

    @Field(name="cinematographyStyle")
    private String cinematographyStyle;

    @Field(name = "books")
    List<Book> books;

    public Film() {
    }

    public Film(String id, String genre, String timePeriod, String cinematographyStyle) {
        this.id = id;
        this.genre = genre;
        this.timePeriod = timePeriod;
        this.cinematographyStyle = cinematographyStyle;
    }

    public Film(String genre, String timePeriod, String cinematographyStyle) {
        this.genre = genre;
        this.timePeriod = timePeriod;
        this.cinematographyStyle = cinematographyStyle;
    }

    public Film(String id, String genre, String timePeriod, String cinematographyStyle, List<Book> books) {
        this.id = id;
        this.genre = genre;
        this.timePeriod = timePeriod;
        this.cinematographyStyle = cinematographyStyle;
        this.books = books;
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

    public String getCinematographyStyle() {
        return cinematographyStyle;
    }

    public void setCinematographyStyle(String cinematographyStyle) {
        this.cinematographyStyle = cinematographyStyle;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", genre='" + genre + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", cinematographyStyle='" + cinematographyStyle + '\'' +
                ", books=" + books +
                '}';
    }
}

