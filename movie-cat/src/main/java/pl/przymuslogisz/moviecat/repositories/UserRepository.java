package pl.przymuslogisz.moviecat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.przymuslogisz.moviecat.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
