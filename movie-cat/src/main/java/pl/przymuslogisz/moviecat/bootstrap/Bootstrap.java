package pl.przymuslogisz.moviecat.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.przymuslogisz.moviecat.model.Movie;
import pl.przymuslogisz.moviecat.model.MovieComments;
import pl.przymuslogisz.moviecat.model.User;
import pl.przymuslogisz.moviecat.repositories.MovieRepository;
import pl.przymuslogisz.moviecat.repositories.UserRepository;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile("h2")
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Adding default data");
        var movie = new Movie();
        movie.setName("name");
        movie.setDescription("description");
        movie.setShortDescription("desc");
        movie.setDate(LocalDate.now());
        movie.setImageUrl("url");

        var user = new User();

        user.setUserName("userName");
        user.setLogin("login");
        user.setPassword("pass");

        var savedUser = userRepository.save(user);

        var comment1 = new MovieComments();
        comment1.setComments("Some comment1");
        comment1.setMovie(movie);
        comment1.setUser(user);
        comment1.setRating(2);
        comment1.setDate(LocalDate.now());

        var comment2 = new MovieComments();
        comment2.setComments("Some another comment");
        comment2.setMovie(movie);
        comment2.setUser(user);
        comment2.setRating(3);
        comment2.setDate(LocalDate.now());

        movie.getComments().add(comment1);
        movie.getComments().add(comment2);

        movie.setUser(savedUser);
        movieRepository.save(movie);
    }
}
