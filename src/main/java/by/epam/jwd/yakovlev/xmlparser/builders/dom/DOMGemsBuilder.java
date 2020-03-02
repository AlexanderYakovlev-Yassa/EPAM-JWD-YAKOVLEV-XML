package by.epam.jwd.yakovlev.xmlparser.builders.dom;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.epam.jwd.yakovlev.xmlparser.builders.AbstractGemsBuilder;
import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.GemParameters;
import by.epam.jwd.yakovlev.xmlparser.entity.Preciousness;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;
import by.epam.jwd.yakovlev.xmlparser.util.DateTimeUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMGemsBuilder extends AbstractGemsBuilder {

    private static final DateTimeUtil DATE_TIME_UTIL = new DateTimeUtil();

    private Set<Gem> gems;
    private DocumentBuilder docBuilder;

    public DOMGemsBuilder() throws XMLParserException {
        this.gems = new HashSet<Gem>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XMLParserException("Parser configuration error: " + e, e);
        }
    }

    @Override
    public Set<Gem> getGems() {
        return gems;
    }

    @Override
    public void buildGemsSet(String fileName) throws XMLParserException {

        Document doc = null;

        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            NodeList gemList = root.getElementsByTagName(GemParameters.GEM_CLASS_NAME.getTagName());
            NodeList treatedGemList = root.getElementsByTagName(GemParameters.TREATED_GEM_CLASS_NAME.getTagName());

            for (int i = 0; i < gemList.getLength(); i++) {
                Element gemElement = (Element) gemList.item(i);
                Gem gem = buildGem(gemElement);
                gems.add(gem);
            }

            for (int i = 0; i < treatedGemList.getLength(); i++) {
                Element gemElement = (Element) treatedGemList.item(i);
                Gem gem = buildGem(gemElement);
                gems.add(gem);
            }
        } catch (IOException e) {
            throw new XMLParserException("File error or I/O error: " + e, e);
        } catch (SAXException e) {
            throw new XMLParserException("Parsing failure: " + e, e);
        }
    }

    private Gem buildGem(Element gemElement) {

        Gem gem = null;

        String id = gemElement.getAttribute(GemParameters.ID_TAG.getTagName());
        String name = getElementTextContent(gemElement, GemParameters.NAME_TAG.getTagName());
        Preciousness preciousness = Preciousness.getInstance(getElementTextContent
                (gemElement,  GemParameters.PRECIOUSNESS_TAG.getTagName()));
        String origin = getElementTextContent(gemElement,  GemParameters.ORIGIN_TAG.getTagName());
        String color = getElementTextContent(gemElement,  GemParameters.COLOR_TAG.getTagName());
        double value = Double.valueOf(getElementTextContent(gemElement,  GemParameters.VALUE_TAG.getTagName()));
        String date = getElementTextContent(gemElement,  GemParameters.PURCHASE_DATE_TAG.getTagName());
        GregorianCalendar purchaseDate = DATE_TIME_UTIL.parseToDate(date);

        if (gemElement.getTagName().equals(GemParameters.GEM_CLASS_NAME.getTagName())){
            gem = new Gem();
        }

        if (gemElement.getTagName().equals(GemParameters.TREATED_GEM_CLASS_NAME.getTagName())) {

            TreatedGem treatedGem = new TreatedGem();

            String translucency = getElementTextContent(gemElement,  GemParameters.TRANSLUCENCY_TAG.getTagName());
            String facetsCount = getElementTextContent(gemElement,  GemParameters.FACETS_COUNT_TAG.getTagName());

            treatedGem.setTranslucency(Double.valueOf(translucency));
            treatedGem.setFacetsCount(Integer.valueOf(facetsCount));

            gem = treatedGem;
        }

        gem.setId(id);
        gem.setName(name);
        gem.setPreciousness(preciousness);
        gem.setOrigin(origin);
        gem.setColor(color);
        gem.setValue(value);
        gem.setPurchaseDate(purchaseDate);

        return gem;
    }

    private static String getElementTextContent(Element element, String elementName) {

        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();

        return text;
    }
}
