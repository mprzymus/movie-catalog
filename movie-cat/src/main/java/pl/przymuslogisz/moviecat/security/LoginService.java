package pl.przymuslogisz.moviecat.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.przymuslogisz.moviecat.repositories.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("User \"{}\" try to login", username);
        var user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("No username: " + username));
        var details = new MyUserDetails();
        details.setUsername(username);
        details.setPassword(user.getPassword());
        log.debug(details.getAuthorities().toString());
        return details;
    }
}
