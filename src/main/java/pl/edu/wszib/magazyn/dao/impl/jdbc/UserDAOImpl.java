package pl.edu.wszib.magazyn.dao.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.magazyn.dao.iUserDAO;
import pl.edu.wszib.magazyn.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//@Repository
public class UserDAOImpl implements iUserDAO {

    @Autowired
    Connection connection;

    @Override
    public User getUserByLogin(String login) {
        try{
            String sql = "SELECT * FROM user WHERE login = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new User(resultSet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean persistUser(User user) {
        try{
            String sql = "INSERT INTO user (login, pass, role) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setString(3, user.getRole().toString());

            if(preparedStatement.executeUpdate()>0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
