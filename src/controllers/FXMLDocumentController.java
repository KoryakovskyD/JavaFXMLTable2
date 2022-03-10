/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Car;


/**
 *
 * @author denis
 */
public class FXMLDocumentController implements Initializable {

    boolean changeCSS= true;
    
    @FXML
    private TableView table;
    @FXML
    TableColumn numCol;
    @FXML
    TableColumn modelCol;

    
    @FXML
    private void handleButton1Action(ActionEvent event) {
        Car car = new Car(11, "Linman");
        addPerson(car);
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
    public void handleButton3Action(ActionEvent actionEvent) {
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
    
    private ObservableList<Car> getPersonList (){
        ArrayList<Car> arrayList = new ArrayList<>();
        arrayList.add(new Car (1, "Simpole"));
        arrayList.add(new Car (2, "Shortt"));
        arrayList.add(new Car (3, "Hambright"));
        arrayList.add(new Car (4, "Reubel"));
        arrayList.add(new Car (5, "Hazleton"));
        arrayList.add(new Car (6, "Ferrie"));
        arrayList.add(new Car (7, "Bobasch"));
        
        return FXCollections.observableArrayList(arrayList);
    }
    
    private void addPerson (Car p){
        List<Car> list = table.getItems().subList(0, table.getItems().size());
        list.add(p);
        updateTable(FXCollections.observableArrayList(list));
    }




}
