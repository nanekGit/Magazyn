package pl.edu.wszib.magazyn.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.magazyn.database.IDataBase;
import pl.edu.wszib.magazyn.model.Product;

import java.util.Scanner;

@Component
public class GUI implements IGUI {
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public IDataBase dataBase;

    @Override
    public void showMainMenu() {
        System.out.println("1. Show all products");
        System.out.println("2. Add new product");
        System.out.println("3. Resupply product");
        System.out.println("4. Exit");


        switch (scanner.nextLine()) {
            case "1" -> {
                this.showAllProducts();
                this.showMainMenu();
            }
            case "2" -> {
                System.out.println("Product name: ");
                String name = scanner.nextLine();
                System.out.println("Product ID: ");
                int ID = scanner.nextInt();
                System.out.println("Product quantity: ");
                this.addProduct(new Product(name, ID, scanner.nextInt()));
                scanner.nextLine(); //enter
                this.showMainMenu();
            }
            case "3" -> {
                System.out.println("Product name: ");
                String name2 = scanner.nextLine();
                System.out.println("Product ID: ");
                int ID2 = scanner.nextInt();
                System.out.println("Product quantity to increment: ");
                this.resupplyProduct(name2, ID2, scanner.nextInt());
                scanner.nextLine(); //enter
                this.showMainMenu();
            }
            case "4" -> System.exit(0);
            default -> {
                System.out.println("Wrong Number");
                this.showMainMenu();
            }
        }

        scanner.close();
    }

    private void showAllProducts(){
        for(Product product : this.dataBase.getAllProducts()){
            System.out.println(product);
        }
    }

    private void addProduct(Product exemplar){
        if(exemplar.getQuantity()<0){
            System.out.println("You can't add product with negative quantity! Operation failed");
            return;
        }
        for(Product product : this.dataBase.getAllProducts()){
            if(product.getName().equals(exemplar.getName())){
                if(product.getID()==exemplar.getID()){
                    System.out.println("This product already exists in database! Operation failed");
                }else{
                    System.out.println("Product with the same name but different ID detected! Operation failed");
                }
                return;
            }else if(product.getID()==exemplar.getID()){
                System.out.println("Product with the same ID but different name detected! Operation failed");
                return;
            }
        }
        this.dataBase.addProduct(exemplar);
        System.out.println("New product added to database! Operation successful");
    }

    private void resupplyProduct(String name, int ID, int amount){
        for(Product product : this.dataBase.getAllProducts()){
            if(product.getName().equals(name)){
                if(product.getID()==ID){
                    int temp=product.getQuantity()+amount;
                    if(temp<0){
                        System.out.println("Product quantity after operation would be negative! Operation failed");
                    }else{
                        product.setQuantity(temp);
                        System.out.println("Product quantity changed! Operation successful");
                    }
                }else{
                    System.out.println("Product with the same name but different ID detected! Operation failed");
                }
                return;
            }else if(product.getID()==ID){
                System.out.println("Product with the same ID but different name detected! Operation failed");
                return;
            }
        }
        System.out.println("Requested product not found in the database! Operation failed");
    }


}
