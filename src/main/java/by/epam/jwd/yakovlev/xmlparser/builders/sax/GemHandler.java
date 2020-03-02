package by.epam.jwd.yakovlev.xmlparser.builders.sax;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.GemParameters;
import by.epam.jwd.yakovlev.xmlparser.entity.Preciousness;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.util.DateTimeUtil;
import org.xml.sax.Attributes;

import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class GemHandler implements ContentHandler{

    private static final DateTimeUtil DATE_TIME_UTIL = new DateTimeUtil();

    private Set<Gem> gems;
    private Gem current = null;
    private GemParameters currentEnum = null;
    private EnumSet<GemParameters> parametersRange;

    public GemHandler() {
        gems = new HashSet<Gem>();
        parametersRange = EnumSet.range(GemParameters.ID_TAG, GemParameters.FACETS_COUNT_TAG);
    }

    public Set<Gem> getGems() {
        return gems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if (GemParameters.GEM_CLASS_NAME.getTagName().equals(localName)) {
            current = new Gem();
            current.setId(attrs.getValue(0));

        } else if (GemParameters.TREATED_GEM_CLASS_NAME.getTagName().equals(localName)) {

            current = new TreatedGem();
            current.setId(attrs.getValue(0));

        } else {

            currentEnum = GemParameters.getParameterByTag(localName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (GemParameters.GEM_CLASS_NAME.getTagName().equals(localName) ||
                GemParameters.TREATED_GEM_CLASS_NAME.getTagName().equals(localName)) {
            gems.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String tagValue = new String(ch, start, length).trim();
        if (currentEnum != null) {

            current.setParameter(currentEnum, tagValue);
        }

        currentEnum = null;
    }

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
