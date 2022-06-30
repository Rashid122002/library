package kg.kstu.library_fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kg.kstu.library_fx.model.Client;
import kg.kstu.library_fx.service.ClientService;
import kg.kstu.library_fx.service.ServiceForUpdate;

public class AddClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox FemaleCheckBox;

    @FXML
    private TextField address;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCancel;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField inn;

    @FXML
    private Label labelHeader;

    @FXML
    private CheckBox maleCheckBox;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtMiddleName;

    @FXML
    private TextField blackListTxt;

    @FXML
    void buttonAddClick(ActionEvent event) {
        if(buttonAdd.getText().equals("Добавить")) {
            if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") ||
                    txtMiddleName.getText().equals("") || dob.getValue() ==  null ||
                    address.getText().equals("") || phoneNumber.getText().equals("") ||
                    inn.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не все поля заполнены!");
                alert.setContentText("Пожалуйста, заполните все поля.");
                alert.showAndWait();
            } else {
                String gender;
                if(maleCheckBox.isSelected() == true && FemaleCheckBox.isSelected() == false) {
                    gender = maleCheckBox.getText();
                } else if(maleCheckBox.isSelected() == false && FemaleCheckBox.isSelected() == true) {
                    gender = FemaleCheckBox.getText();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка!");
                    alert.setHeaderText("Выберите один пол!");
                    alert.setContentText("Пожалуйста, выберите только одно значение либо Мужской, либо Женский.");
                    alert.showAndWait();
                    return;
                }
                String ticket = ((Math.random() * ((99999999 - 10000000) + 1)) + 10000000) + "";
                Client client = new Client(txtFirstName.getText(), txtLastName.getText(),
                        txtLastName.getText(), gender, dob.getValue(),
                        address.getText(), phoneNumber.getText(), inn.getText(), ticket, false);
                ClientService clientService = new ClientService();
                clientService.add(client);
                Stage stage1 = new Stage();

                stage1 = (Stage) buttonAdd.getScene().getWindow();
                stage1.hide();
            }
        } else {
            if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") ||
                    txtMiddleName.getText().equals("") || dob.getValue() ==  null ||
                    address.getText().equals("") || phoneNumber.getText().equals("") ||
                    inn.getText().equals("") || blackListTxt.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не все поля заполнены!");
                alert.setContentText("Пожалуйста, заполните все поля.");
                alert.showAndWait();
            } else {
                String gender;
                if(maleCheckBox.isSelected() == true && FemaleCheckBox.isSelected() == false) {
                    gender = maleCheckBox.getText();
                } else if(maleCheckBox.isSelected() == false && FemaleCheckBox.isSelected() == true) {
                    gender = FemaleCheckBox.getText();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка!");
                    alert.setHeaderText("Выберите один пол!");
                    alert.setContentText("Пожалуйста, выберите только одно значение либо Мужской, либо Женский.");
                    alert.showAndWait();
                    return;
                }
                Boolean blacklist = Boolean.parseBoolean(blackListTxt.getText());
                Client client = new Client(ServiceForUpdate.getClient().getId(), txtFirstName.getText(), txtLastName.getText(),
                        txtMiddleName.getText(), gender, dob.getValue(),
                        address.getText(), phoneNumber.getText(), inn.getText(),
                        ServiceForUpdate.getClient().getTicket(), blacklist);
                ClientService clientService = new ClientService();
                clientService.update(client);

                ServiceForUpdate.setClient(null);

                Stage stage1 = new Stage();
                stage1 = (Stage) buttonAdd.getScene().getWindow();
                stage1.hide();
            }
        }
    }

    @FXML
    void buttonCancelClick(ActionEvent event) {
        ServiceForUpdate.setClient(null);
        txtFirstName.setText("");
        txtLastName.setText("");
        txtMiddleName.setText("");
        maleCheckBox.setSelected(false);
        FemaleCheckBox.setSelected(false);
        dob.setValue(null);
        address.setText("");
        phoneNumber.setText("");
        inn.setText("");

        Stage stage1 = new Stage();
        stage1 = (Stage) buttonCancel.getScene().getWindow();
        stage1.hide();
    }

    @FXML
    void initialize() {
        if(ServiceForUpdate.getClient() == null) {
            blackListTxt.setVisible(false);
            buttonAdd.setText("Добавить");
        } else {
            blackListTxt.setVisible(true);
            buttonAdd.setText("Редактировать");
            txtFirstName.setText(ServiceForUpdate.getClient().getFirstName());
            txtLastName.setText(ServiceForUpdate.getClient().getLastName());
            txtMiddleName.setText(ServiceForUpdate.getClient().getMiddleName());
            if(ServiceForUpdate.getClient().getGender().equals("Мужской")) {
                maleCheckBox.setSelected(true);
            } else {
                FemaleCheckBox.setSelected(true);
            }
            dob.setValue(ServiceForUpdate.getClient().getDob());
            address.setText(ServiceForUpdate.getClient().getAddress());
            phoneNumber.setText(ServiceForUpdate.getClient().getPhoneNumber());
            inn.setText(ServiceForUpdate.getClient().getPassportId());
            blackListTxt.setText(ServiceForUpdate.getClient().getIsInBlackList() + "");
        }
    }

}
