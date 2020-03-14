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
    private static final String XSD_SCHEMA = "src\\main\\resources\\XSDSchema\\GemsXSD.xsd";

    public void validateXMLFile(InputStream XMLFileStream) throws XSDValidatorException {
        System.out.println("XMLFileStream is null " + (XMLFileStream == null));
        File schemaFile = new File(XSD_SCHEMA);
        System.out.println("schemaFile " + (schemaFile.getAbsoluteFile()));
        try {
            Schema schema = FACTORY.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            System.out.println("validator " + (validator.hashCode()));
            Source source = new StreamSource(XMLFileStream);
            System.out.println("source " + (source.toString()));
            validator.validate(source);
            System.out.println("OK");
        } catch (SAXException | IOException e) {
            System.out.println("XML file is not valid because" + e.getMessage());
            throw new XSDValidatorException("XML file is not valid because" + e.getMessage(), e);
        }
    }
}
