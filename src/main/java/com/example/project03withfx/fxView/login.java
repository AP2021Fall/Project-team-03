package com.example.project03withfx.fxView;


import com.example.project03withfx.HelloApplication;
import com.example.project03withfx.model.Role;
import com.example.project03withfx.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class login {
    public TextField usernameField;
    public PasswordField passwordField;
    public Button loginButton;
    public Label errorLabel;
    public BorderPane pane;
    public AnchorPane left;

    @FXML
    public void initialize(){
        new User ("saba", "sb","1234","","", Role.ADMIN );
    }

    public void login(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.isEmpty() || password.isEmpty()){
            errorLabel.setText("You must fill all the fields!");
            return;
        }
        if(!username.matches("\\w+") || !password.matches("\\w+")){
            errorLabel.setText("Correct the form!");
            return;
        }

        if(User.getUserByUsername(username)==null ||
                !User.getUserByUsername(username).getPassword().equals(password)){
            errorLabel.setText("Wrong username or password!");
            return;
        }

        //errorLabel.setText("You have successfully logged in");
        Alert alert=new Alert(Alert.AlertType.INFORMATION,"login");
        alert.setTitle("login");
        alert.setContentText("login successfully");
        alert.showAndWait();
    }

    public void goToRegister(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Register.fxml"));
        ((Stage) pane.getScene().getWindow()).setScene(new Scene(root));



    }
}
