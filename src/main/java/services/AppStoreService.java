package services;

import lombok.AllArgsConstructor;
import model.App;
import model.Review;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
public class AppStoreService {

    public void createServer() {
        new Thread(ConnectionService::new);
    }

    public boolean addApp(App app) {
        if (!appList.containsKey(app.getAppId())) {
            appList.put(app.getAppId(), app);
            return true;
        }
        return false;
    }

    public boolean updateApp(App app) {
        if (appList.containsKey(app.getAppId())) {
            appList.put(app.getAppId(), app);
            return true;
        }
        return false;
    }

    public void addReview(String appId, String userId, int rating, String comment) {

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
