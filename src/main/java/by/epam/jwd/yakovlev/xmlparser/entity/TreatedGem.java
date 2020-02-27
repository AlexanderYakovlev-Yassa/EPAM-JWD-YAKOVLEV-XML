package by.epam.jwd.yakovlev.xmlparser.entity;

import java.util.Objects;

public class TreatedGem extends Gem{

    int facetsCount;

    public TreatedGem(Preciousness preciousness, String id, String name, String origin, double value, String color, int translucence, int facetsCount) {
        super(preciousness, id, name, origin, value, color, translucence);
        this.facetsCount = facetsCount;
    }

    public TreatedGem(int facetsCount) {
        this.facetsCount = facetsCount;
    }

    public TreatedGem() {
    }

    public int getFacetsCount() {
        return facetsCount;
    }

    public void setFacetsCount(int facetsCount) {
        this.facetsCount = facetsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        TreatedGem that = (TreatedGem) o;

        return getFacetsCount() == that.getFacetsCount();
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int res = 7;

        res = res + prime * super.hashCode();
        res = res + prime * facetsCount;

        return res;
    }
}
