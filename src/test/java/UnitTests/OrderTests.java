package UnitTests;

import models.Order;
import org.junit.Assert;
import org.junit.Test;

public class OrderTests {

    @Test
    public void OrderValidation()
    {
        Order o1 = OrderAssignation();

        Assert.assertEquals(o1.getCustomerId(),001);
        Assert.assertEquals(o1.getSalesManagerId(),007);
        Assert.assertEquals(o1.getProductId(),002);
        Assert.assertEquals(o1.getFinalPrice(),1200);
        Assert.assertEquals(o1.getAmount(),1);

    }


    public Order OrderAssignation()
    {
        return new Order(001,007,002,1200,1);
    }
}
