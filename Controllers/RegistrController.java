package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RegistrController {

    @FXML
    private PasswordField signUpFirstPassword;

    @FXML
    private PasswordField signUpSecondPassword;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpSurname;

    @FXML
    private TextField signUpEmail;

    @FXML
    private TextField signUpPhoneNumber;

    @FXML
    private TextField signUpNickName;

    @FXML
    private RadioButton maleButton;

    @FXML
    private RadioButton femaleButton;

    @FXML
    private Button signUpButton;


    //
    @FXML
    void initialize(){

        signUpButton.setOnAction(event -> {
            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DBHandler dbHandler = new DBHandler ();
        String login = signUpNickName.getText();
        String password = signUpFirstPassword.getText();
        String name = signUpName.getText();
        String surname = signUpSurname.getText();
        String email = signUpEmail.getText();
        String phonenumber = signUpPhoneNumber.getText();
        String gender = "";
       if (maleButton.isSelected()){
             gender = "мужской";
             }else {
          gender = "женский";
       }

        User user = new User(login, password, name, surname, email, phonenumber, gender);

        dbHandler.signUpUsers(user);


    }
}
