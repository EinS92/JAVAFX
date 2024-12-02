package com.myjavafx.javafx; import javafx.application.Application;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MediaDemo extends Application {
    private static final String MEDIA_URL =
      "http://liveexample.pearsoncmg.com/common/sample.mp4";

    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button(">");
        playButton.setOnAction(e -> {
          if (playButton.getText().equals(">")) {
              mediaPlayer.play();
              playButton.setText("||");
          } else {
              mediaPlayer.pause();
              playButton.setText(">");
          }
        });

        Button rewindButton = new Button("<<");
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider s1Volume = new Slider();
        s1Volume.setPrefWidth(150);
        s1Volume.setMaxWidth(Region.USE_PREF_SIZE);
        s1Volume.setMinWidth(30);
        s1Volume.setValue(50);
        mediaPlayer.volumeProperty().bind(
          s1Volume.valueProperty().divide(100));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton,
          new Label("Volume"), s1Volume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("MediaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
