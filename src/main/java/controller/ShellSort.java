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

public class ShellSort {
    @javafx.fxml.FXML
    private TableView tableViewSorted;
    @javafx.fxml.FXML
    private Button bt_randomize;
    @javafx.fxml.FXML
    private TextField txf_GabSubarray1;
    @javafx.fxml.FXML
    private TextField txf_GabSubarray2;
    @javafx.fxml.FXML
    private TableView tableViewNoSorted;
    @javafx.fxml.FXML
    private TextField txf_GabSubarray3;
    @javafx.fxml.FXML
    private Button bt_start;
    @javafx.fxml.FXML
    private TextField txf_Gap;
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
            tableViewSorted.getColumns().add(new TableColumn<>(String.valueOf(i))); // Add column to sorted table too
        }
    }

    @javafx.fxml.FXML
    public void randomizeOnAction(ActionEvent actionEvent) {
        tableViewSorted.getItems().clear();
        tableViewNoSorted.getItems().clear();
        txf_Gap.clear();
        txf_GabSubarray1.clear();
        txf_GabSubarray2.clear();
        txf_GabSubarray3.clear();

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
        tableViewSorted.getItems().clear();

        // Obtener los valores de las celdas de la tabla y almacenarlos en un arreglo
        ObservableList<List<String>> rowData = tableViewNoSorted.getItems();

        // Verificar si rowData tiene al menos un elemento
        if (!rowData.isEmpty()) {
            int[] dataArray = rowData.get(0).stream()
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // Ordenar el arreglo utilizando Selection Sort
            complex.shellSort(dataArray);

            // Limpiar y crear columnas en tableViewSorted
            tableViewSorted.getColumns().clear();
            for (int i = 0; i < dataArray.length; i++) {
                TableColumn<List<String>, String> column = new TableColumn<>(String.valueOf(i));
                final int columnIndex = i;
                column.setCellValueFactory(cellData -> {
                    List<String> row = cellData.getValue();
                    return new SimpleStringProperty(row.get(columnIndex));
                });
                tableViewSorted.getColumns().add(column);
            }

            // Agregar los datos ordenados a la tabla tableViewSorted
            List<List<String>> sortedData = new ArrayList<>();
            List<String> sortedRow = new ArrayList<>();
            for (int i = 0; i < dataArray.length; i++) {
                sortedRow.add(String.valueOf(dataArray[i]));
            }
            sortedData.add(sortedRow);
            tableViewSorted.getItems().addAll(sortedData);

            // Actualizar los campos de texto con las iteraciones, el valor mínimo y su índice correspondientes

            txf_Gap.setText(String.valueOf(complex.getAcumulaGap()));

            txf_GabSubarray1.setText(String.valueOf(complex.getAcumulaGapSub1()));

            txf_GabSubarray2.setText(String.valueOf(complex.getAcumulaGapSub2()));

            txf_GabSubarray3.setText(String.valueOf(complex.getAcumulaGapSub3()));

        } else {
            // Si rowData está vacía, mostrar una alerta al usuario o tomar otra acción apropiada
            System.out.println("La tabla de datos no está inicializada o está vacía.");
        }
    }
}