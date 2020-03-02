package by.epam.jwd.yakovlev.xmlparser;

import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;

import java.util.Calendar;

public class TestUtil {

    public void printTreatedGem(TreatedGem tg){
        System.out.println("id " + tg.getId());
        System.out.println("name " + tg.getName());
        System.out.println("preciousness " + tg.getPreciousness());
        System.out.println("color " + tg.getColor());
        System.out.println("origin " + tg.getOrigin());
        System.out.println("value " + tg.getValue());
        System.out.print("purchase date year " + tg.getPurchaseDate().get(Calendar.YEAR));
        System.out.print(" month " + tg.getPurchaseDate().get(Calendar.MONTH));
        System.out.println(" day " + tg.getPurchaseDate().get(Calendar.DAY_OF_MONTH));
        System.out.println("facets " + tg.getFacetsCount());
        System.out.println("translucency " + tg.getTranslucency() + "%");
    }
}
