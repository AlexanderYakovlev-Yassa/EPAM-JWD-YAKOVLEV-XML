package by.epam.jwd.yakovlev.xmlparser.exception;

public class WrongParserType extends Exception {

    public WrongParserType() {
    }

    public WrongParserType(String message) {
        super(message);
    }

    public WrongParserType(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongParserType(Throwable cause) {
        super(cause);
    }

    public WrongParserType(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
