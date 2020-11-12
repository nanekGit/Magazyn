package pl.edu.wszib.magazyn.model;

public class Product {
    private String Name;
    private int ID;
    private int Quantity;

    private Product() {
    }

    public Product(String name, int ID, int quantity) {
        this.Name = name;
        this.ID = ID;
        this.Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Name='" + Name + '\'' +
                ", ID=" + ID +
                ", Quantity=" + Quantity +
                '}';
    }
}
