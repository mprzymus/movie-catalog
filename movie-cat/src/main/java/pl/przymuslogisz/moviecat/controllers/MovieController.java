package pl.przymuslogisz.moviecat.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.przymuslogisz.moviecat.dtos.MovieDto;
import pl.przymuslogisz.moviecat.dtos.MovieList;
import pl.przymuslogisz.moviecat.services.MovieService;

@RestController
@RequestMapping("api/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public MovieList getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieDto getMovie(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping
    public MovieDto postMovie(@RequestBody MovieDto movieDto) {
        return movieService.postMovie(movieDto);
    }

    @PutMapping("/{id}")
    public MovieDto putMovie(@RequestBody MovieDto movieDto, @PathVariable Long id) {
        return movieService.putMovie(movieDto, id);
    }
}
