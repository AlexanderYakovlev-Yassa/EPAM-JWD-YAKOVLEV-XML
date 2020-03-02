package by.epam.jwd.yakovlev.xmlparser.builders.stax;

import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.GemParameters;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXGemsBuilder {

    private HashSet<Gem> gems = new HashSet<>();
    private XMLInputFactory inputFactory;

    public StAXGemsBuilder() {

        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public void buildGemsSet(String fileName) {

        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

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
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file "+fileName+" : "+e);
            }
        }
    }

    private TreatedGem buildTreatGem(XMLStreamReader reader) throws XMLStreamException {

        TreatedGem treatedGem = new TreatedGem();

        treatedGem.setId(reader.getAttributeValue(null, GemParameters.ID_TAG.getTagName()));
        int type = reader.next();
        while (reader.hasNext()) {
            switch (type){
                case XMLStreamConstants.START_ELEMENT: {
                    treatedGem.setParameter(reader.getLocalName(), reader.getElementText());
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    if (reader.getLocalName() == GemParameters.GEM_CLASS_NAME.getTagName() ||
                            reader.getLocalName() == GemParameters.TREATED_GEM_CLASS_NAME.getTagName()){
                        return treatedGem;
                    }
                    break;
                }
            }
            type = reader.next();
        }
        throw new XMLStreamException("Unknown element in tag treatedGem");
    }

    private Gem buildGem(XMLStreamReader reader) throws XMLStreamException {

        Gem gem = new Gem();

        gem.setId(reader.getAttributeValue(null, GemParameters.ID_TAG.getTagName()));
        int type = reader.next();
        String name;
        while (reader.hasNext()) {
            switch (type){
                case XMLStreamConstants.START_ELEMENT: {
                    gem.setParameter(reader.getLocalName(), reader.getElementText());
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    if (reader.getLocalName() == GemParameters.GEM_CLASS_NAME.getTagName() ||
                            reader.getLocalName() == GemParameters.TREATED_GEM_CLASS_NAME.getTagName()){
                        return gem;
                    }
                    break;
                }
            }
            type = reader.next();
        }
        throw new XMLStreamException("Unknown element in tag gem");
    }
}
