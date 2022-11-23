package guiFX;

import alumni.Course;
import alumni.Student;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.Comparator;

public class GraphicsPane extends Pane {

    final double GRADE_THRESHOLD = 4;
    StateModel stateModel;
    CheckBox checkBox;

    public GraphicsPane(StateModel stateModel) {
        this.stateModel = stateModel;
        stateModel.addObserver(() -> {
            Course course = stateModel.getCourse();
            draw(course);
        });
        checkBox = new CheckBox("sort grades");
        checkBox.setOnAction(event -> {
                    if (stateModel.getCourse() == null) {
                        return;
                    }
                    stateModel.setSort(checkBox.isSelected());
                }
        );
        getChildren().add(checkBox);
    }


    public void draw(Course course) {
        getChildren().clear();
        getChildren().add(checkBox);
        if (course != null) {
            ArrayList<Student> students = course.assignedStudents();
            if (checkBox.isSelected()) {
                students.sort(Comparator.comparingDouble(Student::getExamGrade));
            }
            for (int i = 0; i < students.size(); i++) {
                double barWidth = getWidth() / students.size();
                double barHeight = students.get(i).getExamGrade() / 6 * getHeight();
                double xPosition = barWidth * i;
                double yPosition = getHeight() - barHeight;
                Rectangle rectangle = new Rectangle(xPosition, yPosition, barWidth, barHeight);
                if (students.get(i).getExamGrade() > GRADE_THRESHOLD) {
                    rectangle.setFill(Color.CADETBLUE);
                } else {
                    rectangle.setFill(Color.PERU);
                }
                Text nameText = new Text(students.get(i).getName());
                nameText.getTransforms().add(new Translate(xPosition + barWidth / 2, getHeight() - 10));
                nameText.getTransforms().add(new Rotate(270));
                getChildren().addAll(rectangle, nameText);
            }
            Line line = new Line(0, 20, 0, 20);
            line.startYProperty().bind(heightProperty().multiply(.333));
            line.endXProperty().bind(widthProperty());
            line.endYProperty().bind(heightProperty().multiply(.333));
            line.setStroke(Color.PERU);
            line.setSmooth(true);
            line.setStrokeWidth(3);
            getChildren().add(line);
            setStyle("fx-background-color: #658b8c; -fx-opacity: 0.7");
        }
    }
}
