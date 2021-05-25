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

    /*@Mapping(target = "rating", source = "rating")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "comments", source = "comments")*/
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "movie", ignore = true)
    MovieComments movieCommentDtoToMovieComments(MovieCommentDto movieCommentDto);
}
