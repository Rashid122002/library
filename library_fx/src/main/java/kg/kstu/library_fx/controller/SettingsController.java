package kg.kstu.library_fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kg.kstu.library_fx.HelloApplication;
import kg.kstu.library_fx.model.User;
import kg.kstu.library_fx.service.ServiceForUpdate;
import kg.kstu.library_fx.service.UserService;

public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LogOut;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonChange;

    @FXML
    private Label labelHeader;

    @FXML
    private Label labelHeader1;

    @FXML
    private Label labelHeader11;

    @FXML
    private TextField newPwd;

    @FXML
    private TextField oldPwd;

    @FXML
    void LogOutClick(ActionEvent event) {
        oldPwd.setText("");
        newPwd.setText("");
        Stage stage1 = new Stage();
        stage1 = (Stage) buttonCancel.getScene().getWindow();
        stage1.hide();
        Platform.exit();
    }

    @FXML
    void buttonCancelClick(ActionEvent event) {
        oldPwd.setText("");
        newPwd.setText("");
        Stage stage1 = new Stage();
        stage1 = (Stage) buttonCancel.getScene().getWindow();
        stage1.hide();
    }

    @FXML
    void buttonChangeClick(ActionEvent event) {
        if(oldPwd.getText().equals("") || newPwd.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Заполните поле для поиска!");
            alert.setContentText("Пожалуйста, заполните поле для поиска.");
            alert.showAndWait();
        } else {
            User user = ServiceForUpdate.getUser();
            UserService userService = new UserService();
            if(user.getPassword().equals(oldPwd.getText())) {
                user.setPassword(newPwd.getText());
                userService.update(user);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Информация!");
                alert.setHeaderText("Успешно!");
                alert.setContentText("Пароль был успешно изменен.");
                alert.showAndWait();
                oldPwd.setText("");
                newPwd.setText("");
                Stage stage1 = new Stage();
                stage1 = (Stage) buttonCancel.getScene().getWindow();
                stage1.hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Неверный старый пароль!");
                alert.setContentText("Пожалуйста, введите старый пароль верно.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void initialize() {
    }
}
