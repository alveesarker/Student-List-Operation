package com.example.studentlistoperation;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.GestureEvent;

import java.time.LocalDate;
import java.util.Date;

public class StudentListOperationController {
    @javafx.fxml.FXML
    private PasswordField passwordTextField;
    @javafx.fxml.FXML
    private TableColumn<Student, Integer> idTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Student, String> majorTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Student, Boolean> genderTableColumn;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfBirth;
    @javafx.fxml.FXML
    private ComboBox<String> majorComboBox;
    @javafx.fxml.FXML
    private TableColumn<Student, LocalDate> dobTableColumn;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private TableView<Student> studentTableView;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;

    @javafx.fxml.FXML
    public void initialize() {
        majorComboBox.getItems().addAll("CSE", "EEE", "ETE", "BBA");
    }

    @javafx.fxml.FXML
    public void handleAddRow(ActionEvent actionEvent) {
    }
}