package view;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import controller.PetController;
import model.Pet;

public class PetView extends Application {

    private double mouseX = 0;
    private double mouseY = 0;
    private boolean mouseInside = false;

    @Override
    public void start(Stage primaryStage) {
        Pet pet = new Pet(200, 200);
        PetController controller = new PetController(pet);

        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Cute pet image (criteria 1)
        Image petImage = new Image("https://cdn-icons-png.flaticon.com/512/616/616408.png", 50, 50, true, true);

        canvas.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY = e.getY();
            mouseInside = true;
        });

        canvas.setOnMouseExited(e -> mouseInside = false);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                if (mouseInside) {
                    controller.movePetTowards(mouseX, mouseY);
                }
                gc.drawImage(petImage, pet.getX() - petImage.getWidth() / 2, pet.getY() - petImage.getHeight() / 2);
            }
        }.start();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Virtual Pet");
        primaryStage.show();
    }
}