package by.epam.jwd.yakovlev.xmlparser.builders.dom;

import by.epam.jwd.yakovlev.xmlparser.TestEntityCreator;
import by.epam.jwd.yakovlev.xmlparser.builders.dom.DOMGemsBuilder;
import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;
import org.junit.Assert;
import org.junit.Test;

public class DOMGemsBuilderTest {

    private static final String FILE_XML = "src\\test\\testresources\\Gems.xml";
    private static final TestEntityCreator TEST_ENTITY_CREATOR = new TestEntityCreator();

    @Test
    public void buildGemsSetPositiveTest() {

        DOMGemsBuilder gemsSet = null;

        try {
            gemsSet = new DOMGemsBuilder();
        } catch (XMLParserException e) {
            Assert.fail();
        }

        try {
            gemsSet.buildGemsSet(FILE_XML);
        } catch (XMLParserException e) {
            Assert.fail();
        }

        Gem expectedGem = TEST_ENTITY_CREATOR.getTestGem();
        TreatedGem expectedTreatedGem = TEST_ENTITY_CREATOR.getTestTreatedGem();


        Assert.assertFalse(gemsSet.getGems().isEmpty());

        Assert.assertTrue(gemsSet.getGems().contains(expectedGem));

        Assert.assertTrue(gemsSet.getGems().contains(expectedTreatedGem));
    }
}