package by.epam.jwd.yakovlev.xmlparser.exception;

public class RequestSolverException extends Exception{

    public RequestSolverException() {
    }

    public RequestSolverException(String message) {
        super(message);
    }

    public RequestSolverException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestSolverException(Throwable cause) {
        super(cause);
    }

    public RequestSolverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
