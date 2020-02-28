package by.epam.jwd.yakovlev.xmlparser.entity;

public enum Preciousness {

    PRECIOUS,
    SEMI_PRECIOUS,
    REGULAR;

    public static Preciousness getInstance(String string){

        Preciousness res = null;

        for (Preciousness p : values()){

            if (string.toUpperCase().equals(p.name())) {
                res = p;
            }
        }

        return res;
    }
}
