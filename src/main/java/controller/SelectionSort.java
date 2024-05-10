package controller;

import domain.Elementary;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectionSort {
    @FXML
    private Button bt_randomize;
    @FXML
    private TableView<List<String>> tableViewNoSorted;
    @FXML
    private TableView<List<String>> tableViewSorted;
    @FXML
    private Button bt_start;
    @FXML
    private TextField txf_iterations;
    @FXML
    private TextField txf_min;
    @FXML
    private TextField txf_minIndex;
    private Elementary elementary = new Elementary(); // Initialize the Elementary object

    @FXML
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

    @FXML
    public void randomizeOnAction(ActionEvent actionEvent) {
        tableViewSorted.getItems().clear();
        tableViewNoSorted.getItems().clear();
        txf_iterations.clear();
        txf_min.clear();
        txf_minIndex.clear();

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


    @FXML
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
            elementary.selectionSort(dataArray);

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
            txf_iterations.setText(String.valueOf(elementary.getTotalIteraciones()));
            txf_min.setText(String.valueOf(elementary.getMinimo()));
            txf_minIndex.setText(String.valueOf(elementary.getIndiceMinimo()));

        } else {
            // Si rowData está vacía, mostrar una alerta al usuario o tomar otra acción apropiada
            System.out.println("La tabla de datos no está inicializada o está vacía.");
        }
    }
}
