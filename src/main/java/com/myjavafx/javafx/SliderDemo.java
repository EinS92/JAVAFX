package com.myjavafx.javafx;
import javafx.application.Application;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class SliderDemo extends Application {
    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        Text text = new Text(20, 20, "JavaFX Programming");

        Slider slHorizontal = new Slider();
        slHorizontal.setShowTickLabels(true);
        slHorizontal.setShowTickMarks(true);

        Slider slVertical = new Slider();
        slVertical.setOrientation(Orientation.VERTICAL);
        slVertical.setShowTickLabels(true);
        slVertical.setShowTickMarks(true);
        slVertical.setValue(100);

        //Create a text in a pace
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        //Create a border pane to hold text
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setBottom(slHorizontal);
        pane.setRight(slVertical);

        slHorizontal.valueProperty().addListener(ov ->
          text.setX(slHorizontal.getValue() * paneForText.getWidth() /
            slHorizontal.getMax()));

        slVertical.valueProperty().addListener(ov ->
          text.setY((slVertical.getMax() - slVertical.getValue())
            * paneForText.getHeight() / slVertical.getMax()));

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("SliderDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}