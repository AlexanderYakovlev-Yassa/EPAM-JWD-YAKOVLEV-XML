package by.epam.jwd.yakovlev.xmlparser.service;

import by.epam.jwd.yakovlev.xmlparser.service.impl.XMLServiceImpl;

public enum ServiceFactory {

    INSTANCE;

    private static final XMLService SERVICE = new XMLServiceImpl();

    public static XMLService getXMLService() {
        return SERVICE;
    }
}
