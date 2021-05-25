package pl.przymuslogisz.moviecat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieComments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comments;
    private Integer rating;
    private LocalDate date;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;
}
