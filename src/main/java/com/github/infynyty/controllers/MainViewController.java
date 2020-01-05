package com.github.infynyty.controllers;

import com.github.infynyty.task.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.format.DateTimeFormatter;


public class MainViewController {


    @FXML
    public void initialize() {

        treeview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                updateSelectedItem(newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Added listener");
    }

    @FXML
    private TreeView<String> treeview;

    @FXML
    DatePicker datePicker;

    @FXML
    private Button button;

    @FXML
    private TreeItem dailyTasks;

    @FXML
    private TreeItem addTask;

    @FXML
    private Label testLabel;

    @FXML
    void test(ActionEvent event) {
        dailyTasks.getChildren().clear();
        dailyTasks.getChildren().add(new TreeItem<>("All tasks completed"));
        dailyTasks.getChildren().add(new TreeItem<>("Task on: " + datePicker.getValue().format(DateTimeFormatter.ISO_DATE)));
    }
    private void updateSelectedItem(Object newValue) throws IOException {
        System.out.println("Called Function");
        if(newValue.equals(addTask)) {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/AddTask.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Scheducation");
            stage.showAndWait();
            dailyTasks.getChildren().add(new TreeItem<>(AddTaskController.text));
            TreeItem treeItem = new TreeItem<>("Test");

        }
        TreeItem itemName = (TreeItem) newValue;
        if(Task.getTaskByName().containsKey(itemName.getValue())) {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/DetailedTaskView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Detailed view");
            stage.showAndWait();
        }
    }

    public TreeItem getDailyTasks() {
        return dailyTasks;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public Label getTestLabel() {
        return testLabel;
    }

    public void updateLabel(String text) {
        testLabel.setText(text);

    }
}
