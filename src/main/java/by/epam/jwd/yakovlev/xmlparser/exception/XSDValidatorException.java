package by.epam.jwd.yakovlev.xmlparser.exception;

public class XSDValidatorException extends Exception {

    public XSDValidatorException() {
    }

    public XSDValidatorException(String message) {
        super(message);
    }

    public XSDValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public XSDValidatorException(Throwable cause) {
        super(cause);
    }

    public XSDValidatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
