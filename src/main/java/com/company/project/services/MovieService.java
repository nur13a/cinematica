package com.company.project.services;

import com.company.project.entities.Movie;
import com.company.project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements BaseService<Movie> {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    @Override
    public Movie create(Movie model) {
        return movieRepository.save(model);
    }

    @Override
    public Movie update(Movie model) {
        return movieRepository.save(model);
    }

    @Override
    public void delete(Movie model) {
        movieRepository.delete(model);
    }
}
