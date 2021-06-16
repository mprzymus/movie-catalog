package pl.przymuslogisz.moviecat.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.przymuslogisz.moviecat.dtos.MovieCommentDto;
import pl.przymuslogisz.moviecat.mappers.MovieCommentMapper;
import pl.przymuslogisz.moviecat.model.Movie;
import pl.przymuslogisz.moviecat.repositories.MovieRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieCommentService {

    private final MovieRepository movieRepository;
    private final MovieService movieService;
    private final MovieCommentMapper movieCommentMapper;

    public MovieCommentDto saveComment(MovieCommentDto commentDto, Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movieService.addComments(movie, Set.of(commentDto));
        var savedMovie = movieRepository.save(movie);
        var savedComment = savedMovie.getComments().stream()
                .filter((comment) -> comment.getComments().equals(commentDto.comments()) &&
                        comment.getMovie().getId().equals(commentDto.movieId()) &&
                        comment.getUser().getId().equals(commentDto.userId()) &&
                        comment.getRating().equals(commentDto.rating()) &&
                        comment.getDate().equals(commentDto.date()))
                .findAny().orElseThrow();
        return movieCommentMapper.movieCommentToMovieCommentDto(savedComment);
    }
}
