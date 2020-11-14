package UnitTests;

import enums.Type;
import models.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTests {

    @Test
    public void ProductValidation()
    {
        Product p1 = ProductAssignation();

        Assert.assertEquals(p1.getType(),Type.PHONE);
        Assert.assertEquals(p1.getPrice(),300);
        Assert.assertEquals(p1.getName(),"iPhone");
        Assert.assertEquals(p1.getAmount(),30);

    }


    private Product ProductAssignation()
    {
        return new Product(Type.PHONE,300,"iPhone",30);
    }
}
