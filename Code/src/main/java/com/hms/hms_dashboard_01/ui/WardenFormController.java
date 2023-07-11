package com.hms.hms_dashboard_01.ui;

import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.wardenFormValidator;
import com.hms.hms_dashboard_01.controllers.WardenController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class WardenFormController {
    @FXML
    private TextField wardenAddress;

    @FXML
    private TextField wardenEmail;

    @FXML
    private TextField wardenId;

    @FXML
    private TextField wardenName;

    @FXML
    private TextField wardenPhone;

    public void addWarden() {
        String validationError = WardenController.addWarder(wardenId.getText(), wardenName.getText(), wardenEmail.getText(), wardenAddress.getText(), wardenPhone.getText());
        if (validationError != null) {
            showAlert(validationError);
        } else {
            successClose();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void successClose() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Success");
        alert.setContentText("Warden Added Successfully");
        alert.showAndWait();
    }
}
