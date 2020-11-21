import dao.ProductDao;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static stockManagement.Stock.cleanStock;
import static stockManagement.Stock.createBasicStock;

public class Main {
    public static int userInput = 0;
    public static Scanner scan = new Scanner(System.in);
    public static String userChoice;
    public static int totalToPay = 0;
   public static ProductDao productManager = new ProductDao();
  public static  List<Product> stockNow = productManager.getProducts();
   public static List<Product> orderClient = new ArrayList<>();

    public static void main(String[] args) {
        //productManager is the person that is moving the goods from the truck to the storage

        //We ask the client what to do
        addUserInput();
        productDataBaseCommands(productManager);
        addCustomerInput();
        if (userInput == 1) {
            makeAnOrder(productManager);
        } else if (userInput == 2) {
            byeBye(productManager);
        }

    }

    private static void addUserInput() /* Takes user input and validates that it is an integer in the range*/ {
        //create memory item to remember a choice was already made or not
        int memory = 0;
        String value = new String();

        while (memory < 1) {
            userInput = 0;
            System.out.println("Hello, you are in Products Store, select the NUMBER to execute your choice");
            System.out.println("1) SEE All products from your store");
            System.out.println("2) ADD standard products to the store");
            System.out.println("3) DELETE All products from the store");
            System.out.println("4) FINISH Your operation with the store");
            try {
                value = scan.nextLine();
                userInput = Integer.parseInt(value);
                memory = 1;
                if (userInput < 1 || userInput > 4) {
                    System.out.println("Please select an item from the list");
                }
            } catch (Exception ex) {
                System.out.println("You choice was incorrect.");
                System.out.println("-------------------------");
                memory = 0;
            }
        }
    }

    private static void productDataBaseCommands(ProductDao productManager) {
        while (true) {
            switch (userInput) {
                case 1:             /*Client wants to get ALL the products in the database*/
                    List<Product> listOfProducts = productManager.getProducts();
                    if (listOfProducts.isEmpty()) {
                        System.out.println("There are no items in the database");
                    } else {
                        for (Product product : listOfProducts) {
                            System.out.println("Product Name :" + product.getName() + ", Amount: " + product.getAmount());
                        }
                    }
                    break;
                case 2:             /*Client wants to add the basic products to the database*/
                    createBasicStock(productManager);
                    System.out.println("Objects have been added to the database");
                    break;
                case 3:             /*Client wants to remove all items in the database*/
                    List<Product> currentListOfProducts = productManager.getProducts();
                    if (currentListOfProducts.isEmpty()) {
                        System.out.println("There are no items to delete");
                    } else {
                        cleanStock(productManager);
                        System.out.println("Objects have been removed from the database");
                    }
                    break;
                case 4:             /*Client wants to finish operations with database*/
                    System.out.println("Thank you for visiting Products Table, bye bye");
                    break;
            }
            if (userInput != 4) {
                addUserInput();
            } else {
                break;
            }
        }
    }

    private static void addCustomerInput() /* Takes customer input and validates that it is an integer in the range*/ {
        //create memory item to remember a choice was already made or not
        int memory = 0;
        String value = new String();

        while (memory < 1) {
            userInput = 0;
            System.out.println("Hello, you are in Products Store, select the NUMBER to execute your choice");
            System.out.println("1) Purchase");
            System.out.println("2) Exit");
            try {
                value = scan.nextLine();
                userInput = Integer.parseInt(value);
                memory = 1;
                if (userInput < 1 || userInput > 2) {
                    System.out.println("Please select an option from the list");
                }
            } catch (Exception ex) {
                System.out.println("You choice was incorrect.");
                System.out.println("-------------------------");
                memory = 0;
            }
        }
    }

    private static void makeAnOrder(ProductDao productManager) {
        System.out.println("Hello, you are about to make your order. Please, insert the name of the item you want to purchase or insert pay to finish your purchase");
        userChoice = scan.nextLine();




        while (true) {
            switch (userChoice) {
                case "iPhone8":
                    Product product1 = stockNow.get(0);
                    orderClient.add(product1);
                    totalToPay = totalToPay + product1.getPrice();
                    System.out.println("anything else?");
                    makeAnOrder(productManager);


                case "iPhone9":
                    Product product2 = stockNow.get(1);
                    orderClient.add(product2);
                    totalToPay = totalToPay + product2.getPrice();
                    System.out.println("anything else?");
                    makeAnOrder(productManager);

                case "Pay":
                    byeBye(productManager);
                    userChoice = null;


            }

        }

    }

   private static void byeBye(ProductDao productManager){

        for(Product product : orderClient){
           System.out.println("Product Name:" + product.getName() + ", Amount: " + product.getPrice());
        }
       System.out.println("The total amount is " + totalToPay +  " euros");
       System.out.println("Thank you for shopping, see you again soon");
   }
}