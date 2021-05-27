package pl.przymuslogisz.moviecat.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.przymuslogisz.moviecat.dtos.MovieDto;
import pl.przymuslogisz.moviecat.dtos.MovieList;
import pl.przymuslogisz.moviecat.mappers.MovieCommentMapper;
import pl.przymuslogisz.moviecat.mappers.MovieMapper;
import pl.przymuslogisz.moviecat.model.Movie;
import pl.przymuslogisz.moviecat.model.MovieComments;
import pl.przymuslogisz.moviecat.repositories.CommentRepository;
import pl.przymuslogisz.moviecat.repositories.MovieRepository;
import pl.przymuslogisz.moviecat.repositories.UserRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final MovieMapper movieMapper;
    private final MovieCommentMapper movieCommentMapper;


    public MovieDto postMovie(MovieDto movieDto) {
        Movie savedMovie;
        savedMovie = saveMovie(movieDto);
        return movieMapper.movieToMovieDto(savedMovie);
    }

    public MovieDto putMovie(MovieDto movieDto, Long id) {
        var movie = movieRepository.findById(id).orElseThrow();
        return movieMapper.movieToMovieDto(updateMovie(movie, movieDto));
    }

    private Movie saveMovie(MovieDto movieDto) {
        var movieToSave = movieMapper.movieDtoToMovie(movieDto);
        var user = userRepository.findById(movieDto.user().id()).orElseThrow();
        movieToSave.setUser(user);
        return movieRepository.save(movieToSave);
    }

    private Movie updateMovie(Movie movie, MovieDto movieDto) {
        setFields(movie, movieDto);
        movieDto.comments().forEach(movieCommentDto -> {
            var commentOptional = commentRepository.findById(movieCommentDto.id());
            MovieComments comment;
            if (commentOptional.isPresent()) {
                comment = commentOptional.get();
                comment.setComments(movieCommentDto.comments());
            }
            else {
                comment = movieCommentMapper.movieCommentDtoToMovieComments(movieCommentDto);
                comment.setMovie(movie);
                comment.setUser(userRepository.findById(movieCommentDto.userId()).orElseThrow());
                movie.getComments().add(comment);
            }
        });
        return movie;

    }

    private void setFields(Movie movie, MovieDto movieDto) {
        movie.setName(movieDto.name());
        movie.setDescription(movieDto.description());
        movie.setShortDescription(movieDto.shortDescription());
        movie.setDate(movieDto.date());
        movie.setImageUrl(movieDto.imageUrl());
    }

    public MovieList getAll() {
        var list = new ArrayList<MovieDto>();
        movieRepository.findAll()
                .forEach(element -> list.add(movieMapper.movieToMovieDto(element)));
        return new MovieList(list);
    }

    public MovieDto getById(Long id) {
        return movieMapper.movieToMovieDto(movieRepository.findById(id).orElseThrow());
    }
}
