package controller;

import domain.Elementary;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class    CountingSort
{
    @javafx.fxml.FXML
    private Button bt_randomize;
    @javafx.fxml.FXML
    private TableView tableViewNoSorted;
    @javafx.fxml.FXML
    private Button bt_start;
    @javafx.fxml.FXML
    private TableView tableViewCountingSortedArray1;
    @javafx.fxml.FXML
    private TableView tableViewCounterSorted;
    TableColumn tableColumnsNoSort[] = new TableColumn[200];
    TableColumn tableColumnsSort[] = new TableColumn[200];
    private int arrayNumbers[];
    private Alert alert;
    Elementary elementary = new Elementary();
    @javafx.fxml.FXML
    public void initialize() {
        arrayNumbers = new int[200];
        util.Utility.fill(arrayNumbers,200);
    }
    //Este boton debe ordenar mostrar el arreglo ademas, de mostrar los valores no acomodados
    @javafx.fxml.FXML
    public void startOnAction(ActionEvent actionEvent) {
        startColumns();
        getData(arrayNumbers);
        startSortedColumns();
        startCounterColumns();
    }
    //Limpia el tableView de valores y llena el arreglo de números randoms nuevamente
    @javafx.fxml.FXML
    public void randomizeOnAction(ActionEvent actionEvent) {
        tableViewNoSorted.getItems().clear();
        tableViewCounterSorted.getItems().clear();
        tableViewCountingSortedArray1.getItems().clear();
        initialize();
    }
    private ObservableList<List<String>> getData(int[] arrayNum) {
        ObservableList<List<String>> data = FXCollections.observableArrayList();

        if (arrayNum != null){
            try {
                List<String> lista = new ArrayList<>();
                int n = arrayNum.length;

                for (int j = 0; j < n; j++) {
                    lista.add(String.valueOf(arrayNum[j]));
                }
                data.add(lista);
            } catch (Exception e){
                throw new RuntimeException();
            }
        }
        return data;
    }
    private void startColumns(){
        this.tableViewNoSorted.getColumns().clear();

        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            //<>
            TableColumn<List<String>, String> column = new TableColumn<>(""+i);
            column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            this.tableViewNoSorted.getColumns().add(column);

        }
        this.tableViewNoSorted.setItems(getData(arrayNumbers));
    }
    private void startSortedColumns(){
        this.tableViewCountingSortedArray1.getColumns().clear();

        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            //<>
            TableColumn<List<String>, String> column = new TableColumn<>(""+i);
            column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            this.tableViewCountingSortedArray1.getColumns().add(column);

        }
        this.tableViewCountingSortedArray1.setItems(getDataSorted());
    }
    private void startCounterColumns(){
        this.tableViewCounterSorted.getColumns().clear();

        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            //<>
            TableColumn<List<String>, String> column = new TableColumn<>(""+i);
            column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            this.tableViewCounterSorted.getColumns().add(column);

        }
        this.tableViewCounterSorted.setItems(getDataCounter());
    }

    public ObservableList<List<String>> getDataSorted() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        if (arrayNumbers.length != 0) {
            try {
                // Aquí deberías ordenar el arreglo
                elementary.countingSort(arrayNumbers);

                List<String> listaNumeros = new ArrayList<>();
                for (int i = 0; i < 200; i++) {
                    listaNumeros.add(String.valueOf(arrayNumbers[i]));
                }
                data.add(listaNumeros);
            } catch (Exception ex) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Error in the process");
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("The array is Empty");
        }
        return data;
    }
    public ObservableList<List<String>> getDataCounter() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        if (arrayNumbers.length != 0) {
            try {
                // Aquí deberías ordenar el arreglo
                int array[];
                array = elementary.getCounterRepeatNumber();

                List<String> listaNumeros = new ArrayList<>();
                for (int i = 0; i < 200; i++) {
                    listaNumeros.add(String.valueOf(array[i]));
                }
                data.add(listaNumeros);
            } catch (Exception ex) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Error in the process");
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("The array is Empty");
        }
        return data;
    }
}