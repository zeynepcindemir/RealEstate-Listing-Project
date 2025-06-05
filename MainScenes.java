package com.example.myrealestateproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

/*
YAP441 - Emlak Filtreleme Sistemi Projesi
Zeynep ÇİNDEMİR (201401012)
*/

public class MainScenes extends Application {

    @Override
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
            Scene scene = new Scene(root);

            stage.setTitle("_!_EMLAK FİLTRELEME PROJESİ_!_");
            Image image = new Image("C:\\Users\\zcindemir\\IdeaProjects\\MyRealEstateProject\\src\\main\\java\\com\\example\\myrealestateproject\\myLogo.png");
            stage.getIcons().add(image);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // the main method to start process
    public static void main(String[] args) {
        KonutReader.readAndBuilt();
        launch(args);
    }
}