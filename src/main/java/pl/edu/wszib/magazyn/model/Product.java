package pl.edu.wszib.magazyn.model;

import java.sql.ResultSet;

public class Product {

    private int ID;
    private String Name;
    private int Quantity;

    private Product() {
    }

    public Product(String name, int quantity) {
        this.ID = 0;
        this.Name = name;
        this.Quantity = quantity;
    }

    public Product(ResultSet resultSet) {
        try {
            this.ID = resultSet.getInt("id");
            this.Name = resultSet.getString("name");
            this.Quantity = resultSet.getInt("quantity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Name='" + this.Name + '\'' +
                ", ID=" + this.ID +
                ", Quantity=" + this.Quantity +
                '}';
    }
}
