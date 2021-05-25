package pl.przymuslogisz.moviecat.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.przymuslogisz.moviecat.dtos.MovieCommentDto;
import pl.przymuslogisz.moviecat.dtos.MovieDto;
import pl.przymuslogisz.moviecat.dtos.UserDto;
import pl.przymuslogisz.moviecat.model.Movie;
import pl.przymuslogisz.moviecat.model.MovieComments;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;

    private final static Long MOVIE_ID = 1L;
    private final static Long COMMENT_ID = 2L;
    private final static Long USER_ID = 3L;
    private final static String URL = "url";
    private final static String NAME = "Some_name";
    private final static String USER_NAME = "Some_name";
    private final static String DESCRIPTION = "description";
    private final static String SHORT_DESCRIPTION = "desc";
    private final static LocalDate DATE = LocalDate.of(1999, 2, 2);

    @Test
    void movieToMovieDto() {
        var movie = new Movie();
        var comments = createComments();

        movie.setId(MOVIE_ID);
        movie.setName(NAME);
        movie.setDescription(DESCRIPTION);
        movie.setShortDescription(SHORT_DESCRIPTION);
        movie.setDate(DATE);
        movie.setImageUrl(URL);
        movie.setComments(comments);
        movie.setUser(UserMapperTest.createUser());

        var mapped = movieMapper.movieToMovieDto(movie);

        mapped.comments().forEach(MovieCommentMapperTest::assertMovieEqualsToConst);
        UserMapperTest.assertEqualsToConst(mapped.user());

        assertEquals(MOVIE_ID, mapped.id());
        assertEquals(NAME, mapped.name());
        assertEquals(DESCRIPTION, mapped.description());
        assertEquals(SHORT_DESCRIPTION, mapped.shortDescription());
        assertEquals(DATE, mapped.date());
        assertEquals(URL, mapped.imageUrl());

    }

    private Set<MovieComments> createComments() {
        return Set.of(
                MovieCommentMapperTest.createComment(),
                MovieCommentMapperTest.createComment()
        );
    }

    @Test
    void movieDtoToMovie() {
        var commentDto = new MovieCommentDto(COMMENT_ID, "", 1, MOVIE_ID, USER_ID, DATE);
        var comments = List.of(commentDto, commentDto);
        var user = new UserDto(USER_ID, USER_NAME);
        var movieDto = new MovieDto(
                MOVIE_ID, NAME, SHORT_DESCRIPTION, DESCRIPTION, DATE, URL, comments, user
        );

        var mapped = movieMapper.movieDtoToMovie(movieDto);
        var commentsSet = mapped.getComments();

        assertEquals(mapped.getId(), MOVIE_ID);
        assertEquals(mapped.getName(), NAME);
        assertEquals(mapped.getShortDescription(), SHORT_DESCRIPTION);
        assertEquals(mapped.getDescription(), DESCRIPTION);
        assertEquals(mapped.getDate(), DATE);
        assertEquals(mapped.getImageUrl(), URL);
        assertEquals(comments.size(), commentsSet.size());
        commentsSet.forEach(element -> {
            assertNotNull(element.getComments());
            assertNotNull(element.getId());
        });
    }
}