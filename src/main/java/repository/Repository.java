package repository;

import lombok.AllArgsConstructor;
import model.App;
import model.Review;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
public class Repository {
    private final Map<String, App> appList;
    private final Map<String, User> userMap;
    private final Map<String, List<Review>> appReviews;

    public Repository() {
        this.appList = new HashMap<>();
        this.userMap = new HashMap<>();
        this.appReviews = new HashMap<>();
    }
}
