package pl.edu.wszib.magazyn.database;

import org.springframework.stereotype.Component;
import pl.edu.wszib.magazyn.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBase implements IDataBase {
    private  List<Product> products = new ArrayList<>();

    public DataBase(){
        this.products.add(new Product("Produkt 1",11,111));
        this.products.add(new Product("Produkt 2",123,222));
        this.products.add(new Product("Produkt 3",15,0));
        this.products.add(new Product("Produkt 4",0,0));
    }

    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }

    @Override
    public void addProduct(Product exemplar) {
        this.products.add(exemplar);
    }
/*
    @Override
    public void resupplyProduct(Product exemplar, int quantity){

    }*/

}
