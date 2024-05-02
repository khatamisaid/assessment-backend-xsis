package com.assesment.xsis.service;

import com.assesment.xsis.entity.Movies;
import com.assesment.xsis.model.MovieDto;

import java.util.List;

public interface MoviesService {
    List<Movies> getMovies();
    Movies getMovieById(Integer id);
    Movies addMovie(MovieDto movies);
    Movies patchMovie(Integer id, MovieDto movies);
    void deleteMovie(Integer id);
}
