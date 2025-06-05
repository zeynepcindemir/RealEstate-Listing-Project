package com.example.myrealestateproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller3 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<String> myListView3;

    @FXML
    private Label myLabel3;
    String[] isitmaTipleri = {"Kombi", "Şömine", "Merkezi Isıtma Sistemi", "Jeotermal Isıtma", "Kat Kaloriferi", "Isı Pompası", "Doğalgaz Sobası"};
    String seciliIsitmaTipi;


    public void switchToScene4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListView3.getItems().addAll(isitmaTipleri);

        myListView3.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                seciliIsitmaTipi = myListView3.getSelectionModel().getSelectedItem();

                myLabel3.setText(seciliIsitmaTipi);

                SceneController.getInstance().getDataList().add(seciliIsitmaTipi);
                SceneController.getInstance().addStringToKey("IsitmaTipi", seciliIsitmaTipi);

            }
        });
    }

}
