package ua.com.mytodo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ua.com.mytodo.dao.UserDao;
import ua.com.mytodo.dao.factory.DaoFactory;
import ua.com.mytodo.dao.impl.UserDaoImpl;
import ua.com.mytodo.model.User;
import ua.com.mytodo.start.AppManager;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private PasswordField rePassword;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnBackToLogin;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnCreate;
    @FXML
    private TextField txtEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnCreate.setOnAction(event -> registration());
        btnBackToLogin.setOnAction(event -> btnBackToLogin());

    }

    private void registration() {

        if(!txtName.getText().isEmpty()&&!txtEmail.getText().isEmpty()&&!password.getText().isEmpty()){
            if(password.getText().equals(rePassword.getText())){
                UserDao userDaoImpl = DaoFactory.getUserDao();
                try {
                    if(userDaoImpl.findByEmail(txtEmail.getText())==null){
                        User user = new User();
                        user.setName(txtName.getText());
                        user.setEmail(txtEmail.getText());
                        user.setPassword(password.getText());
                        userDaoImpl.save(user);
                        toTodos();
                    }else System.out.println("User with such email has already registered");
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }else System.out.println("Passwords don`t match");
        }else System.out.println("Fill all fields");

    }

    private void btnBackToLogin() {
        try {
            new AppManager().getStage().setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void toTodos() {
        try {
            new AppManager().getStage().setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/todos.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
