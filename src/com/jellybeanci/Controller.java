package com.jellybeanci;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Controller
{

    protected static FileChooser fileChooser = new FileChooser();

    @FXML
    private void initialize()
    {
        // Open File Dialog
        ArrayList<String> extension = new ArrayList<>();
        extension.add("*.png");
        extension.add("*.jpg");
        extension.add("*.jpeg");
        extension.add("*.bmp");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", extension));
    }

    @FXML
    protected void openFileDialog()
    {
        // TODO implement here
        File selectedFile = fileChooser.showOpenDialog(Main.stg);
        Runnable r = () -> {
            System.out.println(Ascii.convert(ImageProcessor.getImageArray(loadImage(selectedFile))));
        };new Thread(r).start();
        // Select file
        // Check file (600x600 and Image and Exist)
        // Set file.
        // Draw file/image
    }

    private static void timeStamp()
    {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = ts;
        System.out.println(date);
    }

    private static Image loadImage(File file)
    {
        try
        {
            Image im = new Image(file.toURI().toString());
            return im;
        }
        catch (IllegalArgumentException ex)
        {
            showMessage("Error", "Please select a valid Image file.", Alert.AlertType.ERROR);
        }
        catch (Exception exx)
        {
            System.out.println("SomeThing Happened.");
        }
        return null;
    }

    private static void showMessage(String title, String message, Alert.AlertType alertType)
    {
        Platform.runLater(() -> {
            // Update UI here.
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }
}
