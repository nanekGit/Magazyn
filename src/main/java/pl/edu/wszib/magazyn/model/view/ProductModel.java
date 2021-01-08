package pl.edu.wszib.magazyn.model.view;

//Stworzyłem te klasę jako możliwość rozbudowy systemu, nie wiem czy magazyn coś takiego potrzebuje czy nie
public class ProductModel {

    private String name;
    private int quantity;

    public ProductModel() {
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
        this.quantity = quantity;
    }
}
