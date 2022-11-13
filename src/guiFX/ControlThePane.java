package guiFX;

import alumni.Course;
import alumni.Student;
import alumni.StudentRegular;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ControlThePane extends Pane {
    Button loadButton = new Button("Load");
    Label labelStudents = new Label("Get course");
    Label labelGrade = new Label("Students");
    Label labelSlider = new Label("Pre-Grade weight: 0.3");
    TextArea textArea = new TextArea();
    Slider gradeSlider = new Slider(.1, .9, .3);
    HBox horizontalBox1 = new HBox(300);
    HBox horizontalBox2 = new HBox(300);
    HBox horizontalBox3 = new HBox(300);
    VBox verticalBox = new VBox(500);
    Course course;
    ArrayList<Student> courseStudents;
    private final DecimalFormat df = new DecimalFormat("#.##");

    public ControlThePane() {
        makePane();
    }

    public void makePane() {
        labelGrade.setTextFill(Color.web("#beede4"));
        labelSlider.setTextFill(Color.web("#beede4"));
        labelStudents.setTextFill(Color.web("#beede4"));
        horizontalBox1.getChildren().addAll(labelStudents, loadButton);
        horizontalBox1.setAlignment(Pos.BOTTOM_RIGHT);
        horizontalBox1.setSpacing(10);
        horizontalBox1.setPadding(new Insets(5));
        horizontalBox1.setStyle("-fx-background-color: rgb(41, 73, 94);");
        horizontalBox2.getChildren().addAll(labelGrade, textArea);
        horizontalBox2.setAlignment(Pos.CENTER);
        horizontalBox2.setSpacing(10);
        horizontalBox2.setPadding(new Insets(5));
        horizontalBox2.setStyle("-fx-background-color: rgb(41, 93, 94);");
        horizontalBox3.getChildren().addAll(labelSlider, gradeSlider);
        horizontalBox3.setAlignment(Pos.CENTER);
        horizontalBox3.setSpacing(10);
        horizontalBox3.setPadding(new Insets(5));
        horizontalBox3.setStyle("-fx-background-color: rgb(41, 93, 118);");
        verticalBox.setAlignment(Pos.BASELINE_LEFT);
        verticalBox.setSpacing(10);
        verticalBox.setPadding(new Insets(20));
        verticalBox.setStyle("-fx-background-color: rgb(0, 93, 118); -fx-opacity: 0.9");
        verticalBox.getChildren().addAll(horizontalBox1, horizontalBox2, horizontalBox3);
        textArea.setEditable(false);
        textArea.setPrefSize(300, 250);
        textArea.setStyle("fx-background-color: #658b8c; -fx-opacity: 0.7");
        textArea.setFont(new Font("Cambria", 16));

        gradeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (course == null) {
                return;
            }
            for (Student student :
                    courseStudents) {
                if (student instanceof StudentRegular) {
                    ((StudentRegular) student).preFactor = newValue.doubleValue();
                }
            }
            textArea.setText(courseText());
            labelSlider.setText("Pre-Grade weight: " + df.format(newValue));
        });
    }

    public String courseText() {
        StringBuilder std = new StringBuilder(course.name() + "\n" + course.id() + "\n\n");
        courseStudents.forEach(student -> std.append(student.getName()).append(" (").append(student.getMajorCode())
                .append("): ").append(student.getExamGrade()).append("\n"));
        return std.toString();
    }
}