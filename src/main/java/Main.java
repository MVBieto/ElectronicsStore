import dao.ProductDao;
import models.Product;

import java.util.List;
import java.util.Scanner;

import static stockManagement.Stock.cleanStock;
import static stockManagement.Stock.createBasicStock;

public class Main {

    public static void main(String[] args) {
        //productManager is the person that is moving the goods from the truck to the storage
        ProductDao productManager = new ProductDao();
        //Scan is what we are going to use to ask the client what they want to do
        Scanner scan = new Scanner(System.in);
        String userInput = null;

        //We ask the client what to do
        System.out.println("Please, make a choice for our DATABASE, select GET, START, DELETE or FINISH");
        userInput = scan.next();

        while (true) {
            while((userInput==null)||(!(userInput.equals("GET")||userInput.equals("START")||(userInput.equals("DELETE")||(userInput.equals("FINISH")))))) {
                System.out.println("Please, make a choice for our DATABASE, select GET, START, DELETE or FINISH");
                userInput = scan.next();
            }
            /*The client wants to get ALL the products in the database*/
            if (userInput.equals("GET")) {
                List<Product> listOfProducts = productManager.getProducts();
                if (listOfProducts.isEmpty()) {
                    System.out.println("There are no items in the database");
                } else {
                    for (Product product : listOfProducts) {
                        System.out.println(product.getName() + product.getAmount());
                    }
                }
                userInput = null;
            }
            /* The client wants to add the basic products to the database */
            else if (userInput.equals("START")) {
                createBasicStock(productManager);
                System.out.println("Objects have been added to the database");
                userInput = null;
            }

            /* The client wants to remove all the items from the database*/
            else if (userInput.equals("DELETE")) {
                List<Product> currentListOfProducts = productManager.getProducts();
                if (currentListOfProducts.isEmpty()) {
                    System.out.println("There are no items to delete");
                } else {
                    cleanStock(productManager);
                    System.out.println("Objects have been removed from the database");
                }
                userInput = null;
            }
            /* The client wants to finish the operations with the database*/
            else if (userInput.equals("FINISH")) {
                System.out.println("Thank you for using our database, bye bye");
                break;
            }
        }
    }
}
