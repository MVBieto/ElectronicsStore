import Dao.ProductDao;
import Models.Product;
import StockManagment.Stock;

import java.util.List;

public class Main {

    public static void main(String[] args) {

       Stock stock = new Stock();
        List<Product> productList = stock.createBasicStock();


        ProductDao productManager = new ProductDao();

        for (Product product:productList) {

            productManager.createProduct(product);

        }




    }
}
