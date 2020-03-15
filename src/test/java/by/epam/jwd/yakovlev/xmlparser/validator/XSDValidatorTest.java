package by.epam.jwd.yakovlev.xmlparser.validator;

import by.epam.jwd.yakovlev.xmlparser.exception.XSDValidatorException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XSDValidatorTest {

    private static final String FILE_XML = "src\\test\\testresources\\Gems.xml";
    private static final String SCHEMA_FILE = "src\\test\\testresources\\GemsXSD.xsd";

    @Test
    public void validateXMLFileTest() {

        InputStream XMLFileStream = null;
        File schemaFile = null;

        try {
            XMLFileStream = new FileInputStream(FILE_XML);
            schemaFile = new File(SCHEMA_FILE);
        } catch (FileNotFoundException e) {
            Assert.fail();
        }

        XSDValidator validator = new XSDValidator();

        boolean actualResult = false;

        try {
            validator.validateXMLFile(XMLFileStream, schemaFile);
            actualResult = true;
        } catch (XSDValidatorException e) {
            Assert.fail();
        }

        Assert.assertTrue(actualResult);
    }
}