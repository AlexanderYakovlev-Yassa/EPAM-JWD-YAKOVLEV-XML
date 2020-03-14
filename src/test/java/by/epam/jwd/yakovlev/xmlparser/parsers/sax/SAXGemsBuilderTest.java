package by.epam.jwd.yakovlev.xmlparser.parsers.sax;

import by.epam.jwd.yakovlev.xmlparser.TestEntityCreator;
import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SAXGemsBuilderTest {

    private static final String FILE_XML = "src\\test\\testresources\\Gems.xml";
    private static final TestEntityCreator TEST_ENTITY_CREATOR = new TestEntityCreator();

    @Test
    public void buildGemsSet() {

        SAXGemsBuilder gemsBuilder = null;
        InputStream XMLFileStream = null;

        try {
            XMLFileStream = new FileInputStream(FILE_XML);
        } catch (FileNotFoundException e) {
            Assert.fail();
        }

        try {
            gemsBuilder = new SAXGemsBuilder();
        } catch (SAXException e) {
            Assert.fail(e.getMessage());
        }

        Assert.assertNotNull(gemsBuilder);

        try {
            gemsBuilder.buildGemsSet(XMLFileStream);
        } catch (XMLParserException e) {
            Assert.fail();
        }

        Assert.assertFalse(gemsBuilder.getGems().isEmpty());

        Gem expectedGem = TEST_ENTITY_CREATOR.getTestGem();
        TreatedGem expectedTreatedGem = TEST_ENTITY_CREATOR.getTestTreatedGem();

        Assert.assertTrue(gemsBuilder.getGems().contains(expectedGem));

        Assert.assertTrue(gemsBuilder.getGems().contains(expectedTreatedGem));
    }
}