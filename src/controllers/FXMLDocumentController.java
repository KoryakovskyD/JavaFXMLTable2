
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxmltable2.AddCar;
import javafxmltable2.DbServer;
import model.Car;


public class FXMLDocumentController implements Initializable {

    boolean changeCSS= true;
    
    @FXML
    private TableView table;
    @FXML
    TableColumn numCol;
    @FXML
    TableColumn modelCol;

    
    @FXML
    private void handleButton3Action(ActionEvent event) {
        updateTable(getPersonList());
    }

    @FXML
    public void handleButton2Action(ActionEvent actionEvent) {
        if (changeCSS) {
            table.getStylesheets().clear();
            table.getStylesheets().add("file:default.css");
        } else {
            table.getStylesheets().clear();
            table.getStylesheets().add("file:modena.css");
        }
        changeCSS = !changeCSS;
    }

    @FXML
    public void handleButton1Action(ActionEvent actionEvent) {
        try {
            new AddCar().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTable(getPersonList ());
    }    
    
    private void updateTable(ObservableList<Car> list){
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        table.setItems(list);
    }

    private ObservableList<Car> getPersonList() {
        DbServer dbServer = new DbServer("jdbc:derby://localhost:1527/j140", "j140", "j140");
        dbServer.start();
        return FXCollections.observableArrayList(dbServer.getCars());
    }


}
