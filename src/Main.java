
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage mainStage;
    Scene mainScene;

    @Override
    public void start(Stage stage) throws Exception {
        //Set the mainStage
        mainStage = stage;
        // Attempt
        try {
            // Load the FXML
            Parent root = FXMLLoader.load(getClass().getResource("gui/fxml/ApplicationWindow.fxml"));
            // Set the scene to the loaded FXML
            mainScene = new Scene(root, 480, 640);
            mainStage.setScene(mainScene);
        }
        // Catch
        catch (Exception e) {
            // Error handling occurs here
            System.err.println(e.getMessage());
        }
        mainStage.setResizable(false);
        // Show the window
        mainStage.show();
    }

}
