package pl.przymuslogisz.moviecat.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.przymuslogisz.moviecat.model.Movie;
import pl.przymuslogisz.moviecat.model.User;
import pl.przymuslogisz.moviecat.repositories.MovieRepository;
import pl.przymuslogisz.moviecat.repositories.UserRepository;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
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


        movie.setUser(savedUser);
        movieRepository.save(movie);
    }
}
