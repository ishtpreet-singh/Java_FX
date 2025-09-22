package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class DictionaryView extends Application {
    private final DictionaryController controller = new DictionaryController();

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Virtual Dictionary");

        // Components
        javafx.scene.control.TextField textfield = new javafx.scene.control.TextField();
        textfield.setPromptText("Enter a word");

        javafx.scene.control.Button searchButton = new javafx.scene.control.Button("Search");
        javafx.scene.control.Label resultLabel = new Label();

        // Action for the button
        searchButton.setOnAction(event -> {
            String word = textfield.getText();
            String meaning = controller.searchWord(word);
            resultLabel.setText(meaning);
        });

        // Layout
        VBox root = new VBox(10);
        root.getChildren().addAll(textfield, searchButton, resultLabel);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}