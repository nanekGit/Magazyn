package pl.edu.wszib.magazyn.database;

import pl.edu.wszib.magazyn.model.Product;

import java.util.List;

public interface IDataBase {
    List<Product> getAllProducts();
}
