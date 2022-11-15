package guiFX;


import FileHandling.ReaderFactory;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

import java.io.File;

public class MainPane extends StackPane {
    SplitPane splitPane;
    ControlThePane controlThePane;
    GraphicsPane graphicsPane;

    public MainPane() {
        makePane();
    }

    public void makePane() {

        controlThePane = new ControlThePane();
        graphicsPane = new GraphicsPane(controlThePane.courseStudents);
        controlThePane.loadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File dataFile = fileChooser.showOpenDialog(null);
            if (dataFile != null) {
                controlThePane.course = new ReaderFactory(dataFile).getCourse();
                controlThePane.courseStudents = controlThePane.course.assignedStudents();
                controlThePane.textArea.setText(controlThePane.courseText());
                controlThePane.labelStudents
                        .setText("Students in course: " + controlThePane.courseStudents.size());
                graphicsPane.setCourseStudents(controlThePane.courseStudents);
            } else System.out.println("no file selected");
        });
        controlThePane.gradeSlider.valueProperty().addListener(observable ->
                graphicsPane.setCourseStudents(controlThePane.courseStudents)
        );
        splitPane = new SplitPane(controlThePane.verticalBox, graphicsPane);
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.setDividerPosition(0, 0.4);
    }

}

