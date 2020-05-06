package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animation.Shake;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthController {

    @FXML
    private Button authSignInButton;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField login_field;

    @FXML
    private Button signUpButton;

    @FXML
    private Hyperlink forgottenPasswordButton;

    @FXML
    void initialize() {

        authSignInButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String passwordText = password_field.getText().trim();

            if (!loginText.equals("") && !passwordText.equals("")){
                loginUser(loginText, passwordText);
            } else {
                System.out.println("не заполнены логин или пароль");
            }
        });

        signUpButton.setOnAction(event -> {
            openNewScene("/sample/view/registration.fxml");
        });
    }

    private void loginUser(String loginText, String passwordText) {
        DBHandler dbHandler = new DBHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1){
            System.out.println("такой есть ");
            openNewScene("/sample/view/app.fxml");


        }else {
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userPassAnim.playAnim();
            userLoginAnim.playAnim();
        }
    }
    public void openNewScene(String window){
        signUpButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("файл не найден");
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }


}