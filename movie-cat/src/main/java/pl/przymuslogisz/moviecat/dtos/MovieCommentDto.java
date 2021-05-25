package pl.przymuslogisz.moviecat.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDate;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record MovieCommentDto(Long id,
                              String comments,
                              Integer rating,
                              Long movieId,
                              Long userId,
                              LocalDate date)
{}
