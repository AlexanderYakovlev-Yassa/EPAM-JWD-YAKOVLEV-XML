package by.epam.jwd.yakovlev.xmlparser.validator;

import by.epam.jwd.yakovlev.xmlparser.exception.XSDValidatorException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class XSDValidatorTest {

    private static final String FILE_XML = "src\\test\\testresources\\Gems.xml";
    private static final String FILE_XSD_XML = "src\\test\\testresources\\GemsXSD.xsd";

    @Test
    public void validateXMLTest() {

        XSDValidator validator = new XSDValidator();

        try {
            validator.validateXML(FILE_XML, FILE_XSD_XML);
        } catch (XSDValidatorException e) {
            Assert.fail();
        }
    }
}