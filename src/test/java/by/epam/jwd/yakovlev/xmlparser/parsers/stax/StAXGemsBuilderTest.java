package by.epam.jwd.yakovlev.xmlparser.parsers.stax;

import by.epam.jwd.yakovlev.xmlparser.TestEntityCreator;
import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StAXGemsBuilderTest {

    private static final String FILE_XML = "src\\test\\testresources\\Gems.xml";
    private static final TestEntityCreator TEST_ENTITY_CREATOR = new TestEntityCreator();

    @Test
    public void buildGemsSetTest() {

        StAXGemsBuilder stAXBuilder = null;
        InputStream XMLFileStream = null;

        try {
            XMLFileStream = new FileInputStream(FILE_XML);
        } catch (FileNotFoundException e) {
            Assert.fail();
        }

        stAXBuilder = new StAXGemsBuilder();

        try {
            stAXBuilder.buildGemsSet(XMLFileStream);
        } catch (XMLParserException e) {
            Assert.fail();
        }

        Assert.assertFalse(stAXBuilder.getGems().isEmpty());

        Gem expectedGem = TEST_ENTITY_CREATOR.getTestGem();
        TreatedGem expectedTreatedGem = TEST_ENTITY_CREATOR.getTestTreatedGem();

        Assert.assertTrue(stAXBuilder.getGems().contains(expectedGem));

        Assert.assertTrue(stAXBuilder.getGems().contains(expectedTreatedGem));
    }
}