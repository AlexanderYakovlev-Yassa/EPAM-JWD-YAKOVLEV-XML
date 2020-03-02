package by.epam.jwd.yakovlev.xmlparser.builders.stax;

import by.epam.jwd.yakovlev.xmlparser.TestEntityCreator;
import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StAXGemsBuilderTest {

    private static final String FILE_XML = "src\\test\\testresources\\Gems.xml";
    private static final String FILE_XSD_XML = "src\\test\\testresources\\GemsXSD.xml";
    private static final TestEntityCreator TEST_ENTITY_CREATOR = new TestEntityCreator();

    @Test
    public void buildGemsSetTest() {

        StAXGemsBuilder stAXBuilder = null;

        stAXBuilder = new StAXGemsBuilder();

        stAXBuilder.buildGemsSet(FILE_XML);

        Assert.assertFalse(stAXBuilder.getGems().isEmpty());

        Gem expectedGem = TEST_ENTITY_CREATOR.getTestGem();
        TreatedGem expectedTreatedGem = TEST_ENTITY_CREATOR.getTestTreatedGem();

        Assert.assertTrue(stAXBuilder.getGems().contains(expectedGem));

        Assert.assertTrue(stAXBuilder.getGems().contains(expectedTreatedGem));
    }
}