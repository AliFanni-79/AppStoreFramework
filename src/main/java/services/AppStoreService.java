package services;

import lombok.AllArgsConstructor;
import model.App;
import model.Review;
import repository.Repository;

@AllArgsConstructor
public class AppStoreService {

    public static Repository repository = new Repository();

    public void createServer() {
        new Thread(ConnectionService::new);
    }

    public boolean addApp(App app) {
        if (!AppStoreService.repository.getAppList().containsKey(app.getAppId())) {
            AppStoreService.repository.getAppList().put(app.getAppId(), app);
            return true;
        }
        return false;
    }

    public boolean updateApp(App app) {
        if (AppStoreService.repository.getAppList().containsKey(app.getAppId())) {
            AppStoreService.repository.getAppList().put(app.getAppId(), app);
            return true;
        }
        return false;
    }

    public boolean addReview(String appId, String userId, int rating, String comment) {
        if (AppStoreService.repository.getAppList().containsKey(appId)) {
            Review review = new Review(String.valueOf(repository.getAppReviews().size()),
                    repository.getUserMap().get(userId), rating, comment);
            repository.getAppReviews().get(appId).add(review);
            repository.getAppList().get(appId).getReviews()
                    .add(review);
            return true;
        }
        return false;
    }
}
