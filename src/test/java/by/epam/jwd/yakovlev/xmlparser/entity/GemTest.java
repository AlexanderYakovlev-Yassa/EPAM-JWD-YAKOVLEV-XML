package by.epam.jwd.yakovlev.xmlparser.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class GemTest {

    @Test
    public void equalsTest() {

        Gem gem1 = getGem();
        Gem gem2 = getGem();
        Gem gem3 = getGem();

        gem3.setPurchaseDate(null);

        Assert.assertTrue(gem1.equals(gem2));
        Assert.assertFalse(gem1.equals(gem3));
    }

    @Test
    public void hashCodeTest() {

        Gem gem1 = getGem();
        Gem gem2 = getGem();
        Gem gem3 = getGem();

        gem3.setPurchaseDate(null);

        Assert.assertTrue(gem1.hashCode() == gem2.hashCode());
        Assert.assertFalse(gem1.hashCode() == gem3.hashCode());
    }

    private Gem getGem(){

        Gem gem = new Gem();

        gem.setId("A36A8766");
        gem.setPreciousness(Preciousness.PRECIOUS);
        gem.setName("diamond");
        gem.setValue(Double.valueOf("25"));
        gem.setColor("yellow");
        gem.setOrigin("SouthAfrica");
        gem.setPurchaseDate(new GregorianCalendar(2020, 01, 21));

        return gem;
    }
}