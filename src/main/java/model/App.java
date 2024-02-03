package model;

import lombok.*;

import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
public class App {
    private @NonNull String appId;
    private @NonNull String appName;
    private @NonNull String description;
    private @NonNull String developer;
    private double averageRating;
    private List<Review> reviews;

}
