package com.myjavafx.javafx; import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {
    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        //Create a pane and set its properties
        Pane pane = new Pane();
        Text text = new Text(20,20,"A");

        pane.getChildren().add(text);
        text.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN: text.setY(text.getY() + 10); break;
                case UP: text.setY(text.getY() - 10); break;
                case LEFT: text.setX(text.getX() - 10); break;
                case RIGHT: text.setX(text.getX() + 10); break;
                default:
                    if (e.getText().length() > 0)
                        text.setText(e.getText());
            }
        });

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("KeyEventDemo");
        primaryStage.setScene(scene);
        primaryStage.show();

        text.requestFocus();
    }
}

/** What is ---> e.getCode() <---
 *
 *  What is [e]:
 *  In this context, [e] is the [event object] passed to your event handler.
 *  It represents the [specific user action] that triggered the event,
 *  like pressing a key, clicking a button, etc.
 *
 *  what is [.getCode()]?
 *  [getCode()] is a method available on [key events] (like KeyEvent) in JavaFX.
 *  It retrieves the [KeyCode] associated with the key that was pressed.
 *
 * What is [KeyCode]?
 * A [KeyCode] is an enumeration in JavaFX that represents all possible keys on
 * a keyboard (like [UP], [DOWN], [LEFT],[A],[ENTER],etc.)
 * For example:
 * If you press the [UP ARROW], [getCode()] returns [KeyCode.UP]
 * If you press the letter [A], [getCode()] returns [KeyCode.A].
 *
 *
 * Where does [getCode() come from?
 * The [getCode()] method is part of the KeyEvent class, which represents
 * keyboard-related events.
 *
 * */