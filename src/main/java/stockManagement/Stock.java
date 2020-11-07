package stockManagement;

import dao.ProductDao;
import enums.Type;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    public static void createBasicStock(ProductDao productManager) {

        List<Product> products = new ArrayList<>();

        products.add(new Product(Type.PHONE, 300, "Iphone8", 50));
        products.add(new Product(Type.PHONE, 500, "Iphone9", 50));
        products.add(new Product(Type.TABLET, 700, "iPad300", 35));
        products.add(new Product(Type.TABLET, 500, "Samsung", 40));
        products.add(new Product(Type.TV, 800, "LG300", 50));
        products.add(new Product(Type.TV, 1300, "Sony690", 50));
        products.add(new Product(Type.TOASTER, 200, "Quemaditas50S", 50));
        products.add(new Product(Type.TOASTER, 100, "Tostadita2000", 50));
        products.add(new Product(Type.SCOOTER, 600, "Sprint", 20));
        products.add(new Product(Type.SCOOTER, 900, "FlightEcoS", 50));

        for (Product product:products) {
            productManager.createProduct(product);
        }
    }

    public static void cleanStock(ProductDao productManager)
    {
        List<Product> currentListOfProducts = productManager.getProducts();

        for (Product product: currentListOfProducts) {
            productManager.deleteProduct(product);
        }
    }


}
