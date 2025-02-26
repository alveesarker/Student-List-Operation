module com.example.studentlistoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentlistoperation to javafx.fxml;
    exports com.example.studentlistoperation;
}