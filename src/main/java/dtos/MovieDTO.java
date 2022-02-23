/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Movie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tha
 */
public class MovieDTO {
    private Long id;
    private int year;
    private String title;
    private String[] actors;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.year = movie.getYear();
        this.title = movie.getTitle();
        this.actors = movie.getActors();
    }

    public MovieDTO(int year, String title, String[] actors) {
        this.year = year;
        this.title = title;
        this.actors = actors;
    }

    public static List<MovieDTO> getDtos(List<Movie> movies){
        List<MovieDTO> movieDTOS = new ArrayList();
        movies.forEach(movie->movieDTOS.add(new MovieDTO(movie)));
        return movieDTOS;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String[] getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", actors=" + Arrays.toString(actors) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return year == movieDTO.year && Objects.equals(id, movieDTO.id) && Objects.equals(title, movieDTO.title) && Arrays.equals(actors, movieDTO.actors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, year, title);
        result = 31 * result + Arrays.hashCode(actors);
        return result;
    }
}
