package pl.przymuslogisz.moviecat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.przymuslogisz.moviecat.model.MovieComments;

@Repository
public interface CommentRepository extends CrudRepository<MovieComments, Long> {
}
