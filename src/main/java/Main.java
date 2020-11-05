import Dao.ProductDao;
import Models.Product;
import java.util.List;
import java.util.Scanner;

import static StockManagment.Stock.cleanStock;
import static StockManagment.Stock.createBasicStock;

public class Main {

    public static void main(String[] args) {
        //productManager is the person that is moving the goods from the truck to the storage
        ProductDao productManager = new ProductDao();
        //Scan is what we are going to use to ask the client what they want to do
        Scanner scan = new Scanner(System.in);
        String userInput = new String();

        //We ask the client what to do
        System.out.println("Please, make a choice for our DATABASE, select GET, START, DELETE or FINISH");
        userInput = scan.next();

        /* Requires a validator of the text input by the client */


        /* Requires a while statement to keep asking the client what option does the client want to do*/

        /*The client wants to get ALL the products in the database*/
        if (userInput.equals("GET"))
        {
            List<Product> listOfProducts = productManager.getProducts();
            if (listOfProducts.isEmpty())
            {
                System.out.println("There are no items in the database");
            }
            else
            {
                for (Product product: listOfProducts) {
                    System.out.println(product.getName() + product.getAmount());
                }
            }
        }

        /* The client wants to add the basic products to the database */
        else if(userInput.equals("START"))
        {
            createBasicStock(productManager);
            System.out.println("Objects have been added to the database");
        }

        /* The client wants to remove all the items from the database*/
        else if(userInput.equals("DELETE"))
        {
            List<Product> currentListOfProducts = productManager.getProducts();
            if (currentListOfProducts.isEmpty())
            {
                System.out.println("There are no items to delete");
            }
            else
            {
                cleanStock(productManager);
                System.out.println("Objects have been removed from the database");
            }
        }

        /* The client wants to finish the operations with the database*/
        else if(userInput.equals("FINISH"))
        {
            System.out.println("Thank you for using our database, bye bye");
        }
    }
}
