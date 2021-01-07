package pl.edu.wszib.magazyn.model.view;

//Stworzyłem te klasę jako możliwość rozbudowy systemu, nie wiem czy magazyn coś takiego potrzebuje czy nie
public class ProductModel {

    private String Name;
    private int Quantity;

    public ProductModel() {
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
}
