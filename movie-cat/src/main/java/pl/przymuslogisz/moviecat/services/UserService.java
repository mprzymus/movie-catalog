package pl.przymuslogisz.moviecat.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.przymuslogisz.moviecat.dtos.UserDto;
import pl.przymuslogisz.moviecat.dtos.UsersDto;
import pl.przymuslogisz.moviecat.mappers.UserMapper;
import pl.przymuslogisz.moviecat.model.User;
import pl.przymuslogisz.moviecat.repositories.UserRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public User getUserByName(String name) {
        return userRepository.findByUserName(name)
                .orElseThrow();
    }

    public UserDto getUserDtoByName(String name) {
        return userMapper.userToUserDto(getUserByName(name));
    }

    public UsersDto getAllUsers() {
        var usersList = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
        return new UsersDto(usersList);
    }

    public UserDto getUserById(Long id) {
        var user =  userRepository.findById(id).orElseThrow();
        return userMapper.userToUserDto(user);
    }
}
