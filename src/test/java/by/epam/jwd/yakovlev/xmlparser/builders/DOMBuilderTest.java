package by.epam.jwd.yakovlev.xmlparser.builders;

import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.Preciousness;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.util.DateTimeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class DOMBuilderTest {

    private static final String FILE_XML = "src\\test\\testresources\\Gems.xml";
    private static final String FILE_XSD_XML = "src\\test\\testresources\\GemsXSD.xml";
    private static final DateTimeUtil UTIL = new DateTimeUtil();

    @Test
    public void buildGemsSetPositiveTest() {

        DOMBuilder gemsSet = new DOMBuilder();

        gemsSet.buildGemsSet(FILE_XML);

        Gem expectedGem = getGem();
        TreatedGem expectedTreatedGem = getTreatedGem();


        Assert.assertFalse(gemsSet.getGems().isEmpty());

        Assert.assertTrue(gemsSet.getGems().contains(expectedGem));

        Assert.assertTrue(gemsSet.getGems().contains(expectedTreatedGem));
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

    private TreatedGem getTreatedGem(){

        TreatedGem gem = new TreatedGem();

        gem.setId("A36A8765");
        gem.setPreciousness(Preciousness.PRECIOUS);
        gem.setName("diamond");
        gem.setValue(Double.valueOf("20"));
        gem.setColor("yellow");
        gem.setOrigin("SouthAfrica");
        gem.setPurchaseDate(new GregorianCalendar(2020, 01, 21));
        gem.setTranslucency(70);
        gem.setFacetsCount(32);

        return gem;
    }
}