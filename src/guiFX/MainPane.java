package guiFX;


import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

public class MainPane extends StackPane {
    SplitPane splitPane;
    ControlThePane controlThePane;
    GraphicsPane graphicsPane;

    public MainPane() {
        makePane();
    }

    public void makePane() {
        StateModel stateModel = new StateModel();
        graphicsPane = new GraphicsPane(stateModel);
        controlThePane = new ControlThePane(stateModel);
        splitPane = new SplitPane(controlThePane, graphicsPane);
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.setDividerPosition(0, 0.4);
        getChildren().add(splitPane);
    }

}

