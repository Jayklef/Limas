package com.jayklef.limas.service;

import com.jayklef.limas.exception.GenreNotFoundException;
import com.jayklef.limas.model.Genre;
import com.jayklef.limas.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{

    private GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Long genreId) throws GenreNotFoundException {
        Optional<Genre> genre = genreRepository.findById(genreId);

        if (!genre.isPresent()){
            throw new GenreNotFoundException();
        }
        return genre.get();
    }
}
