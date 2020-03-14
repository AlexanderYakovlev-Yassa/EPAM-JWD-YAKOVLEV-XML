package by.epam.jwd.yakovlev.xmlparser.validator;

import by.epam.jwd.yakovlev.xmlparser.exception.XSDValidatorException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XSDValidatorTest {

    private static final String FILE_XML = "src\\test\\testresources\\Gems.xml";

    @Test
    public void validateXMLFileTest() {

        InputStream XMLFileStream = null;

        try {
            XMLFileStream = new FileInputStream(FILE_XML);
        } catch (FileNotFoundException e) {
            Assert.fail();
        }

        XSDValidator validator = new XSDValidator();

        boolean actualResult = false;
        System.out.println("VALIDATOR " + (validator.hashCode()));
        try {
            validator.validateXMLFile(XMLFileStream);
            actualResult = true;
        } catch (XSDValidatorException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }

        Assert.assertTrue(actualResult);
    }
}