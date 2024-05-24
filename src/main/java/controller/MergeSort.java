package controller;

import domain.Complex;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSort
{
    @javafx.fxml.FXML
    private Button bt_randomize;
    @javafx.fxml.FXML
    private TableView tableViewNoSorted;
    @javafx.fxml.FXML
    private Button bt_start;
    @javafx.fxml.FXML
    private TextField txf_high;
    @javafx.fxml.FXML
    private TableView tableViewMergeSortedArray;
    @javafx.fxml.FXML
    private TextField txf_Low;
    @javafx.fxml.FXML
    private TableView tableViewTempArray;
    @javafx.fxml.FXML
    private TextField txf_RecursiveCalls;
    private Complex complex = new Complex();

    @javafx.fxml.FXML
    public void initialize() {
        for (int i = 0; i < 200; i++) {
            TableColumn<List<String>, String> column = new TableColumn<>(String.valueOf(i));

            int columnIndex = i;

            column.setCellValueFactory(cellData -> {
                List<String> row = cellData.getValue();
                return new SimpleStringProperty(row.get(columnIndex));
            });

            tableViewNoSorted.getColumns().add(column);
            tableViewTempArray.getColumns().add(new TableColumn<>(String.valueOf(i)));
            tableViewMergeSortedArray.getColumns().add(new TableColumn<>(String.valueOf(i)));

        }
    }

    @javafx.fxml.FXML
    public void randomizeOnAction(ActionEvent actionEvent) {
        tableViewMergeSortedArray.getColumns().clear();
        tableViewNoSorted.getItems().clear();
        tableViewTempArray.getColumns().clear();
        txf_high.clear();
        txf_Low.clear();
        txf_RecursiveCalls.clear();


        Random rand = new Random();
        ObservableList<List<String>> rowData = FXCollections.observableArrayList();
        List<String> row = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            int randomNum = rand.nextInt(100);
            row.add(String.valueOf(randomNum));
        }
        rowData.add(row);
        tableViewNoSorted.setItems(rowData);
    }


    @javafx.fxml.FXML
    public void startOnAction(ActionEvent actionEvent) {
        // Limpiar la tabla de datos ordenados antes de agregar nuevas filas
        tableViewMergeSortedArray.getItems().clear();
        tableViewTempArray.getItems().clear();

        // Obtener los valores de las celdas de la tabla y almacenarlos en un arreglo
        ObservableList<List<String>> rowData = tableViewNoSorted.getItems();

        // Verificar si rowData tiene al menos un elemento
        if (!rowData.isEmpty()) {
            int[] dataArray = rowData.get(0).stream()
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] tmpArray = new int[dataArray.length]; // Crear un arreglo temporal del mismo tamaño que dataArray

            // Ordenar el arreglo utilizando Merge Sort
            complex.mergeSort(dataArray, tmpArray, 0, dataArray.length - 1);



            for (int i = 0; i < dataArray.length; i++) {
                TableColumn<List<String>, String> column = new TableColumn<>(String.valueOf(i));
                final int columnIndex = i;
                column.setCellValueFactory(cellData -> {
                    List<String> row = cellData.getValue();
                    return new SimpleStringProperty(row.get(columnIndex));
                });
                tableViewMergeSortedArray.getColumns().add(column);
                tableViewTempArray.getColumns().add(column);
            }

            // Agregar los datos ordenados a la tabla tableViewSorted
            List<List<String>> sortedData = new ArrayList<>();
            List<List<String>> sortedDataTemp = new ArrayList<>();
            List<String> sortedRow = new ArrayList<>();
            List<String> sortedRowTemp = new ArrayList<>();
            for (int i = 0; i < dataArray.length; i++) {
                sortedRow.add(String.valueOf(dataArray[i]));
                sortedRowTemp.add(String.valueOf(tmpArray[i]));
            }
            sortedData.add(sortedRow);
            sortedDataTemp.add(sortedRowTemp);
            tableViewMergeSortedArray.getItems().addAll(sortedData);
            tableViewTempArray.getItems().addAll(sortedDataTemp);


            // Actualizar los campos de texto con las iteraciones, el valor mínimo y su índice correspondientes

            txf_high.setText(String.valueOf(complex.getListHighMerge()));

            txf_Low.setText(String.valueOf(complex.getListLowMerge()));

            txf_RecursiveCalls.setText(String.valueOf(complex.getRecursiveCallingMerge()));



        } else {
            // Si rowData está vacía, mostrar una alerta al usuario o tomar otra acción apropiada
            System.out.println("La tabla de datos no está inicializada o está vacía.");
        }
    }

}