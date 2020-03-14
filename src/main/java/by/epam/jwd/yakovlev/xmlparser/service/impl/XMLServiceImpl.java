package by.epam.jwd.yakovlev.xmlparser.service.impl;

import by.epam.jwd.yakovlev.xmlparser.parsers.AbstractGemsBuilder;
import by.epam.jwd.yakovlev.xmlparser.parsers.ParserType;
import by.epam.jwd.yakovlev.xmlparser.parsers.dom.DOMGemsBuilder;
import by.epam.jwd.yakovlev.xmlparser.parsers.sax.SAXGemsBuilder;
import by.epam.jwd.yakovlev.xmlparser.parsers.stax.StAXGemsBuilder;
import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.exception.ServiceException;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;
import by.epam.jwd.yakovlev.xmlparser.service.XMLService;
import org.xml.sax.SAXException;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class XMLServiceImpl implements XMLService {

    @Override
    public Set<Gem> parseGemXML(InputStream XMLFileStream, String type) throws ServiceException {

        if (type == null) {
            throw new ServiceException("There is no parser type");
        }

        if (XMLFileStream == null) {
            throw new ServiceException("There is no file stream");
        }

        Set<Gem> gemsSet = new HashSet<>();

        ParserType parserType = ParserType.valueOf(type.toUpperCase());
        AbstractGemsBuilder gemsBuilder = null;

        switch (parserType){
            case DOM: {
                try {
                    gemsBuilder = new DOMGemsBuilder();
                } catch (XMLParserException e) {
                    throw new ServiceException("DOM parse has failed", e);
                }
            }
            case SAX: {
                try {
                    gemsBuilder = new SAXGemsBuilder();
                } catch (SAXException e) {
                    throw new ServiceException("SAX parse has failed", e);
                }
            }
            case STAX: {
                gemsBuilder = new StAXGemsBuilder();
            }
        }

        try {
            gemsBuilder.buildGemsSet(XMLFileStream);
        } catch (XMLParserException e) {
            throw new ServiceException("Parse has failed", e);
        }

        gemsSet = gemsBuilder.getGems();

        return gemsSet;
    }
}
