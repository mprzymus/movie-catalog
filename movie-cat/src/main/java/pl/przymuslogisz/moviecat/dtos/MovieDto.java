package pl.przymuslogisz.moviecat.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDate;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record MovieDto(Long id, String comment, Integer rating, LocalDate date, UserDto author) {
}
