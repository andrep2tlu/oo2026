package ee.andre.flimid.controller;

import ee.andre.flimid.entity.Movie;
import ee.andre.flimid.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("movies")
    public List<Movie> findMovie(){
        return movieRepository.findAll();
    }

    @DeleteMapping("delete/{id}")
    public List<Movie> deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
        return movieRepository.findAll();
    }

    @PostMapping("addmovie")
    public List<Movie> addMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
        return movieRepository.findAll();
    }
}