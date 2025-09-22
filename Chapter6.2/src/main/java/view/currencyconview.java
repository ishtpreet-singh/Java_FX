package view;

import controller.ConverterController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import model.CurrencyModel;

public class currencyconview extends Application {
    private TextField amountfield = new TextField();
    private TextField resultfield = new TextField();
    private ComboBox<String> fromCurrency = new ComboBox<>();
    private ComboBox<String> toCurrency = new ComboBox<>();
    private Button convertButton = new Button("Convert");
    private Label messageLabel = new Label();

    @Override
    public void start(Stage stage) {
        CurrencyModel model = new CurrencyModel();
        ConverterController controller = new ConverterController(model);

        stage.setTitle("Currency Converter");
        resultfield.setEditable(false);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        // Labels
        grid.add(new Label("Amount:"), 0, 0);
        grid.add(amountfield, 1, 0);

        grid.add(new Label("From Currency:"), 0, 1);
        grid.add(fromCurrency, 1, 1);

        grid.add(new Label("To Currency:"), 0, 2);
        grid.add(toCurrency, 1, 2);

        grid.add(convertButton, 1, 3);

        grid.add(new Label("Result:"), 0, 4);
        grid.add(resultfield, 1, 4);

        grid.add(messageLabel, 0,5,2,1);

        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.show();

        controller.init(this);
    }
    // Getters for controllers to access UI components
    public TextField getAmountfield() {
        return amountfield;
    }
    public TextField getResultfield() {
        return resultfield;
    }
    public ComboBox<String> getFromCurrency() {
        return fromCurrency;
    }
    public ComboBox<String> getToCurrency() {
        return toCurrency;
    }
    public Button getConvertButton() {
        return convertButton;
    }
    public Label getMessageLabel() {
        return messageLabel;
    }
}