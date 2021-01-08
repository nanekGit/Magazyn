package pl.edu.wszib.magazyn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.magazyn.dao.iProductDAO;
import pl.edu.wszib.magazyn.model.Product;
import pl.edu.wszib.magazyn.model.User;
import pl.edu.wszib.magazyn.model.view.ProductModel;
import pl.edu.wszib.magazyn.services.iProductService;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class ProductServiceImpl implements iProductService {

    private final Pattern lengthPattern = Pattern.compile("[ A-Za-z0-9._-]{5}.*");

    @Autowired
    iProductDAO productDAO;

    @Override
    public Pattern getLengthPattern() {
        return lengthPattern;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }

    @Override
    public Product getProductByID(int id) {
        return this.productDAO.getProductByID(id);
    }

    @Override
    public boolean resupplyProduct(Product product) {
        Product productFromDB = this.productDAO.getProductByID(product.getID());
        productFromDB.setQuantity(product.getQuantity());
        return this.productDAO.resupplyProduct(productFromDB);
    }

    @Override
    public int editProduct(Product product) {
        if(this.productDAO.getProductByName(product.getName()) != null){
            return 1;
        }
        Product productFromDB = this.productDAO.getProductByID(product.getID());
        productFromDB.setQuantity(product.getQuantity());
        productFromDB.setName(product.getName());
        if(this.productDAO.editProduct(productFromDB)){
            return 0;
        }
        return 2;
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
