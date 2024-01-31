package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("App Store");

        Button gamesButton = new Button("Games");
        Button productivityButton = new Button("Productivity");
        Button entertainmentButton = new Button("Entertainment");

        gamesButton.setOnAction(e -> showCategory("Games"));
        productivityButton.setOnAction(e -> showCategory("Productivity"));
        entertainmentButton.setOnAction(e -> showCategory("Entertainment"));

        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(20, 20, 20, 20));
        topBox.getChildren().addAll(gamesButton, productivityButton, entertainmentButton);
        VBox midBox = new VBox(10);
        midBox.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(topBox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showCategory(String category) {
        // Implement logic to display apps in the selected category
        System.out.println("Displaying apps in category: " + category);
        // You can open a new window or change the current scene accordingly
    }
}

