package by.epam.jwd.yakovlev.xmlparser.validator;

import by.epam.jwd.yakovlev.xmlparser.exception.XSDValidatorException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XSDValidator {

    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static final SchemaFactory FACTORY = SchemaFactory.newInstance(LANGUAGE);

    public void validateXMLFile(InputStream XMLFileStream, File schemaFile) throws XSDValidatorException {

        try {
            Schema schema = FACTORY.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(XMLFileStream);
            validator.validate(source);
        } catch (SAXException | IOException e) {
            throw new XSDValidatorException("XML file is not valid because" + e.getMessage(), e);
        }
    }
}
