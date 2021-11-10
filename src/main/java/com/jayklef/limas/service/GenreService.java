package com.jayklef.limas.service;

import com.jayklef.limas.exception.GenreNotFoundException;
import com.jayklef.limas.model.Genre;

import java.util.List;

public interface GenreService {
    Genre saveGenre(Genre genre);

    List<Genre> getAllGenre();

    Genre getGenreById(Long genreId) throws GenreNotFoundException;
}
