
package com.myjavafx.javafx; import com.almasb.fxgl.physics.CollisionResult;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class BallPane extends Pane {
    public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;
    private PathTransition pathTransition;
    private TriangleMesh triangle;

    public BallPane() {
        circle.setFill(Color.GREEN);
        getChildren().add(circle);

        //Create an animation for moving the ball
        animation = new Timeline(
                new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Polyline path = new Polyline();
        path.getPoints().addAll(
                (Math.random()), (Math.random() * 20.0), //0.
                (Math.random() * 05.0), (Math.random() * 60.0),
                (Math.random() * 25.0), (Math.random() * 20.0),
                (Math.random() * 50.0), (Math.random() * 60.0),
                (Math.random() * 75.0), (Math.random() * 20.0),
                (Math.random() * 100.0), (Math.random() * 60.0), //5 6 total^
                (Math.random() * 101.0), (Math.random() * 20.0), //6
                (Math.random() * 125.0), (Math.random() * 60.0),
                (Math.random() * 150.0), (Math.random() * 20.0),
                (Math.random() * 175.0), (Math.random() * 60.0),
                (Math.random() * 195.0), (Math.random() * 20.0),
                (Math.random() * 200.0), (Math.random() * 60.0), //11 6total^
                (Math.random() * 201.0), (Math.random() * 20.0), //12
                (Math.random() * 220.0), (Math.random() * 60.0),
                (Math.random() * 240.0), (Math.random() * 20.0),
                (Math.random() * 250.0), (Math.random() * 60.0),
                (Math.random() * 275.0), (Math.random() * 20.0),
                (Math.random() * 300.0), (Math.random() * 60.0), //17 6total^
                (Math.random() * 301.0), (Math.random() * 20.0), //18
                (Math.random() * 320.0), (Math.random() * 60.0),
                (Math.random() * 340.0), (Math.random() * 20.0),
                (Math.random() * 350.0), (Math.random() * 60.0),
                (Math.random() * 375.0), (Math.random() * 20.0),
                (Math.random() * 400.0), (Math.random() * 60.0));//23 total6


        path.setStroke(Color.TRANSPARENT);
        getChildren().add(path);

        pathTransition = new PathTransition();
        pathTransition.setNode(circle); // Set the ball as the object to animate
        pathTransition.setPath(path); // Set the path
        pathTransition.setDuration(Duration.seconds(4)); // Duration of one cycle
        pathTransition.setCycleCount(PathTransition.INDEFINITE); // Repeat indefinitely
        pathTransition.setAutoReverse(true); // Reverse direction at the end of each cycle
        pathTransition.play();

    }

    public void setColorRandom(){
        int d = (int)(Math.random() * 10);

        switch(d){
            case 0:
                circle.setFill(Color.BLUE);
                break;
            case 1:
                circle.setFill(Color.GREEN);
                break;
            case 2:
                circle.setFill(Color.YELLOW);
                break;
            case 3:
                circle.setFill(Color.RED);
                break;
            case 4:
                circle.setFill(Color.ORANGE);
                break;
            case 5:
                circle.setFill(Color.PURPLE);
                break;
            case 6:
                circle.setFill(Color.GRAY);
                break;
            case 7:
                circle.setFill(Color.TURQUOISE);
                break;
            case 8:
                circle.setFill(Color.GOLD);
                break;
            default:
                break;
        }
    }

    public void play() {
        animation.play();
        pathTransition.play();
    }

    public void pause() {
        animation.pause();
        pathTransition.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
        pathTransition.setRate(pathTransition.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(
                animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
        pathTransition.setRate(pathTransition.getRate() > 0 ? pathTransition.getRate() - 0.1 : 0); // Decrease path transition speed

    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    protected void moveBall() {
        //Check boundaries
        if (x < radius || x > getWidth() - radius) {
            dx *= -1;
        }
        if (y < radius || y > getHeight() - radius) {
            dy *= -1;
        }

        //Adjust ball position
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);

    }
}
