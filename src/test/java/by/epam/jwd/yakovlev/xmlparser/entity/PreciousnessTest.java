package by.epam.jwd.yakovlev.xmlparser.entity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PreciousnessTest {

    @Test
    public void getInstance() {

        Preciousness expected = Preciousness.PRECIOUS;
        Preciousness actual = Preciousness.getInstance("precious");

        Assert.assertEquals(expected, actual);
    }
}