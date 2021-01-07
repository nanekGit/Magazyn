package pl.edu.wszib.magazyn.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.magazyn.dao.iProductDAO;
import pl.edu.wszib.magazyn.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements iProductDAO {

    @Autowired
    Connection connection;

    @Override
    public List<Product> getAllProducts() {
        List<Product> books = new ArrayList<>();
        try{
            String sql = "SELECT * FROM product;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                books.add(new Product(resultSet));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Product getProductByID(int id) {
        try{
            String sql = "SELECT * FROM product WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Product(resultSet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        try{
            String sql = "SELECT * FROM product WHERE name = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Product(resultSet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean persistProduct(Product product) {
        try{
            String sql = "INSERT INTO product (name, quantity) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getQuantity());

            if(preparedStatement.executeUpdate()>0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void resupplyProduct(Product product) {
        try{
            String sql = "UPDATE product SET quantity = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getQuantity());
            preparedStatement.setInt(2, product.getID());

            if(preparedStatement.executeUpdate()==0){
                System.out.println("Something went wrong with:\nProductDAOImpl.resupplyProduct(Product product)");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void editProduct(Product product) {
        try{
            String sql = "UPDATE product SET quantity = ?, name = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getQuantity());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getID());

            if(preparedStatement.executeUpdate()==0){
                System.out.println("Something went wrong with:\nProductDAOImpl.editProduct(Product product)");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
