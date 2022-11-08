package guiFX;

import FileHandling.Checker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class FXApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Checker checker = new Checker(new File("Files/major-map.txt"));
        MainPane noPaneNoMain = new MainPane(checker.readMajors());
        noPaneNoMain.getChildren().addAll(noPaneNoMain.verticalBox);
        FlowPane flowPane = new FlowPane(noPaneNoMain);
        StackPane rootPane = new StackPane(flowPane);
        Scene scene = new Scene(rootPane, 407, 382);
        primaryStage.setScene(scene);
        primaryStage.getIcons()
                .add(new Image("C:\\Users\\andre\\Documents\\IdeaProjects\\" +
                        "Application-Classroom\\Files\\school.jpg"));
        primaryStage.setTitle("Application Classroom!");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


}