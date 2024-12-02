package com.myjavafx.javafx; import com.myjavafx.javafx.DescriptionPane;
import javafx.application.Application; import javafx.scene.image.Image;
import javafx.stage.Stage; import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class TextAreaDemo extends Application {
    @Override //Overrides the start method in the Application class
    public void start(Stage primaryStage) {
        //Declare and create a description pane
        DescriptionPane descriptionPane = new DescriptionPane();

        //Set title, text, and image in the description pane
        descriptionPane.setTitle("Canada");
        String description = "The Canadian national flag...";
        Image image0 = new Image("C:\\Users\\mques\\Downloads\\CanadaFlag.png", 100, 100, true, true);
        descriptionPane.setImageView(new ImageView(image0)); descriptionPane.setDescription(description);

        //Create a scene and place it in the stage
        Scene scene = new Scene(descriptionPane, 450, 200);
        primaryStage.setTitle("TextAreaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}