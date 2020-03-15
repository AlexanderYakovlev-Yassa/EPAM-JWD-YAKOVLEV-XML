package by.epam.jwd.yakovlev.xmlparser.command;

import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.exception.RequestSolverException;
import by.epam.jwd.yakovlev.xmlparser.exception.ServiceException;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;
import by.epam.jwd.yakovlev.xmlparser.service.ServiceFactory;
import by.epam.jwd.yakovlev.xmlparser.service.XMLService;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class RequestSolver {

    private static final XMLService XML_SERVICE = ServiceFactory.getXMLService();
    private static final String PARSE_TYPE = "parserType";
    private static final String UNTREATED_GEM_RESULT_SET = "untreatedGemResultSet";
    private static final String TREATED_GEM_RESULT_SET = "treatedGemResultSet";
    private static final String UNTREATED_GEM_COUNT = "untreatedGemCount";
    private static final String TREATED_GEM_COUNT = "treatedGemCount";
    private static final String SOURCE_FILE = "sourceFile";

    private HttpServletRequest request;
    private HttpServletResponse response;

    public RequestSolver(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public Pages solveRequest() throws IOException, ServletException {

        InputStream XMLFileStream = null;
        Pages nextPage = null;

        try {
            XMLFileStream = extractFileStream();
        } catch (IOException | ServletException e) {
            throw new ServletException("read of an XML file is failed or file not submitted");
        }

        Set<Gem> gemsSet = null;

        try {
            gemsSet = getGemList(request, XMLFileStream);
        } catch (XMLParserException | ServiceException | SAXException | RequestSolverException e) {
            throw new ServletException("there are no gems or read of gems is failed");
        }

        if (gemsSet.size() == 0) {
            throw new ServletException("there are no gems or read of gems is failed");
        }

        Set<TreatedGem> treatedGems = new HashSet<>();
        Set<Gem> untreatedGems = new HashSet<>();
        for (Gem gem : gemsSet) {
            if (gem.getClass() == TreatedGem.class) {
                treatedGems.add((TreatedGem) gem);
            } else {
                untreatedGems.add(gem);
            }
        }

        String untreatedGemCount = String.valueOf(untreatedGems.size());
        String treatedGemCount = String.valueOf(treatedGems.size());

        request.setAttribute(UNTREATED_GEM_RESULT_SET, untreatedGems);
        request.setAttribute(TREATED_GEM_RESULT_SET, treatedGems);
        request.setAttribute(UNTREATED_GEM_COUNT, untreatedGemCount);
        request.setAttribute(TREATED_GEM_COUNT, treatedGemCount);

        nextPage = Pages.RESULT;

        return nextPage;
    }

    private Set<Gem> getGemList(HttpServletRequest request, InputStream XMLFileStream)
            throws XMLParserException, SAXException, ServiceException, IOException, RequestSolverException {

        Set<Gem> gemsSet;
        String type = request.getParameter(PARSE_TYPE);
        gemsSet = XML_SERVICE.parseGemXML(XMLFileStream, type);
        return gemsSet;
    }

    private InputStream extractFileStream() throws IOException, ServletException {

        Part part = null;

        part = request.getPart(SOURCE_FILE);
        InputStream XMLFileStream = part.getInputStream();
        return XMLFileStream;
    }
}