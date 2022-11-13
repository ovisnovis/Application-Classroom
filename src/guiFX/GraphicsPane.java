package guiFX;

import alumni.Student;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class GraphicsPane extends Pane {

    final double GRADE_THRESHOLD = 4;
    ArrayList<Student> courseStudents;

    public GraphicsPane(ArrayList<Student> studentArrayList) {
        this.courseStudents = studentArrayList;
        draw();
    }

    public void setCourseStudents(ArrayList<Student> courseStudents) {
        this.courseStudents = courseStudents;
        draw();
    }

    public void draw() {
        getChildren().clear();
        if (courseStudents != null) {
            for (int i = 0; i < courseStudents.size(); i++) {
                double barWidth = getWidth() / courseStudents.size();
                double barHeight = courseStudents.get(i).getExamGrade() / 6 * getHeight();
                double xPosition = barWidth * i;
                double yPosition = getHeight() - barHeight;
                Rectangle rectangle = new Rectangle(xPosition, yPosition, barWidth, barHeight);
                if (courseStudents.get(i).getExamGrade() > GRADE_THRESHOLD) {
                    rectangle.setFill(Color.CADETBLUE);
                } else {
                    rectangle.setFill(Color.PERU);
                }
                Text nameText = new Text(courseStudents.get(i).getName());
                nameText.getTransforms().add(new Translate(xPosition + barWidth / 2, getHeight() - 10));
                nameText.getTransforms().add(new Rotate(270));
                getChildren().addAll(rectangle, nameText);
            }
            Line line = new Line(0,20,0,20);
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
