package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Review {
    private String reviewId;
    private User user;
    private int rating;
    private String comment;
}
