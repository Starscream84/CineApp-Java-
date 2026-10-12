package model;

import jakarta.persistence.*;

@Entity
@Table (name = "movies")

public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String genre;
    private String filmRating;
    private int duration;
    private int year;
    
    public Movie(){} //Empty for JPA 
    
    public Movie(String title, String genre, String filmRating, int duration, int year)
    {
        this.title = title;
        this.genre = genre;
        this.filmRating = filmRating;
        this.duration = duration;
        this.year = year;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    
    public String getFilmRating() { return filmRating; }
    public void setFilmRating(String filmRating) { this.filmRating = filmRating; }
    
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }   
}
