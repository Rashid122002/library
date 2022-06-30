package kg.kstu.library_fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import kg.kstu.library_fx.animations.Shake;
import kg.kstu.library_fx.model.User;
import kg.kstu.library_fx.service.ServiceForUpdate;
import kg.kstu.library_fx.service.UserService;

public class AuthenticationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelError;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private ImageView warning_image;

    @FXML
    void buttonLoginClick(ActionEvent event) {
        UserService userDBHandler = new UserService();
        String txtUsernameVar = txtUsername.getText();
        String txtPasswordVar = txtPassword.getText();
        if(!txtUsernameVar.equals("")) {
            if(!txtPasswordVar.equals("")) {
                try {
                    User user = userDBHandler.findUserByUsername(txtUsernameVar);
                    String userPasswordStr = user.getPassword();
                    if(userPasswordStr.equals(txtPasswordVar)) {
                        User user1 = userDBHandler.findUserByUsername(txtUsernameVar);
                        ServiceForUpdate.setUser(user1);
                        labelError.setText("Успешный вход!");
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/mainpage.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.setTitle("Главная страница");
                            stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                            stage.setResizable(false);
                            stage.show();
                            Stage stage1 = new Stage();
                            stage1 = (Stage) buttonLogin.getScene().getWindow();
                            stage1.hide();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        showLabel("Неверный пароль!");
                    }
                } catch (Exception ex) {
                    showLabel("Неверное имя пользователя!");
                }
            } else {
                showLabel("Введите пароль!");
            }
        } else {
            showLabel("Введите имя пользователя!");
        }
    }

    public void showLabel(String text) {
        warning_image.setVisible(true);
        labelError.setText(text);
        labelError.setVisible(true);
        Shake labelShake = new Shake(labelError);
        labelShake.playAnim();
    }

    @FXML
    void initialize() {
    }

}
