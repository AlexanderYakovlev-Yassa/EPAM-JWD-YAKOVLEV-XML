package by.epam.jwd.yakovlev.xmlparser.command;

public enum Pages {

    INDEX("/WEB-INF/views/StartPage.jsp"),
    RESULT("/WEB-INF/views/ResultPage.jsp"),
    ERROR("/WEB-INF/views/ErrorPage.jsp");

    String stringLocation;

    Pages(String stringLocation) {
        this.stringLocation = stringLocation;
    }

    public String getStringLocation() {
        return stringLocation;
    }
}
