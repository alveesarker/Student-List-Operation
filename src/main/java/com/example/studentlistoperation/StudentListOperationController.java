package com.example.studentlistoperation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentListOperationController {
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TableColumn<Student, Integer> idTableColumn;
    @FXML
    private TableColumn<Student, String> nameTableColumn;
    @FXML
    private TableColumn<Student, String> majorTableColumn;
    @FXML
    private TableColumn<Student, String> genderTableColumn; // Changed to String
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private ComboBox<String> majorComboBox;
    @FXML
    private TableColumn<Student, LocalDate> dobTableColumn;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private ToggleGroup genderToggleGroup;

    // List to store student data
    private List<Student> studentList = new ArrayList<>();

    // ObservableList to bind with TableView
    private ObservableList<Student> observableStudentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize major combo box
        majorComboBox.getItems().addAll("CSE", "EEE", "ETE", "BBA");

        // Set up gender toggle group
        maleRadioButton.setToggleGroup(genderToggleGroup);
        femaleRadioButton.setToggleGroup(genderToggleGroup);

        // Bind TableView columns to Student properties
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dobTableColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        majorTableColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        // Bind the observable list to the TableView
        studentTableView.setItems(observableStudentList);
    }

    @FXML
    public void handleAddRow(ActionEvent actionEvent) {
        try {
            // Validate and retrieve input data
            int id = Integer.parseInt(idTextField.getText());
            String name = nameTextField.getText();
            LocalDate dob = dateOfBirth.getValue();
            String major = majorComboBox.getValue();
            String password = passwordTextField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";

            // Validate required fields
            if (name.isEmpty() || dob == null || major == null || gender == null) {
                showAlert("Error", "Please fill in all fields.");
                return;
            }

            // Create a new Student object
            Student student = new Student(id, name, dob, major, password, gender);

            // Add the student to the list and observable list
            studentList.add(student);
            observableStudentList.add(student);

            // Clear input fields
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid ID. Please enter a valid number.");
        } catch (Exception e) {
            showAlert("Error", "An error occurred: " + e.getMessage());
        }
    }

    // Helper method to clear input fields
    private void clearFields() {
        idTextField.clear();
        nameTextField.clear();
        dateOfBirth.setValue(null);
        majorComboBox.getSelectionModel().clearSelection();
        passwordTextField.clear();
        genderToggleGroup.selectToggle(null);
    }

    // Helper method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}