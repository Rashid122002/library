package kg.kstu.library_fx.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import kg.kstu.library_fx.model.Author;
import kg.kstu.library_fx.model.Book;
import kg.kstu.library_fx.model.Client;
import kg.kstu.library_fx.model.Order;
import kg.kstu.library_fx.service.*;

public class MainpageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Client, String> address_column;

    @FXML
    private TableView<Author> authorTableView;

    @FXML
    private TableColumn<Author, Long> author_id;

    @FXML
    private TableColumn<Author, String> author_last_name;

    @FXML
    private TableColumn<Author, String> author_middle_name;

    @FXML
    private TableColumn<Author, String> author_name;

    @FXML
    private TableColumn<Client, Boolean> black_list_column;

    @FXML
    private TableColumn<Book, Long> book_author_id_column;

    @FXML
    private TableColumn<Order, Long> book_id;

    @FXML
    private TableColumn<Book, Long> book_id_column;

    @FXML
    private TableView<Book> boolTableView;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonAuthors;

    @FXML
    private Button buttonBooks;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonClients;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonOrders;

    @FXML
    private Button buttonSearch;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonSettings;

    @FXML
    private TableView<Client> clientTableView;

    @FXML
    private TableColumn<Order, Long> client_id;

    @FXML
    private TableColumn<Order, LocalDate> date_of_deadline;

    @FXML
    private TableColumn<Order, LocalDate> date_of_issue;

    @FXML
    private TableColumn<Book, LocalDate>  date_of_publication;

    @FXML
    private TableColumn<Book, String>  description;

    @FXML
    private TableColumn<Client, LocalDate>  dob_column;

    @FXML
    private TableColumn<Client, String>  first_name_column;

    @FXML
    private TableColumn<Client, String>  gender;

    @FXML
    private TableColumn<Client, Long>  id_column;

    @FXML
    private Label labelHeader;

    @FXML
    private TableColumn<Client, String>  last_name_column;

    @FXML
    private TableColumn<Client, String> middle_name_column;

    @FXML
    private TableColumn<Book, String> name_column;

    @FXML
    private TableColumn<Order, Long> order_id;

    @FXML
    private TableView<Order> ordertTableView;

    @FXML
    private TableColumn<Client, String>  passport_id_column;

    @FXML
    private TableColumn<Client, String> phone_number_column;

    @FXML
    private TableColumn<Book, String> publishing_house;

    @FXML
    private TableColumn<Book, Boolean> status;

    @FXML
    private TableColumn<Client, String> ticket_column;

    @FXML
    private TableColumn<Book, Integer> pages;

    @FXML
    private TextField txtSearch;

    @FXML
    void buttonAddClick(ActionEvent event) {
        if(labelHeader.getText().equals("Читатели")) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/addclient.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Читатель");
                stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(labelHeader.getText().equals("Книги")) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/addbook.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Книга");
                stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(labelHeader.getText().equals("Авторы")) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/addauthor.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Авторы");
                stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(labelHeader.getText().equals("Заказы")) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/addorder.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Заказы");
                stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void buttonAuthorsClick(ActionEvent event) {
        showTableViewAuthors();
        labelHeader.setText("Авторы");
        labelHeader.setVisible(true);
        buttonClients.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonOrders.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonBooks.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonAuthors.setStyle("-fx-background-color:  #1F618D; -fx-border-color: white");
        txtSearch.setPromptText("Имя");
        txtSearch.setText("");
    }

    @FXML
    void buttonBooksClick(ActionEvent event) {
        showTableViewBooks();
        labelHeader.setText("Книги");
        labelHeader.setVisible(true);
        buttonClients.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonOrders.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonBooks.setStyle("-fx-background-color:  #1F618D; -fx-border-color: white");
        buttonAuthors.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        txtSearch.setPromptText("Название");
        txtSearch.setText("");
    }

    @FXML
    void buttonChangeClick(ActionEvent event) {
        ServiceForUpdate serviceForUpdate = new ServiceForUpdate();
        if(labelHeader.getText().equals("Читатели")) {
            Client client = clientTableView.getSelectionModel().getSelectedItem();
            if(client != null) {
                serviceForUpdate.setClient(client);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/addclient.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.setTitle("Читатель");
                    stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                    stage.setResizable(false);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не выбрана срока для редактирования!");
                alert.setContentText("Пожалуйста, выберите строку, которую хотите редактировать.");
                alert.showAndWait();
            }
        } else if(labelHeader.getText().equals("Книги")) {
            Book book = boolTableView.getSelectionModel().getSelectedItem();
            if(book != null) {
                serviceForUpdate.setBook(book);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/addbook.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.setTitle("Книга");
                    stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                    stage.setResizable(false);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не выбрана срока для редактирования!");
                alert.setContentText("Пожалуйста, выберите строку, которую хотите редактировать.");
                alert.showAndWait();
            }
        } else if(labelHeader.getText().equals("Авторы")) {
            Author author = authorTableView.getSelectionModel().getSelectedItem();
            if(author != null) {
                serviceForUpdate.setAuthor(author);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/addauthor.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.setTitle("Автор");
                    stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                    stage.setResizable(false);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не выбрана срока для редактирования!");
                alert.setContentText("Пожалуйста, выберите строку, которую хотите редактировать.");
                alert.showAndWait();
            }
        } else if(labelHeader.getText().equals("Заказы")) {
            Order order = ordertTableView.getSelectionModel().getSelectedItem();
            if(order != null) {
                serviceForUpdate.setOrder(order);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/addorder.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.setTitle("Заказ");
                    stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
                    stage.setResizable(false);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не выбрана срока для редактирования!");
                alert.setContentText("Пожалуйста, выберите строку, которую хотите редактировать.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void buttonClientsClick(ActionEvent event) {
        showTableViewClients();
        labelHeader.setText("Читатели");
        labelHeader.setVisible(true);
        buttonClients.setStyle("-fx-background-color:  #1F618D; -fx-border-color: white");
        buttonOrders.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonBooks.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonAuthors.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        txtSearch.setPromptText("Имя");
        txtSearch.setText("");
    }

    @FXML
    void buttonDeleteClick(ActionEvent event) {
        if(labelHeader.getText().equals("Читатели")) {
            Client client = clientTableView.getSelectionModel().getSelectedItem();
            if(client != null) {
                ClientService clientDBHandler = new ClientService();
                clientDBHandler.delete(client.getId());
                showTableViewClients();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не выбрана срока для удаления!");
                alert.setContentText("Пожалуйста, выберите строку, которую хотите удалить.");
                alert.showAndWait();
            }
        } else if(labelHeader.getText().equals("Книги")) {
            Book book = boolTableView.getSelectionModel().getSelectedItem();
            if(book != null) {
                BookService bookService = new BookService();
                bookService.delete(book.getId());
                showTableViewBooks();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не выбрана срока для удаления!");
                alert.setContentText("Пожалуйста, выберите строку, которую хотите удалить.");
                alert.showAndWait();
            }
        } else if(labelHeader.getText().equals("Авторы")) {
            Author author = authorTableView.getSelectionModel().getSelectedItem();
            if(author != null) {
                AuthorService authorService = new AuthorService();
                authorService.delete(author.getId());
                showTableViewAuthors();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не выбрана срока для удаления!");
                alert.setContentText("Пожалуйста, выберите строку, которую хотите удалить.");
                alert.showAndWait();
            }
        } else if(labelHeader.getText().equals("Заказы")) {
            Order order = ordertTableView.getSelectionModel().getSelectedItem();
            if(order != null) {
                OrderService orderService = new OrderService();
                orderService.delete(order.getId());
                showTableViewOrders();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Не выбрана срока для удаления!");
                alert.setContentText("Пожалуйста, выберите строку, которую хотите удалить.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void buttonOrdersClick(ActionEvent event) {
        showTableViewOrders();
        labelHeader.setText("Заказы");
        labelHeader.setVisible(true);
        buttonClients.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonOrders.setStyle("-fx-background-color:  #1F618D; -fx-border-color: white");
        buttonBooks.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonAuthors.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        txtSearch.setPromptText("Срок сдачи");
        txtSearch.setText("");
    }

    @FXML
    void buttonSearchClick(ActionEvent event) {
        if(!txtSearch.getText().equals("")) {
            if(labelHeader.getText().equals("Читатели")) {
                ClientService clientService = new ClientService();
                List<Client> list = clientService.getByName(txtSearch.getText());
                ObservableList<Client> observableList = FXCollections.observableArrayList(list);
                clientTableView.setItems(observableList);
            } else if(labelHeader.getText().equals("Книги")) {
                BookService bookService = new BookService();
                List<Book> list = bookService.getByName(txtSearch.getText());
                ObservableList<Book> observableList = FXCollections.observableArrayList(list);
                boolTableView.setItems(observableList);
            } else if(labelHeader.getText().equals("Авторы")) {
                AuthorService authorService = new AuthorService();
                List<Author> list = authorService.getByName(txtSearch.getText());
                ObservableList<Author> observableList = FXCollections.observableArrayList(list);
                authorTableView.setItems(observableList);
            } else if(labelHeader.getText().equals("Заказы")) {
                OrderService orderService = new OrderService();
                List<Order> list = orderService.getByDate(LocalDate.parse(txtSearch.getText()));
                ObservableList<Order> observableList = FXCollections.observableArrayList(list);
                ordertTableView.setItems(observableList);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Заполните поле для поиска!");
            alert.setContentText("Пожалуйста, заполните поле для поиска.");
            alert.showAndWait();
        }
    }

    @FXML
    void buttonUpdateClick(ActionEvent event) {
        if(labelHeader.getText().equals("Читатели")) {
            showTableViewClients();
            txtSearch.setText("");
        } else if(labelHeader.getText().equals("Книги")) {
            showTableViewBooks();
            txtSearch.setText("");
        } else if(labelHeader.getText().equals("Авторы")) {
            showTableViewAuthors();
            txtSearch.setText("");
        } else if(labelHeader.getText().equals("Заказы")) {
            showTableViewOrders();
            txtSearch.setText("");
        }
    }

    @FXML
    void buttonSettingsClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kg/kstu/library_fx/settings.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Настройки");
            stage.getIcons().add(new Image(("D:\\КГТУ\\2 КУРС\\2 СЕМЕСТР\\Учебная практика\\library_fx\\src\\main\\resources\\kg\\kstu\\library_fx\\images\\logo.png")));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        showTableViewClients();
        labelHeader.setText("Читатели");
        labelHeader.setVisible(true);
        buttonClients.setStyle("-fx-background-color:  #1F618D; -fx-border-color: white");
        buttonOrders.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonBooks.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        buttonAuthors.setStyle("-fx-background-color:  #5499C7; -fx-border-color: white");
        txtSearch.setPromptText("Имя");
        txtSearch.setText("");
    }

    public void showTableViewClients() {
        boolTableView.setVisible(false);
        authorTableView.setVisible(false);
        ordertTableView.setVisible(false);

        ClientService clientService = new ClientService();
        List<Client> list = clientService.getAll();
        ObservableList<Client> observableList = FXCollections.observableArrayList(list);

        id_column.setCellValueFactory(new PropertyValueFactory<Client, Long>("id"));
        first_name_column.setCellValueFactory(new PropertyValueFactory<Client, String>("firstName"));
        last_name_column.setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
        middle_name_column.setCellValueFactory(new PropertyValueFactory<Client, String>("middleName"));
        gender.setCellValueFactory(new PropertyValueFactory<Client, String>("gender"));
        dob_column.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dob"));
        address_column.setCellValueFactory(new PropertyValueFactory<Client, String>("address"));
        phone_number_column.setCellValueFactory(new PropertyValueFactory<Client, String>("phoneNumber"));
        passport_id_column.setCellValueFactory(new PropertyValueFactory<Client, String>("passportId"));
        ticket_column.setCellValueFactory(new PropertyValueFactory<Client, String>("ticket"));
        black_list_column.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("isInBlackList"));

        clientTableView.setItems(observableList);
        clientTableView.setVisible(true);
    }

    public void showTableViewBooks() {
        clientTableView.setVisible(false);
        authorTableView.setVisible(false);
        ordertTableView.setVisible(false);

        BookService bookService = new BookService();
        List<Book> list = bookService.getAll();
        ObservableList<Book> observableList = FXCollections.observableArrayList(list);

        book_id_column.setCellValueFactory(new PropertyValueFactory<Book, Long>("id"));
        book_author_id_column.setCellValueFactory(new PropertyValueFactory<Book, Long>("authorId"));
        name_column.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        description.setCellValueFactory(new PropertyValueFactory<Book, String>("description"));
        publishing_house.setCellValueFactory(new PropertyValueFactory<Book, String>("publishingHouse"));
        date_of_publication.setCellValueFactory(new PropertyValueFactory<Book, LocalDate>("authorId"));
        pages.setCellValueFactory(new PropertyValueFactory<Book, Integer>("pages"));
        status.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("status"));

        boolTableView.setItems(observableList);
        boolTableView.setVisible(true);
    }

    public void showTableViewOrders() {
        clientTableView.setVisible(false);
        authorTableView.setVisible(false);
        boolTableView.setVisible(false);

        OrderService orderService = new OrderService();
        List<Order> list = orderService.getAll();
        ObservableList<Order> observableList = FXCollections.observableArrayList(list);

        order_id.setCellValueFactory(new PropertyValueFactory<Order, Long>("id"));
        client_id.setCellValueFactory(new PropertyValueFactory<Order, Long>("clientId"));
        book_id.setCellValueFactory(new PropertyValueFactory<Order, Long>("bookId"));
        date_of_issue.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("dateOfIssue"));
        date_of_deadline.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("dateOfDeadline"));

        ordertTableView.setItems(observableList);
        ordertTableView.setVisible(true);
    }

    public void showTableViewAuthors() {
        clientTableView.setVisible(false);
        boolTableView.setVisible(false);
        ordertTableView.setVisible(false);

        AuthorService authorService = new AuthorService();
        List<Author> list = authorService.getAll();
        ObservableList<Author> observableList = FXCollections.observableArrayList(list);

        author_id.setCellValueFactory(new PropertyValueFactory<Author, Long>("id"));
        author_name.setCellValueFactory(new PropertyValueFactory<Author, String>("firsName"));
        author_last_name.setCellValueFactory(new PropertyValueFactory<Author, String>("lastName"));
        author_middle_name.setCellValueFactory(new PropertyValueFactory<Author, String>("middleName"));

        authorTableView.setItems(observableList);
        authorTableView.setVisible(true);
    }
}

