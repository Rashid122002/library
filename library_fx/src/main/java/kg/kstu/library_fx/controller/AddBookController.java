package kg.kstu.library_fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kg.kstu.library_fx.model.Book;
import kg.kstu.library_fx.service.BookService;
import kg.kstu.library_fx.service.ServiceForUpdate;

public class AddBookController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCancel;

    @FXML
    private DatePicker dop;

    @FXML
    private Label labelHeader;

    @FXML
    private TextField pages;

    @FXML
    private TextField txtAuthorID;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPublishingHouse;

    @FXML
    private TextField statusTxt;

    @FXML
    void buttonAddClick(ActionEvent event) {
        if(buttonAdd.getText().equals("Добавить")) {
            if(txtAuthorID.getText().equals("") || txtName.getText().equals("") ||
                    txtDescription.getText().equals("") || dop.getValue() ==  null ||
                    txtPublishingHouse.getText().equals("") || pages.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не все поля заполнены!");
                alert.setContentText("Пожалуйста, заполните все поля.");
                alert.showAndWait();
            } else {
                Long author_id = Long.parseLong(txtAuthorID.getText());
                int pages_int = Integer.parseInt(pages.getText());
                Book book = new Book(author_id, txtName.getText(), txtDescription.getText(), txtPublishingHouse.getText(),
                        dop.getValue(), pages_int, true);
                BookService bookService = new BookService();
                bookService.add(book);
                Stage stage1 = new Stage();

                stage1 = (Stage) buttonAdd.getScene().getWindow();
                stage1.hide();
            }
        } else {
            if(txtAuthorID.getText().equals("") || txtName.getText().equals("") ||
                    txtDescription.getText().equals("") || dop.getValue() ==  null ||
                    txtPublishingHouse.getText().equals("") || pages.getText().equals("") || statusTxt.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не все поля заполнены!");
                alert.setContentText("Пожалуйста, заполните все поля.");
                alert.showAndWait();
            } else {
                Long author_id = Long.parseLong(txtAuthorID.getText());
                int pages_int = Integer.parseInt(pages.getText());
                Boolean status = Boolean.parseBoolean(statusTxt.getText());
                Book book = new Book(ServiceForUpdate.getBook().getId(), author_id, txtName.getText(), txtDescription.getText(), txtPublishingHouse.getText(),
                        dop.getValue(), pages_int, status);
                BookService bookService = new BookService();
                bookService.update(book);

                ServiceForUpdate.setBook(null);

                Stage stage1 = new Stage();
                stage1 = (Stage) buttonAdd.getScene().getWindow();
                stage1.hide();
            }
        }
    }

    @FXML
    void buttonCancelClick(ActionEvent event) {
        ServiceForUpdate.setBook(null);
        txtAuthorID.setText("");
        txtName.setText("");
        txtDescription.setText("");
        txtPublishingHouse.setText("");
        dop.setValue(null);
        pages.setText("");

        Stage stage1 = new Stage();
        stage1 = (Stage) buttonCancel.getScene().getWindow();
        stage1.hide();
    }

    @FXML
    void initialize() {
        if(ServiceForUpdate.getBook() == null) {
            buttonAdd.setText("Добавить");
            statusTxt.setVisible(false);
        } else {
            buttonAdd.setText("Редактировать");
            statusTxt.setVisible(true);
            txtAuthorID.setText(ServiceForUpdate.getBook().getAuthorId() + "");
            txtName.setText(ServiceForUpdate.getBook().getName());
            txtDescription.setText(ServiceForUpdate.getBook().getDescription());
            txtPublishingHouse.setText(ServiceForUpdate.getBook().getPublishingHouse());
            dop.setValue(ServiceForUpdate.getBook().getDateOfPublication());
            pages.setText(ServiceForUpdate.getBook().getPages() + "");
            statusTxt.setText(ServiceForUpdate.getBook().isStatus() + "");
        }
    }
}
