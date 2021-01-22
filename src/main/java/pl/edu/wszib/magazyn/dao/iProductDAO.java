package pl.edu.wszib.magazyn.dao;

import pl.edu.wszib.magazyn.model.Product;

import java.util.List;

public interface iProductDAO {

    List<Product> getAllProducts();
    Product getProductByID(int id);
    Product getProductByName(String name);
    boolean persistProduct(Product product);
    boolean updateProduct(Product product);
}
