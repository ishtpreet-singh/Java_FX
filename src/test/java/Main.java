import javafx.application.Application;
import view.DictionaryView;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) {
        DictionaryView dictionaryView = new DictionaryView();
        launch(dictionaryView.getClass(), args);

    }
}