package pl.przymuslogisz.moviecat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MovieComments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String comments;
    private Integer rating;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;
}
