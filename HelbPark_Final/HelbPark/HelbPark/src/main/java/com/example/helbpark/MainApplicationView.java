

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplicationView extends Application {
    @Override
    public void start(Stage stage) throws IOException { // La vue principal de notre application
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationView.class.getResource("MainView.fxml"));
          MainControler controler = new MainControler();
          fxmlLoader.setController(controler);
        Scene scene = new Scene(fxmlLoader.load(), 575, 475);
        stage.setTitle("Helb Park");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
