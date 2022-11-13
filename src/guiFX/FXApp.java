package guiFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class FXApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainPane mainPane = new MainPane();
        mainPane.getChildren().addAll(mainPane.splitPane);
        Scene scene = new Scene(mainPane, 1024, 382);
        primaryStage.setScene(scene);
        primaryStage.getIcons()
                .add(new Image("C:\\Users\\andre\\Documents\\IdeaProjects\\" +
                        "Application-Classroom\\Files\\school.jpg"));
        primaryStage.setTitle("Application Classroom!");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


}