package com.jayklef.limas.controller;

import com.jayklef.limas.exception.GenreNotFoundException;
import com.jayklef.limas.model.Genre;
import com.jayklef.limas.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/genres")
    public Genre saveGenre(Genre genre){
        return genreService.saveGenre(genre);
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenre(){
        return genreService.getAllGenre();
    }

    @PutMapping("/genreId/{id}")
    public Genre getGenreById(@PathVariable("genreId") Long genreId) throws GenreNotFoundException {
        return genreService.getGenreById(genreId);
    }
}
