package UnitTests;

import models.SalesManager;
import org.junit.Assert;
import org.junit.Test;


public class SalesManagerTests {


    @Test
    public void SalesManagerValidation()
    {
        SalesManager sm1 = SalesManagerAssignation();

        Assert.assertEquals("Pedro", sm1.getFirstName());
        Assert.assertEquals("Iglesias", sm1.getLastName());
        Assert.assertEquals(true,sm1.isAvailable());

    }


    private SalesManager SalesManagerAssignation()
    {
        return new SalesManager("Pedro","Iglesias",true);
    }
}
