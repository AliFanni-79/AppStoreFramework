package services;

public class CoreService {
    public static AppStoreService appStoreService;
    public static void main(String[] args) {
        appStoreService = new AppStoreService();
    }
}
