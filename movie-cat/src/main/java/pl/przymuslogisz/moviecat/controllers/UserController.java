package pl.przymuslogisz.moviecat.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
