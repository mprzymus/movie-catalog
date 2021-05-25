package pl.przymuslogisz.moviecat.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record MovieCommentDto(Long id, String comment, Long rating, Long movieId, Long userId) {
}
