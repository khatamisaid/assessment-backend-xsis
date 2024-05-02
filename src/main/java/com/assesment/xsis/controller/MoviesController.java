package com.assesment.xsis.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.xsis.entity.Movies;
import com.assesment.xsis.model.MovieDto;
import com.assesment.xsis.service.MoviesService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/Movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("")
    public ResponseEntity<List<Movies>> getMovies() {
        return new ResponseEntity<>(moviesService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable Integer id) {
        return new ResponseEntity<>(moviesService.getMovieById(id), HttpStatus.OK);
    }

    @PostMapping(name = "", produces = {"application/json"})
    public ResponseEntity<Movies> postMovie(@Valid @ModelAttribute MovieDto movieDto) {
        return new ResponseEntity<>(moviesService.addMovie(movieDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Movies> patchMovie(@PathVariable Integer id, @Valid @ModelAttribute MovieDto movieDto) {
        return new ResponseEntity<>(moviesService.patchMovie(id, movieDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletehMovieById(@PathVariable Integer id) {
        moviesService.deleteMovie(id);
        return ResponseEntity.ok("Deleted successfully!");
    }

}
