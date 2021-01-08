package pl.edu.wszib.magazyn.services;

import pl.edu.wszib.magazyn.model.Product;
import pl.edu.wszib.magazyn.model.view.ProductModel;

import java.util.List;

public interface iProductService {

    List<Product> getAllProducts();
    Product getProductByID(int id);
    boolean resupplyProduct(Product product);
    int editProduct(Product product);
    boolean addProduct(ProductModel productModel);
}
