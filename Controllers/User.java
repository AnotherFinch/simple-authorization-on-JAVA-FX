package sample.Controllers;

public class User {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phonenumber;
    private String gender;

    public User(String login, String password, String name, String surname, String email, String phonenumber, String gender) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.gender = gender;
    }

    public User(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
