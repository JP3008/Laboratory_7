package controller;

import domain.Complex;
import domain.Elementary;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class QuickSort
{
    @javafx.fxml.FXML
    private Button bt_randomize;
    @javafx.fxml.FXML
    private TableView tableViewNoSorted;
    @javafx.fxml.FXML
    private Button bt_start;
    @javafx.fxml.FXML
    private TableView tableViewQuickSorted;
    @javafx.fxml.FXML
    private TextField txf_high;
    @javafx.fxml.FXML
    private TextField txf_Low;
    @javafx.fxml.FXML
    private TextField txf_pivot;
    @javafx.fxml.FXML
    private TextField txf_RecursiveCalls;
    private int arrayNumbers[];
    private Alert alert;
    Complex complex = new Complex();
    @javafx.fxml.FXML
    public void initialize() {
        arrayNumbers = new int[200];
        util.Utility.fill(arrayNumbers);
    }
    //Este boton debe ordenar mostrar el arreglo ademas, de mostrar los valores no acomodados
    @javafx.fxml.FXML
    public void startOnAction(ActionEvent actionEvent) {
        startColumns();
        getData(arrayNumbers);
        startSortedColumns();
        //Agregar los valores a los txtField
        txf_pivot.setText(complex.getListPivot());
        txf_Low.setText(complex.getListlow());
        txf_high.setText(complex.getListHigh());
        txf_RecursiveCalls.setText(String.valueOf(complex.getRecursiveCalling()));
    }
    //Limpia el tableView de valores y llena el arreglo de números randoms nuevamente
    @javafx.fxml.FXML
    public void randomizeOnAction(ActionEvent actionEvent) {
        tableViewNoSorted.getItems().clear();
        tableViewQuickSorted.getItems().clear();
        txf_pivot.setText("");
        txf_Low.setText("");
        txf_high.setText("");
        txf_RecursiveCalls.setText("");
        complex.setRecursiveCalling();
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
        this.tableViewQuickSorted.getColumns().clear();

        for (int i = 0; i < 200; i++) {
            final int colIndex = i;
            //<>
            TableColumn<List<String>, String> column = new TableColumn<>(""+i);
            column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            this.tableViewQuickSorted.getColumns().add(column);

        }
        this.tableViewQuickSorted.setItems(getDataQuickSorted());
    }

    public ObservableList<List<String>> getDataQuickSorted() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        if (arrayNumbers.length != 0) {
            try {
                // Aquí deberías ordenar el arreglo
                complex.quickSort(arrayNumbers,getLowNumber(),getHighNumber());
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
    public int getLowNumber(){
        int lowNumber = arrayNumbers[0];
        for (int i = 1; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i]<lowNumber){
                lowNumber = arrayNumbers[i];
            }
        }
        return lowNumber;
    }
    public int getHighNumber(){
        int highNumber = arrayNumbers[0];
        for (int i = 1; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i]>highNumber){
                highNumber = arrayNumbers[i];
            }
        }
        return highNumber;
    }
}