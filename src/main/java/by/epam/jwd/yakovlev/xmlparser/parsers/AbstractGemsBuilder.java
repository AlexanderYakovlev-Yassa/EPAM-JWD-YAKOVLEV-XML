package by.epam.jwd.yakovlev.xmlparser.parsers;

import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGemsBuilder {

    protected Set<Gem> gems;

    public AbstractGemsBuilder() {
        gems = new HashSet<Gem>();
    }

    public AbstractGemsBuilder(Set<Gem> gems) {
        this.gems = gems;
    }

    public Set<Gem> getGems() {
        return gems;
    }

    abstract public void buildGemsSet(InputStream XMLFileStream) throws XMLParserException;

    protected void setGemParameter(Gem gem, String parameterName, String parameterValue) {

    }
}
