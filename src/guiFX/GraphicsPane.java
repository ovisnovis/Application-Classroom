package guiFX;

import alumni.Student;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class GraphicsPane extends Pane {
    ArrayList<Student> courseStudents;
    final double GRADE_THRESHOLD = 4;

    public GraphicsPane(ArrayList<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }


    public void setCourseStudents(ArrayList<Student> courseStudents) {
        this.courseStudents = courseStudents;
        draw();
    }

    public void draw() {
        getChildren().clear();
        double width = getWidth() / courseStudents.size();
        double xPosition = 0;
        for (Student student :
                courseStudents) {
            double barHeight = student.getExamGrade() / 6 * getHeight();
            double yPosition = barHeight-getHeight();
            Rectangle rectangle = new Rectangle(xPosition, yPosition, width, barHeight);
            xPosition++;
            if (student.getExamGrade() > GRADE_THRESHOLD) {
                rectangle.setFill(Color.CORNFLOWERBLUE);
            } else {
                rectangle.setFill(Color.INDIANRED);
            }
            getChildren().add(rectangle);
            Text nameText = new Text(student.getName());
            nameText.getTransforms().add(new Translate(xPosition + width/2, getHeight() - 10));
            nameText.getTransforms().add(new Rotate(-90));
            getChildren().add(nameText);
        }

    }
}
