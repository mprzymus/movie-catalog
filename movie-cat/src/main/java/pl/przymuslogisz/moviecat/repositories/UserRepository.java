package pl.przymuslogisz.moviecat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.przymuslogisz.moviecat.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserName(String name);

    Optional<User> findByLogin(String username);
}
