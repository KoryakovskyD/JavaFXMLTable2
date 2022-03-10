package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafxmltable2.DbServer;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLAddNewCarController implements Initializable {

    @FXML
    TextArea textArea;
    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleButtonAction(ActionEvent actionEvent) {

        if (! textArea.getText().isEmpty()) {
            String[] words = textArea.getText().split(" ");
            Integer num = null;
            String model = null;
            int i = 0;
            for (String word : words) {
                if (i == 0) {
                    num = Integer.parseInt(word);
                    i++;
                } else
                    model = word;
            }
            DbServer dbServer = new DbServer("jdbc:derby://localhost:1527/j140", "j140", "j140");
            dbServer.start();
            dbServer.addCar(num, model);
            ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
        }
    }
}
