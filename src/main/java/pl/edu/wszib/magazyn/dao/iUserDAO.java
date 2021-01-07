package pl.edu.wszib.magazyn.dao;

import pl.edu.wszib.magazyn.model.User;

public interface iUserDAO {

    User getUserByLogin(String login);
    boolean persistUser(User user);
}
