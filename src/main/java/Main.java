import Dao.ProductDao;
import Models.Product;
import Enums.Type;

public class Main {

    public static void main(String[] args) {

        Product product1 = new Product( Type.PHONE, 300, "Iphone8", 50 );
        Product product2 = new Product( Type.PHONE, 500, "Iphone9", 50 );
        Product product3 = new Product( Type.TABLET, 700, "iPad300", 35 );
        Product product4 = new Product( Type.TABLET, 500, "Samsung", 40 );
        Product product5 = new Product( Type.TV, 800, "LG300", 50 );
        Product product6 = new Product( Type.TV, 1300, "Sony690", 50 );
        Product product7 = new Product( Type.TOASTER, 200, "Quemaditas50S", 50 );
        Product product8 = new Product( Type.TOASTER, 100, "Tostadita2000", 50 );
        Product product9 = new Product( Type.SCOOTER, 600, "Sprint", 20 );
        Product product10 = new Product( Type.SCOOTER, 900, "FlightEcoS", 50 );

        ProductDao productManager = new ProductDao();
        productManager.createProduct(product1);


    }
}
