package com.github.infynyty.controllers;

import com.github.infynyty.Importance;
import com.github.infynyty.Subject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailedTaskViewController implements Initializable {

    @FXML public Label nameLabel;
    @FXML public Label subjectLabel;
    @FXML public Label importanceLabel;
    @FXML public TextField editName;
    @FXML public ChoiceBox<Subject> editSubject;
    @FXML public ChoiceBox<Importance> editImportance;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editImportance.getItems().addAll(Importance.values());
        editSubject.getItems().addAll(Subject.values());
    }
}
