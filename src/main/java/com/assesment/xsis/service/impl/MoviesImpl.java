package com.assesment.xsis.service.impl;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assesment.xsis.entity.Movies;
import com.assesment.xsis.exception.ResourceNotFoundException;
import com.assesment.xsis.model.MovieDto;
import com.assesment.xsis.repository.MoviesRepository;
import com.assesment.xsis.service.MoviesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MoviesImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    ResourceLoader resourceLoader;

    private final Path root = Paths.get("src/main/resources/static/image");

    @Override
    public List<Movies> getMovies() {
        // mengembalikan semua movie
        return moviesRepository.findAll();
    }

    @Override
    public Movies getMovieById(Integer id) {
        // mengembalikan movie berdasarkan ID
        return moviesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    }

    @Override
    public Movies addMovie(MovieDto moviesDto) {
        // menambahkan movie
        Movies movies = new Movies();
        BeanUtils.copyProperties(moviesDto, movies);
        String extension = FilenameUtils.getExtension(moviesDto.getImage().getOriginalFilename());
        String fileName = UUID.randomUUID().toString() + "." + extension;
        movies.setImage(fileName);
        this.uploadFile(moviesDto.getImage(), movies.getImage());
        return moviesRepository.save(movies);
    }

    @Override
    public Movies patchMovie(Integer id, MovieDto moviesDto) {
        // mengubah value movie bersarkan ID
        Movies movies = moviesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        BeanUtils.copyProperties(moviesDto, movies);
        return moviesRepository.save(movies);
    }

    @Override
    public void deleteMovie(Integer id) {
        // menghapus movie berdasarkan ID
        Movies movies = moviesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        moviesRepository.deleteById(movies.getId());
    }

    private void uploadFile(MultipartFile multipartFile, String fileName) {
        try {
            Files.copy(multipartFile.getInputStream(), this.root.resolve(fileName));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

}
