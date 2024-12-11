package com.myjavafx.javafx; import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TrafficLight extends CheckBoxDemo {
    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        HBox paneForRadioButtons = new HBox(20);

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Yellow");
        RadioButton rbBlue = new RadioButton("Green");
        paneForRadioButtons.getChildren().addAll(rbRed, rbGreen,rbBlue);
        pane.setCenter(paneForRadioButtons);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);

        VBox trafficLights = new VBox();
        Circle circle0 = new Circle();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        trafficLights.getChildren().addAll(circle0,circle1,circle2);

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                text.setFill(Color.RED);
                circle0.setFill(Color.RED);
            }
        });
        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                text.setFill(Color.YELLOW);
                circle0.setFill(Color.YELLOW);
            }
        });
        rbBlue.setOnAction(e -> {
            if (rbBlue.isSelected()) {
                text.setFill(Color.GREEN);
                circle0.setFill(Color.GREEN);
            }
        });

        return pane;
    }
    public static void main(String[]args) {
        launch(args);
    }
}
