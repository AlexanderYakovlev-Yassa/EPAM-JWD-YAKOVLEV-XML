package by.epam.jwd.yakovlev.xmlparser;

import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.Preciousness;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.util.DateTimeUtil;

import java.util.GregorianCalendar;

public class TestEntityCreator {

    private static final DateTimeUtil UTIL = new DateTimeUtil();

    public Gem getTestGem(){

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

    public TreatedGem getTestTreatedGem(){

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
