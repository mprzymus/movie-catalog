package pl.przymuslogisz.moviecat.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.przymuslogisz.moviecat.dtos.MovieDto;
import pl.przymuslogisz.moviecat.model.Movie;

@Mapper(uses = MovieCommentMapper.class)
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDto movieToMovieDto(Movie movie);
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "shortDescription", source = "shortDescription")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "comments", source = "comments")
    Movie movieDtoToMovie(MovieDto movieDto);

}
