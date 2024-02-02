package services;

import model.App;
import model.Review;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppStoreService {
    private final List<App> appList;
    private final Map<String, User> userMap;
    private final Map<String, List<Review>> appReviews;

    public AppStoreService(List<App> appList, Map<String, User> userMap, Map<String, List<Review>> appReviews) {
        this.appList = appList;
        this.userMap = userMap;
        this.appReviews = appReviews;
    }

    public AppStoreService() {
        this.appList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.appReviews = new HashMap<>();
    }

    public void createServer() {
        new Thread(ConnectionService::new);
    }

    public boolean addApp(App app) {
        if (!appList.contains(app)) {
            appList.add(app);
            return true;
        }
        return false;
    }

    public boolean updateApp(App app) {
        if (appList.contains(app)) {
            appList.add(app);
            return true;
        }
        return false;
    }

    public boolean RegisterUser(String name, User user) {
        if (!userMap.containsKey(name)) {
            userMap.put(name, user);
            return true;
        }
        return false;
    }

    public boolean authentication(String name, String password) {
        if (!userMap.containsKey(name)) {
            return userMap.get(name).getPassword().equals(password);
        }
        return false;
    }

    // Methods for app listing, app details, user registration, user authentication, etc.

    // Additional methods for managing reviews, downloads, etc.
}
