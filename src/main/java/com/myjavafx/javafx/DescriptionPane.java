package com.myjavafx.javafx;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class DescriptionPane extends BorderPane {
    /** Label for displaying an image and a title */
    private Label lb1ImageTitle = new Label();

    /**Text area for displaying text */
    private TextArea taDescription = new TextArea();

    public DescriptionPane() {
        //Center the icon and text and place the text under the icon
        lb1ImageTitle.setContentDisplay(ContentDisplay.TOP);

        //Set the font in the label and the text field
        lb1ImageTitle.setFont(new Font("SansSerif", 16));
        taDescription.setFont(new Font("Serif", 14));

        taDescription.setWrapText(true);
        taDescription.setEditable(false);

        //Create a scroll pane to hold the text area
        ScrollPane scrollPane = new ScrollPane(taDescription);

        //Place label and scroll pane in the border pane
        setLeft(lb1ImageTitle);
        setCenter(scrollPane);
        setPadding(new Insets(5,5,5,5));
    }

    /** Set the title */
    public void setTitle(String title) {
        lb1ImageTitle.setText(title);
    }

    /** Set the image view */
    public void setImageView(ImageView icon) {
        lb1ImageTitle.setGraphic(icon);
    }

    /**Set the text description */
    public void setDescription(String text) {
        taDescription.setText(text);
    }
}