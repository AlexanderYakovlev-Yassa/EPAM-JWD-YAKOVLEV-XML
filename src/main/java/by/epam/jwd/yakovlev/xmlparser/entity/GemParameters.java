package by.epam.jwd.yakovlev.xmlparser.entity;

public enum GemParameters {

    GEM_CLASS_NAME ("gem"),
    TREATED_GEM_CLASS_NAME ("treatedGem"),
    ID_TAG ("id"),
    PRECIOUSNESS_TAG ("preciousness"),
    NAME_TAG ("name"),
    VALUE_TAG ("value"),
    COLOR_TAG ("color"),
    ORIGIN_TAG ("origin"),
    PURCHASE_DATE_TAG("purchaseDate"),
    TRANSLUCENCY_TAG("translucency"),
    FACETS_COUNT_TAG("facetsCount");
    
    private String tagName;

    GemParameters(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public static GemParameters getParameterByTag(String tagName){

        for (GemParameters gp : values()){

            if (tagName == null) {
                return  null;
            }

            if (gp.tagName == tagName){
                return gp;
            }
        }

        return null;
    }
}
