package pl.przymuslogisz.moviecat.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.przymuslogisz.moviecat.dtos.UserDto;
import pl.przymuslogisz.moviecat.dtos.UsersDto;
import pl.przymuslogisz.moviecat.services.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public UsersDto getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/bylogin")
    public UserDto getUserByName(@RequestBody UserDto userDto) {
        return userService.getUserDtoByName(userDto.userName());
    }
}
