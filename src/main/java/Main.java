import Dao.CustomerDao;
import Enums.Gender;
import Models.Customer;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        Customer c1 = new Customer("Miquel",
                "Vidal Bieto",
                "Vilnius",
                Gender.MALE,
                Date.valueOf("1991-07-24"));

        Customer c2 = new Customer("Pedro",
                "Iglesias Leyva",
                "Vilnius",
                Gender.FEMALE,
                Date.valueOf("1991-07-24"));

        CustomerDao CustomerManager = new CustomerDao();

        CustomerManager.createCustomer(c1);
        CustomerManager.shutDown();




    }
}
