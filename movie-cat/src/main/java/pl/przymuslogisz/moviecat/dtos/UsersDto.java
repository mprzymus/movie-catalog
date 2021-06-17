package pl.przymuslogisz.moviecat.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record UsersDto(List<UserDto> users) {
}
