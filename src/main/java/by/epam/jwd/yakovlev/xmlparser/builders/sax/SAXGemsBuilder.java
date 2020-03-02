package by.epam.jwd.yakovlev.xmlparser.builders.sax;

import by.epam.jwd.yakovlev.xmlparser.builders.AbstractGemsBuilder;
import by.epam.jwd.yakovlev.xmlparser.entity.Gem;

import java.io.IOException;
import java.util.Set;

import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXGemsBuilder extends AbstractGemsBuilder {

    private GemHandler gemHandler;
    private XMLReader reader = XMLReaderFactory.createXMLReader();

    public SAXGemsBuilder() throws SAXException {

        gemHandler = new GemHandler();
        try {

            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemHandler);

        } catch (SAXException e) {
            throw e;
        }
    }

    public SAXGemsBuilder (Set<Gem> gems) throws SAXException {
        super(gems);
    }

    @Override
    public void buildGemsSet(String fileName) throws XMLParserException {

        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            throw new XMLParserException("SAX parser exception: " + e, e);
        } catch (IOException e) {
            throw new XMLParserException("IO exseption: " + e, e);
        }
        gems = gemHandler.getGems();
    }
}
