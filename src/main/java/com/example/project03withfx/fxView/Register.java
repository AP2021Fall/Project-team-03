package com.example.project03withfx.fxView;

import com.example.project03withfx.model.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.project03withfx.fxView.Menu.databaseController;

public class Register {
    public TextField UsernameField;
    public TextField EmailField;
    public javafx.scene.control.PasswordField PasswordField;
    public javafx.scene.control.PasswordField PasswordConfirmationField;
    public TextField BirthdayField;
    public TextField FullnameField;
    public Button RegisterButtom;
    public Button BackButtom;
    public Label errorLabel;
    public BorderPane pane;
    public void register(ActionEvent actionEvent) {
        String username = UsernameField.getText();
        String password1 = PasswordField.getText();
        String password2 = PasswordConfirmationField.getText();
        String Birthday = BirthdayField.getText();
        String email = EmailField.getText();
        String fullname = FullnameField.getText();
        //
        String roll = String.valueOf(Role.MEMBER);
        if (username.isEmpty() || password1.isEmpty() || password2.isEmpty() || Birthday.isEmpty() || email.isEmpty() || fullname.isEmpty()) {
            errorLabel.setText("please fill in the boxes first !");
            return;

        } else {
            if (!password1.equals(password2)) {
//                System.err.println("Your passwords are not the same!");
                errorLabel.setText("Your passwords are not the same!");

                //   nextMenu = this;
            } else {
                //tabeye register
                String state = databaseController.register(fullname, username, password1, Birthday, email, roll);
                if (state.equalsIgnoreCase("This username is already registered")) {
//                    System.err.println(state);
                    errorLabel.setText("This username is already taken");
                    //nextMenu = this;
                } else if (state.equalsIgnoreCase("Select the password in the following format")) {
//                    System.err.println("Select the password in the following format\n" +
//                            "Minimum 1 and maximum 3 digits at the beginning" +
//                            " - one big character - minimum 3 and maximum 7 small characters");
                    errorLabel.setText("Select the password in the following format");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("wrong password format");
                    alert.setContentText(" Right format :Minimum 1 and maximum 3 digits at the beginning - one big character - minimum 3 and maximum 7 small characters");
                    alert.showAndWait();
                    //   nextMenu = this;
                } else if (state.equalsIgnoreCase("Your registration was successful!")) {
//                    System.out.println(state);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("register");
                    alert.setContentText("register successfully");
                    alert.showAndWait();
                    // nextMenu = this.parent.subMenus.get(4);
                }
            }

        }
    }

    public void goToPreviousMenu(ActionEvent actionEvent) throws IOException {
        System.out.println(getClass().getResource("login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        ((Stage) pane.getScene().getWindow()).setScene(new Scene(root));

    }
}
