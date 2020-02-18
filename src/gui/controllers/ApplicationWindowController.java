package gui.controllers;

import filehandler.FileHandler;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ApplicationWindowController implements Initializable {

    @FXML
    private TextArea textArea;

    private FileHandler fileHandler;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileHandler = new FileHandler();
    }

    @FXML
    private void saveFile() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(new Stage());
        if(!file.getName().endsWith(".txt")) {
            fileHandler.writeFile(file.getAbsolutePath()+".txt", textArea.getText());
        }
        else {
            fileHandler.writeFile(file.getAbsolutePath(), textArea.getText());
        }
    }

    @FXML
    private void loadFile() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(new Stage());
        if(file.getName().endsWith(".txt")) {
            textArea.setText(fileHandler.readFile(file.getAbsolutePath()));
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("File is not a .txt file");
            alert.showAndWait();
        }
    }

    @FXML
    private void exit() {
        Stage stage = (Stage) textArea.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void wordCount() {
        String allText = textArea.getText();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(allText.split(" ")));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Word Count: " + words.size());
        alert.showAndWait();
    }

    @FXML
    private void characterCount() {
        String allText = textArea.getText();
        char[] chars = allText.toCharArray();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Character Count: " + chars.length);
        alert.showAndWait();
    }
}
