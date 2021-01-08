package pl.edu.wszib.magazyn.model;

import java.sql.ResultSet;

public class User {

    private int id;
    private String login;
    private String pass;
    private User.Role rola;

    public User() {
    }

    public User(String login, String pass, User.Role rola) {
        this.id = 0;
        this.login = login;
        this.pass = pass;
        this.rola = rola;
    }

    public User(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.login = resultSet.getString("login");
            this.pass = resultSet.getString("pass");
            this.rola = User.Role.valueOf(resultSet.getString("rola"));
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

    public Role getRola() {
        return this.rola;
    }

    public void setRola(User.Role rola) {
        this.rola = rola;
    }

    public enum Role {
        ADMIN,
        RESUPPLIER,
        USER
    }
}
