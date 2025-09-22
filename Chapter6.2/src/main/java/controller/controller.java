package controller;

import javafx.application.Application;
import model.CurrencyModel;
import view.currencyconview;

public class ConverterController {
    private CurrencyModel model;

    public ConverterController(CurrencyModel model) {
        this.model = model;
    }

    public void init(currencyconview view){
        // Fill combo box
        view.getFromCurrency().getItems().addAll(model.getCurrencies().keySet());
        view.getToCurrency().getItems().addAll(model.getCurrencies().keySet());

        view.getFromCurrency().getSelectionModel().selectFirst();
        view.getToCurrency().getSelectionModel().select(1);

        // Handle button click
        view.getConvertButton().setOnAction(e -> {
            try{
                double amount = Double.parseDouble(view.getAmountfield().getText());
                String from = view.getFromCurrency().getValue();
                String to = view.getToCurrency().getValue();

                double result = model.convert(from, to, amount);
                view.getResultfield().setText(String.format("%.2f", result));
                view.getMessageLabel().setText("");
            }
            catch(NumberFormatException ex){
                view.getMessageLabel().setText("Invalid amount. Enter a numeric value.");
            }
            catch(Exception ex){
                view.getMessageLabel().setText("Error: " + ex.getMessage());
            }
        });
    }
    public static void main(String[] args){
        Application.launch(currencyconview.class, args);
    }
}