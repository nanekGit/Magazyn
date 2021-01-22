package pl.edu.wszib.magazyn.model;

import javax.persistence.*;
import java.sql.ResultSet;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String pass;
    @Enumerated(EnumType.STRING)
    private User.Role role;

    public User() {
    }

    public User(String login, String pass, User.Role rola) {
        this.id = 0;
        this.login = login;
        this.pass = pass;
        this.role = rola;
    }

    public User(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.login = resultSet.getString("login");
            this.pass = resultSet.getString("pass");
            this.role = User.Role.valueOf(resultSet.getString("role"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }

    public enum Role {
        ADMIN,
        RESUPPLIER,
        USER
    }
}
