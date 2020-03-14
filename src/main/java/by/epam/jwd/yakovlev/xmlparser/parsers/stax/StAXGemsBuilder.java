package by.epam.jwd.yakovlev.xmlparser.parsers.stax;

import by.epam.jwd.yakovlev.xmlparser.parsers.AbstractGemsBuilder;
import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.GemParameters;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXGemsBuilder extends AbstractGemsBuilder {

    private HashSet<Gem> gems = new HashSet<>();
    private XMLInputFactory inputFactory;

    public StAXGemsBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public void buildGemsSet(InputStream XMLFileStream) throws XMLParserException {

        XMLStreamReader reader = null;
        String name;

        try {
            reader = inputFactory.createXMLStreamReader(XMLFileStream);

            while (reader.hasNext()) {

                int type = reader.next();

                if (type == XMLStreamConstants.START_ELEMENT) {

                    if(reader.getLocalName() == GemParameters.GEM_CLASS_NAME.getTagName()){
                        gems.add(buildGem(reader));
                    }
                    if(reader.getLocalName() == GemParameters.TREATED_GEM_CLASS_NAME.getTagName()){
                        gems.add(buildTreatGem(reader));
                    }
                    type = reader.next();
                }
            }
        } catch (XMLStreamException e) {
            throw new XMLParserException("StAX parsing error! " + e.getMessage());
        } finally {
            try {
                if (XMLFileStream != null) {
                    XMLFileStream.close();
                }
            } catch (IOException e) {
                throw new XMLParserException("Impossible close file: "+e);
            }
        }
    }

    private TreatedGem buildTreatGem(XMLStreamReader reader) throws XMLParserException {

        TreatedGem treatedGem = new TreatedGem();

        try {
            treatedGem.setId(reader.getAttributeValue(null, GemParameters.ID_TAG.getTagName()));
            int type = reader.next();
            while (reader.hasNext()) {
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        treatedGem.setParameter(reader.getLocalName(), reader.getElementText());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (reader.getLocalName() == GemParameters.GEM_CLASS_NAME.getTagName() ||
                                reader.getLocalName() == GemParameters.TREATED_GEM_CLASS_NAME.getTagName()) {
                            return treatedGem;
                        }
                        break;
                    }
                }
                type = reader.next();
            }
        } catch (XMLStreamException e){
            throw new XMLParserException("Unknown element in tag treatedGem", e);
        }

        throw new XMLParserException("Unknown element in tag treatedGem");
    }

    private Gem buildGem(XMLStreamReader reader) throws XMLParserException {

        Gem gem = new Gem();

        try {
            gem.setId(reader.getAttributeValue(null, GemParameters.ID_TAG.getTagName()));
            int type = reader.next();
            String name;
            while (reader.hasNext()) {
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        gem.setParameter(reader.getLocalName(), reader.getElementText());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (reader.getLocalName() == GemParameters.GEM_CLASS_NAME.getTagName() ||
                                reader.getLocalName() == GemParameters.TREATED_GEM_CLASS_NAME.getTagName()) {
                            return gem;
                        }
                        break;
                    }
                }
                type = reader.next();
            }
        } catch (XMLStreamException e) {
            throw new XMLParserException("Unknown element in tag gem", e);
        }
        throw new XMLParserException("Unknown element in tag gem");
    }
}
