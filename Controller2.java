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

public class Controller2 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<String> myListView2;
    @FXML
    private Label myLabel2;
    String[] odaSayilari = {"1+1", "2+1", "3+1", "4+1", "5+1", "6+1", "5+2"};

    String seciliOdaSayisi;


    public void switchToScene3(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListView2.getItems().addAll(odaSayilari);

        myListView2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                seciliOdaSayisi = myListView2.getSelectionModel().getSelectedItem();

                myLabel2.setText(seciliOdaSayisi);
                SceneController.getInstance().getDataList().add(seciliOdaSayisi);
                SceneController.getInstance().addStringToKey("OdaSayisi",seciliOdaSayisi);


            }
        });
    }


}
