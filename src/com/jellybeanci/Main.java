package com.jellybeanci;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    public static Stage stg;

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
        stage.setTitle("Photo to ASCII");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 310, 310));
        stage.show();
        root.requestFocus();
        stg = stage;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
