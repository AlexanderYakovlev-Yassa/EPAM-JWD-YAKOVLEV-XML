package by.epam.jwd.yakovlev.xmlparser.entity;

public enum GemParameters {

    GEM_CLASS_NAME ("gem"),
    TREATED_GEM_CLASS_NAME ("treatedGem"),
    PRECIOUSNESS_TAG ("preciousness"),
    ID_TAG ("id"),
    NAME_TAG ("name"),
    VALUE_TAG ("value"),
    COLOR_TAG ("color"),
    ORIGIN_TAG ("origin"),
    PURCHASE_DATE ("purchaseDate"),
    TRANSLUCENCY ("translucency"),
    FACETS_COUNT ("facetsCount");
    
    private String tagName;

    GemParameters(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
}
