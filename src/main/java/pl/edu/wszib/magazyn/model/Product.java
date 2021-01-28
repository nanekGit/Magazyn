package pl.edu.wszib.magazyn.model;

import javax.persistence.*;
import java.sql.ResultSet;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;

    public Product() {
    }

    public Product(String name, int quantity) {
        this.id = 0;
        this.name = name;
        this.quantity = quantity;
    }

    public Product(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.name = resultSet.getString("name");
            this.quantity = resultSet.getInt("quantity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
    }
}
