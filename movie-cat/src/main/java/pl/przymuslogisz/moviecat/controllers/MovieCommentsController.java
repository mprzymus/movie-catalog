package pl.przymuslogisz.moviecat.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.przymuslogisz.moviecat.dtos.MovieCommentDto;
import pl.przymuslogisz.moviecat.dtos.MovieDto;
import pl.przymuslogisz.moviecat.dtos.MovieList;
import pl.przymuslogisz.moviecat.mappers.MovieMapper;
import pl.przymuslogisz.moviecat.services.MovieService;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class MovieCommentsController {
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

    @PostMapping("/{id}")
    public MovieDto putMovie(@RequestBody MovieDto movieDto, @PathVariable Long id) {
        return movieService.putMovie(movieDto, id);
    }
}
