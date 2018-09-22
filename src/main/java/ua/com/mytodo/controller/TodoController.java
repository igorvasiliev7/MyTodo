package ua.com.mytodo.controller;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ua.com.mytodo.model.Todo;
import ua.com.mytodo.service.factory.ServiceFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TodoController implements Initializable {

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private TableColumn<Todo, String> txtStatus;
    @FXML
    private TableColumn<Todo, String> dateFinish;
    @FXML
    private TableColumn<Todo, String> dateCreation;
    @FXML
    private TableColumn<Todo, String> txtName;
    @FXML
    private TableView<Todo> todosTable;

    private ObservableList<Todo> todoList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        loadTodos();
    }

    private void init() {
        txtStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCreation.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        dateFinish.setCellValueFactory(new PropertyValueFactory<>("dateFinish"));
        txtName.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    private void loadTodos() {
        final List<Todo> todos = ServiceFactory.getTodoService().findAll();
        todoList.addAll(todos);
        todosTable.setItems(this.todoList);
    }
}
