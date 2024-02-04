package services;

import model.User;
import repository.Repository;

import java.util.Map;

public class AuthenticationService {
    private Map<String, User> loggedInUsers;

    public boolean RegisterUser(String name, User user) {
        if (AppStoreService.repository.getUserMap().containsKey(name)) {
            AppStoreService.repository.getUserMap().put(name, user);
            return true;
        }
        return false;
    }

    public boolean authentication(String name, String password) {
        if (!AppStoreService.repository.getUserMap().containsKey(name)) {
            return AppStoreService.repository.getUserMap().get(name).getPassword().equals(password);
        }
        return false;
    }
}
