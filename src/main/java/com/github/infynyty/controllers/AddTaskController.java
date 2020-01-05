package com.github.infynyty.controllers;

import com.github.infynyty.Importance;
import com.github.infynyty.Subject;
import com.github.infynyty.task.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddTaskController {

    public static String text;
    public static boolean reset = true;

    @FXML
    public ChoiceBox<Subject> subjectMenu;

    @FXML
    public ChoiceBox<Importance> importanceMenu;

    @FXML
    public TextField nameField;

    @FXML
    public Button addTaskButton;

    @FXML
    public Button cancelButton;

    @FXML
    public Label addTaskTextField;

    @FXML
    public void initialize() {
        subjectMenu.getItems().addAll(Subject.values());
        importanceMenu.getItems().addAll(Importance.values());
    }

    @FXML
    public void addTask(ActionEvent actionEvent) throws IOException {
        reset = false;
        if((!nameField.getText().isBlank()) && subjectMenu.getValue() != null && importanceMenu.getValue() != null) {
            if(!Task.getTaskByName().containsKey(nameField.getText())) {
                System.out.println("Event: Name: " + nameField.getText() + " Subject: " + subjectMenu.getValue() + " Importance: " + importanceMenu.getValue());
                new Task(subjectMenu.getValue(), importanceMenu.getValue(), nameField.getText());
                text = nameField.getText();

                reset = false;

                Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                stage.close();
            } else {
                addTaskTextField.setText("This name already exists, please choose a different one!");
                addTaskTextField.setStyle("-fx-text-fill: #FF0040");
            }

        } else {
            addTaskTextField.setText("Please fill in  all options!");
            addTaskTextField.setStyle("-fx-text-fill: #FF0040");
        }

    }

    @FXML
    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
