package kg.kstu.library_fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kg.kstu.library_fx.model.Author;
import kg.kstu.library_fx.service.AuthorService;
import kg.kstu.library_fx.service.ServiceForUpdate;

public class AddAuthorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCancel;

    @FXML
    private Label labelHeader;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtMiddleName;

    @FXML
    void buttonAddClick(ActionEvent event) {
        if(buttonAdd.getText().equals("Добавить")) {
            if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtMiddleName.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не все поля заполнены!");
                alert.setContentText("Пожалуйста, заполните все поля.");
                alert.showAndWait();
            } else {
                Author author = new Author(txtFirstName.getText(), txtLastName.getText(), txtMiddleName.getText());
                AuthorService authorService = new AuthorService();
                authorService.add(author);
                Stage stage1 = new Stage();

                stage1 = (Stage) buttonAdd.getScene().getWindow();
                stage1.hide();
            }
        } else {
            if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtMiddleName.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не все поля заполнены!");
                alert.setContentText("Пожалуйста, заполните все поля.");
                alert.showAndWait();
            } else {
                Author author = new Author(ServiceForUpdate.getAuthor().getId(), txtFirstName.getText(), txtLastName.getText(), txtMiddleName.getText());
                AuthorService authorService = new AuthorService();
                authorService.update(author);

                ServiceForUpdate.setAuthor(null);

                Stage stage1 = new Stage();
                stage1 = (Stage) buttonAdd.getScene().getWindow();
                stage1.hide();
            }
        }
    }

    @FXML
    void buttonCancelClick(ActionEvent event) {
        ServiceForUpdate.setAuthor(null);
        txtFirstName.setText("");
        txtLastName.setText("");
        txtMiddleName.setText("");

        Stage stage1 = new Stage();
        stage1 = (Stage) buttonCancel.getScene().getWindow();
        stage1.hide();
    }

    @FXML
    void initialize() {
        if(ServiceForUpdate.getAuthor() == null) {
            buttonAdd.setText("Добавить");
        } else {
            buttonAdd.setText("Редактировать");
            txtFirstName.setText(ServiceForUpdate.getAuthor().getFirsName());
            txtLastName.setText(ServiceForUpdate.getAuthor().getLastName());
            txtMiddleName.setText(ServiceForUpdate.getAuthor().getMiddleName());
        }
    }
}
