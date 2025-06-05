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

public class Controller5 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<String> myListView5;

    @FXML
    private Label myLabel5;
    String[] binaTipleri = {"Apartman", "Villa", "Plaza", "Yalı", "Dubleks", "Gökdelen", "Müstakil"};

    String seciliBinaTipi;


    public void switchToScene6(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene6.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListView5.getItems().addAll(binaTipleri);

        myListView5.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                seciliBinaTipi = myListView5.getSelectionModel().getSelectedItem();

                myLabel5.setText(seciliBinaTipi);
                SceneController.getInstance().getDataList().add(seciliBinaTipi);
                SceneController.getInstance().addStringToKey("BinaTipi",seciliBinaTipi);

            }
        });
    }

}

