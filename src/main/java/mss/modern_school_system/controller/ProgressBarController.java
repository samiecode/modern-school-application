package mss.modern_school_system.controller;

import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgressBarController implements Initializable {

    @FXML
    private Circle path;
    @FXML
    private Rectangle rec;
    @FXML
    private Circle rotate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        PathTransition pt = new PathTransition(Duration.seconds(2), path, rotate);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

    }
}
