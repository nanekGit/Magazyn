package pl.edu.wszib.magazyn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.magazyn.dao.iProductDAO;
import pl.edu.wszib.magazyn.model.Product;
import pl.edu.wszib.magazyn.model.User;
import pl.edu.wszib.magazyn.model.view.ProductModel;
import pl.edu.wszib.magazyn.services.iProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements iProductService {

    @Autowired
    iProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }

    @Override
    public Product getProductByID(int id) {
        return this.productDAO.getProductByID(id);
    }

    @Override
    public void resupplyProduct(Product product) {
        Product productFromDB = this.productDAO.getProductByID(product.getID());
        productFromDB.setQuantity(product.getQuantity());
        this.productDAO.resupplyProduct(productFromDB);
    }

    @Override
    public void editProduct(Product product) {
        Product productFromDB = this.productDAO.getProductByID(product.getID());
        productFromDB.setQuantity(product.getQuantity());
        productFromDB.setName(product.getName());
        this.productDAO.editProduct(productFromDB);
    }

    @Override
    public boolean addProduct(ProductModel productModel) {
        if(this.productDAO.getProductByName(productModel.getName()) != null){
            return false;
        }
        Product newProduct = new Product(productModel.getName(), productModel.getQuantity());
        return this.productDAO.persistProduct(newProduct);
    }
}
