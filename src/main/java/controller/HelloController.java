
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class HelloController {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Text txtMessage;

    private void loadPage(String page) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Home(ActionEvent event) {
        this.txtMessage.setText("Laboratory No. 7");
        this.bp.setCenter(ap);
    }

    @FXML
    void bubbleSortOnAction(ActionEvent event) {
        loadPage("BubbleSort.fxml");
    }

    @FXML
    void countingSortOnAction(ActionEvent event) {
        loadPage("CountingSort.fxml");
    }

    @FXML
    void improvedBubbleSortOnAction(ActionEvent event) {
        loadPage("ImprovedBubbleSort.fxml");
    }

    @FXML
    void mergeSortOnAction(ActionEvent event) {
        loadPage("MergeSort.fxml");
    }

    @FXML
    void quixkSortOnAction(ActionEvent event) {
        loadPage("QuickSort.fxml");
    }

    @FXML
    void radixSortOnAction(ActionEvent event) {
        loadPage("RadixSort.fxml");
    }

    @FXML
    void selectionSortOnAction(ActionEvent event) {
        loadPage("SelectionSort.fxml");
    }

    @FXML
    void shellSortOnAction(ActionEvent event) {
        loadPage("ShellSort.fxml");
    }

}