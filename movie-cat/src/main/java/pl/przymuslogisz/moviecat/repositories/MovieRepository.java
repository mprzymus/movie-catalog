package pl.przymuslogisz.moviecat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.przymuslogisz.moviecat.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
