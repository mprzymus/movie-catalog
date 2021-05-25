package pl.przymuslogisz.moviecat.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.przymuslogisz.moviecat.dtos.MovieDto;
import pl.przymuslogisz.moviecat.model.Movie;

@Mapper(uses = MovieCommentMapper.class)
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDto movieToMovieDto(Movie movie);

}
