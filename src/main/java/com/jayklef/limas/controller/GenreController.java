package com.jayklef.limas.controller;

import com.jayklef.limas.exception.GenreNotFoundException;
import com.jayklef.limas.model.Genre;
import com.jayklef.limas.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    private GenreService genreService;

    private Logger logger = LoggerFactory.getLogger(GenreController.class);

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/genres")
    public Genre saveGenre(Genre genre){
        logger.info("Inside saveGenre in GenreController");
        return genreService.saveGenre(genre);
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenre(){
        logger.info("Inside getAllGenre in GenreController");
        return genreService.getAllGenre();
    }

    @PutMapping("/genreId/{id}")
    public Genre getGenreById(@PathVariable("genreId") Long genreId) throws GenreNotFoundException {
        return genreService.getGenreById(genreId);
    }
}
