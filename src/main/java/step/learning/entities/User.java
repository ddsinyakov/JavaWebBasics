package step.learning.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String id;
    private String login;
    private String pass;
    private String name;
    private String salt;
    private String avatar;
    private String email;
    private String emailCode;
    private int emailCodeAttempts;



    public User () {

    }

    public User(ResultSet set) throws SQLException {
        id = set.getString("id");
        login = set.getString("login");
        pass = set.getString("pass");
        name = set.getString("name");
        salt = set.getString("salt");
        avatar = set.getString("avatar");
        email = set.getString("email");
        emailCode = set.getString("email_code");
        emailCodeAttempts = set.getInt("email_code_attempts");
    }

    public int getEmailCodeAttempts() {
        return emailCodeAttempts;
    }

    public User setEmailCodeAttempts(int emailCodeAttempts) {
        this.emailCodeAttempts = emailCodeAttempts;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public User setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public User setEmailCode(String emailCode) {
        this.emailCode = emailCode;
        return this;
    }
}
