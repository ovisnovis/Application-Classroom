package guiFX;


import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

public class MainPane extends StackPane {
    public HashMap<String, String> majorMap;
    public MainPane(HashMap<String, String> majorMap) {
        this.majorMap = majorMap;
        makePane();
    }

    public void makePane() {
        ControlThePane controlThePane = new ControlThePane();
        GraphicsPane graphicsPane = new GraphicsPane(controlThePane.courseStudents);
        SplitPane splitPane = new SplitPane(controlThePane, graphicsPane);
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.setDividerPosition(0, 0.2);
    }


}