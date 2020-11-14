package UnitTests;

import enums.Gender;
import enums.Type;
import models.Customer;
import models.Order;
import models.Product;
import models.SalesManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class CustomerTests {

    /*
    private void MockService()
    {
        Customer c1 = new Customer("Leroy",
                "Jenkins",
                "Gedimino",
                Gender.MALE,
                Date.valueOf("2000-01-01"));
        SalesManager sm1 = new SalesManager("Pedro",
                "Iglesias",
                true);
        Product p1 = new Product(Type.PHONE,
                500,
                "Iphone",
                20);
        Order o1 = new Order(c1.getCustomerId(),
                sm1.getSalesManagerId(),
                p1.getProductId(),
                10,
                1);
    }
    */

    @Test
    public void CustomerValidation()
    {
        Customer c1 = CustomerAssignation();

        Assert.assertEquals("Leroy", c1.getCustomerName());
        Assert.assertEquals("Jenkins", c1.getCustomerSurname());
        Assert.assertEquals("Gedimino", c1.getAddress());
        Assert.assertEquals(Gender.MALE, c1.getGender());
        Assert.assertEquals(Date.valueOf("2000-01-01"), c1.getBirthDate());
    }


    private Customer CustomerAssignation()
    {
        return new Customer("Leroy",
                "Jenkins",
                "Gedimino",
                Gender.MALE,
                Date.valueOf("2000-01-01"));
    }
}
