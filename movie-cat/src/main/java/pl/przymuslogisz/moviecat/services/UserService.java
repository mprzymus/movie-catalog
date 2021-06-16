package pl.przymuslogisz.moviecat.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.przymuslogisz.moviecat.model.User;
import pl.przymuslogisz.moviecat.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserByName(String name) {
        return userRepository.findByUserName(name)
                .orElseThrow();
    }
}
