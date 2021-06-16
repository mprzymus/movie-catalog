package pl.przymuslogisz.moviecat.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import pl.przymuslogisz.moviecat.dtos.MovieCommentDto;
import pl.przymuslogisz.moviecat.dtos.MovieDto;
import pl.przymuslogisz.moviecat.model.MovieComments;
import pl.przymuslogisz.moviecat.services.MovieCommentService;

@RestController
@RequestMapping("/api/movie/{id}/comment")
@RequiredArgsConstructor
@Slf4j
public class MovieCommentsController {

    private final MovieCommentService movieCommentService;

    @GetMapping
    public String testController(@AuthenticationPrincipal OAuth2User principal, @PathVariable String id) {
        log.info(principal.getName());
        log.info(principal.getAttributes().toString());
        log.info(principal.getAuthorities().toString());
        return "Only for logged in users";
    }

    @PostMapping
    public MovieCommentDto postComment(@RequestBody MovieCommentDto commentDto, @PathVariable Long id) {
        return movieCommentService.saveComment(commentDto, id);
    }
}
