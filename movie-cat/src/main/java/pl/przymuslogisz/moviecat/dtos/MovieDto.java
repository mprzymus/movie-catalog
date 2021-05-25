package pl.przymuslogisz.moviecat.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDate;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record MovieDto(Long id, String name, String shortDescription, String description, LocalDate date, String imageUrl,
                       List<MovieCommentDto> comments, UserDto user) {
}
