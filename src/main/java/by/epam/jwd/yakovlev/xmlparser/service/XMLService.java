package by.epam.jwd.yakovlev.xmlparser.service;

import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.exception.ServiceException;

import java.io.InputStream;
import java.util.Set;

public interface XMLService {

    Set<Gem> parseGemXML(InputStream XMLFileStream, String type) throws ServiceException;
}
