package by.epam.jwd.yakovlev.xmlparser.builders;

import by.epam.jwd.yakovlev.xmlparser.entity.Gem;
import by.epam.jwd.yakovlev.xmlparser.entity.GemParameters;
import by.epam.jwd.yakovlev.xmlparser.entity.Preciousness;
import by.epam.jwd.yakovlev.xmlparser.entity.TreatedGem;
import by.epam.jwd.yakovlev.xmlparser.exception.XMLParserException;
import by.epam.jwd.yakovlev.xmlparser.util.DateTimeUtil;

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

    abstract public void buildGemsSet(String fileName) throws XMLParserException;

    protected void setGemParameter(Gem gem, String parameterName, String parameterValue) {

    }
}
