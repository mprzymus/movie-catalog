package pl.przymuslogisz.moviecat.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Slf4j
public class MovieCommentsController {
    @GetMapping
    public String testController() {
        log.info("Request by {}", SecurityContextHolder.getContext().getAuthentication().getName());
        return "Only for logged in users";
    }
}
