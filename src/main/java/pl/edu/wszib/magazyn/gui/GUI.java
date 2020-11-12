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
        System.out.println("3. Increment product");
        System.out.println("4. Decrement product");
        System.out.println("5. Exit");


        switch (scanner.nextLine()){
            case "1":
                this.showAllProducts();
                this.showMainMenu();
                break;
            case "2":
                this.showMainMenu();
                break;
            case "3":
                this.showMainMenu();
                break;
            case "4":
                this.showMainMenu();
                break;
            case "5":
                System.exit(0);
            default:
                System.out.println("Wrong Number");
                this.showMainMenu();
                break;
        }

        scanner.close();
    }

    private void showAllProducts(){
        for(Product product : this.dataBase.getAllProducts()){
            System.out.println(product);
        }
    }


}
