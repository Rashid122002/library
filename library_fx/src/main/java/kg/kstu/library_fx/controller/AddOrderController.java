package kg.kstu.library_fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kg.kstu.library_fx.model.Book;
import kg.kstu.library_fx.model.Order;
import kg.kstu.library_fx.service.BookService;
import kg.kstu.library_fx.service.OrderService;
import kg.kstu.library_fx.service.ServiceForUpdate;

public class AddOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCancel;

    @FXML
    private DatePicker dod;

    @FXML
    private DatePicker doo;

    @FXML
    private Label labelHeader;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtClientID;

    @FXML
    void buttonAddClick(ActionEvent event) {
        if(buttonAdd.getText().equals("Добавить")) {
            if(txtClientID.getText().equals("") || txtBookID.getText().equals("") ||
                    doo.getValue() ==  null || dod.getValue() ==  null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не все поля заполнены!");
                alert.setContentText("Пожалуйста, заполните все поля.");
                alert.showAndWait();
            } else {
                Long client_id = Long.parseLong(txtClientID.getText());
                Long book_id = Long.parseLong(txtBookID.getText());
                Order order = new Order(client_id, book_id, doo.getValue(), dod.getValue());
                OrderService orderService = new OrderService();
                orderService.add(order);

                BookService bookService = new BookService();
                Book book = bookService.getById(book_id);
                book.setStatus(false);
                bookService.update(book);

                Stage stage1 = new Stage();
                stage1 = (Stage) buttonAdd.getScene().getWindow();
                stage1.hide();
            }
        } else {
            if(txtClientID.getText().equals("") || txtBookID.getText().equals("") ||
                    doo.getValue() ==  null || dod.getValue() ==  null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не все поля заполнены!");
                alert.setContentText("Пожалуйста, заполните все поля.");
                alert.showAndWait();
            } else {
                Long client_id = Long.parseLong(txtClientID.getText());
                Long book_id = Long.parseLong(txtBookID.getText());
                Order order = new Order(ServiceForUpdate.getOrder().getId(), client_id, book_id, doo.getValue(), dod.getValue());
                OrderService orderService = new OrderService();
                orderService.update(order);

                orderService.update(order);

                ServiceForUpdate.setOrder(null);

                Stage stage1 = new Stage();
                stage1 = (Stage) buttonAdd.getScene().getWindow();
                stage1.hide();
            }
        }
    }

    @FXML
    void buttonCancelClick(ActionEvent event) {
        ServiceForUpdate.setOrder(null);
        txtClientID.setText("");
        txtBookID.setText("");
        doo.setValue(null);
        dod.setValue(null);

        Stage stage1 = new Stage();
        stage1 = (Stage) buttonCancel.getScene().getWindow();
        stage1.hide();
    }

    @FXML
    void initialize() {
        if(ServiceForUpdate.getOrder() == null) {
            buttonAdd.setText("Добавить");
        } else {
            buttonAdd.setText("Редактировать");
            txtClientID.setText(ServiceForUpdate.getOrder().getClientId() + "");
            txtBookID.setText(ServiceForUpdate.getOrder().getBookId() + "");
            doo.setValue(ServiceForUpdate.getOrder().getDateOfIssue());
            dod.setValue(ServiceForUpdate.getOrder().getDateOfDeadline());
        }
    }
}
