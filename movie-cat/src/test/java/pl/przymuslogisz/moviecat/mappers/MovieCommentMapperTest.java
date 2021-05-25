package pl.przymuslogisz.moviecat.mappers;

import org.junit.jupiter.api.Test;
import pl.przymuslogisz.moviecat.model.Movie;
import pl.przymuslogisz.moviecat.model.MovieComments;
import pl.przymuslogisz.moviecat.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieCommentMapperTest {

    private final MovieCommentMapper mapper = MovieCommentMapper.INSTANCE;

    public final static Long MOVIE_ID = 1L;
    public final static Long USER_ID = 2L;
    public final static Long ID = 3L;
    public final static Integer RATING = 3;
    public final static String COMMENT = "Some comment";
    public final static LocalDate DATE = LocalDate.of(1999, 2, 2);

    @Test
    void movieCommentToMovieCommentDto() {
        MovieComments movieComment = createComment();

        var mapped = mapper.movieCommentToMovieCommentDto(movieComment);

        assertMovieEqualsToConst(mapped);
    }

    public static void assertMovieEqualsToConst(pl.przymuslogisz.moviecat.dtos.MovieCommentDto mapped) {
        assertEquals(MOVIE_ID, mapped.movieId());
        assertEquals(USER_ID, mapped.userId());
        assertEquals(ID, mapped.id());
        assertEquals(RATING, mapped.rating());
        assertEquals(DATE, mapped.date());
        assertEquals(COMMENT, mapped.comments());
    }

    public static MovieComments createComment() {
        var movieComment = new MovieComments();
        var movie = new Movie();
        movie.setId(MOVIE_ID);
        var user = new User();
        user.setId(USER_ID);

        movieComment.setMovie(movie);
        movieComment.setUser(user);
        movieComment.setId(ID);
        movieComment.setRating(RATING);
        movieComment.setDate(DATE);
        movieComment.setComments(COMMENT);
        return movieComment;
    }
}