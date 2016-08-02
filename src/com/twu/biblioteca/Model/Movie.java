package com.twu.biblioteca.Model;

public class Movie {

    private String name;
    private int year;
    private String  director;
    private int movieRanting;

    public Movie(String name, int year, String director, int movieRanting) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRanting = movieRanting;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getMovieRanting() {
        return movieRanting;
    }
}
