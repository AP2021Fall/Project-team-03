package com.example.project03withfx.fxView;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Register {
    public TextField UsernameField;
    public TextField EmailField;
    public javafx.scene.control.PasswordField PasswordField;
    public javafx.scene.control.PasswordField PasswordConfirmationField;
    public TextField BirthdayField;
    public TextField FullnameField;
    public Button RegisterButtom;
    public Button BackButtom;

    public void register(ActionEvent actionEvent) {
        String username =UsernameField.getText();
        String password1 =PasswordField.getText();
        String password2 =PasswordConfirmationField.getText();
        String Birthday = BirthdayField.getText();
        String fullname = FullnameField.getText();


    }

    public void goToPreviousMenu(ActionEvent actionEvent) {

    }
}
