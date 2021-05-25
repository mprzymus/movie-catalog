package pl.przymuslogisz.moviecat.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.przymuslogisz.moviecat.dtos.MovieCommentDto;
import pl.przymuslogisz.moviecat.model.MovieComments;

@Mapper
public interface MovieCommentMapper {
    MovieCommentMapper INSTANCE = Mappers.getMapper(MovieCommentMapper.class);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "movieId", source = "movie.id")
    MovieCommentDto movieCommentToMovieCommentDto(MovieComments movieComments);
}
