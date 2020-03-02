package by.epam.jwd.yakovlev.xmlparser.validator;

import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import by.epam.jwd.yakovlev.xmlparser.exception.XSDValidatorException;
import org.xml.sax.SAXException;

public class XSDValidator {

    private Schema schema = null;
    private String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private SchemaFactory factory = SchemaFactory.newInstance(language);

    public void validateXML(String xmlFileName, String xsdFileName) throws XSDValidatorException {

        try {
            schema = factory.newSchema(new File(xsdFileName));
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setSchema(schema);
            SAXParser parser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            throw new XSDValidatorException(xmlFileName + " config error: " + e.getMessage(), e);
        } catch (SAXException e) {
            throw new XSDValidatorException("SAX exception: " + e, e);
        }
    }
}
