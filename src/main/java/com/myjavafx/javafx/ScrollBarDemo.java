package com.myjavafx.javafx; import javafx.application.Application;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ScrollBarDemo extends Application {
    @Override //Override the start method in the application class
    public void start(Stage primaryStage) {
        Text text = new Text(20, 20, "JavaFX Programming");

        ScrollBar sbHorizontal = new ScrollBar();
        ScrollBar sbVertical = new ScrollBar();
        sbVertical.setOrientation(Orientation.VERTICAL);

        //Create a text in a pane
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        //Create a border pane to hold text and scroll bars
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setBottom(sbHorizontal);
        pane.setRight(sbVertical);

        //Listener for horizontal scroll bar value changes
        sbHorizontal.valueProperty().addListener(ov ->
          text.setX(sbHorizontal.getValue() * paneForText.getWidth() /
            sbHorizontal.getMax()));

        //Listener for vertical scroll bar value change
        sbVertical.valueProperty().addListener(ov ->
          text.setY(sbVertical.getValue() * paneForText.getHeight() /
           sbVertical.getMax()));

        //Creat a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ScrollBarDemo");
        primaryStage.setScene(scene);
        primaryStage.show();

        double value = sbVertical.getValue();
        System.out.println(value);

        double width = pane.getWidth();
        System.out.println("Width of the pane: " + width);
        double height = pane.getHeight();
        System.out.println("Height of the pane: " + height);
        double max = sbVertical.getMax();
        System.out.println("Max value: " + max);


    }
}